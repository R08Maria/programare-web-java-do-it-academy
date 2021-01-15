package com.example.do_it_academy.repository;

import com.example.do_it_academy.exception.DuplicateCourseException;
import com.example.do_it_academy.exception.RemoveCoursesException;
import com.example.do_it_academy.model.Courses;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoursesRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CoursesRepository(final DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Courses> coursesMapper = new RowMapper<Courses>() {
        @Override
        public Courses mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Courses(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("duration"),
                    resultSet.getString("program"),
                    resultSet.getString("description"));
        }
    };

    //list courses
    public List<Courses> getCoursesNames(String name) {
        String sql = "select id, name, duration, program, description from courses ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(name != null){
            sql += "where name = :name";
            parameterSource.addValue("name", name);
        }
        sql += " order by name";
        return jdbcTemplate.query(sql, parameterSource, coursesMapper);
    }

    //update or save a course
    public void saveCourses(Courses courses){
        if (getCoursesNames(courses.getName())
            .stream().filter(other ->
                        !other.getId().equals(courses.getId()))
                .findAny()
                .isPresent()
        ){
            throw new DuplicateCourseException();
        }

        //update
        String updateSql = "update courses set "
                + "name = :name, "
                + "duration = :duration, "
                + "program = :program, "
                + "description = :description "
                + "where id = :id";

        //insert
        String insertSql = "insert into courses (name, duration, program, description)"
                + "values (:name, :duration, :program, :description)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", courses.getId())
                .addValue("name", courses.getName())
                .addValue("duration", courses.getDuration())
                .addValue("program", courses.getProgram())
                .addValue("description", courses.getDescription());

        if (jdbcTemplate.update(updateSql, parameterSource) != 1) {
            jdbcTemplate.update(insertSql, parameterSource);
        }
    }

    public void removeCourses(Integer id) {
        String sql = "delete from courses where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new RemoveCoursesException();

        }
    }
}
