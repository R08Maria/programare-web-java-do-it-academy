package com.example.do_it_academy.repository;

import com.example.do_it_academy.exception.DuplicateInstructorsException;
import com.example.do_it_academy.exception.RemoveInstructorsException;
import com.example.do_it_academy.model.Instructors;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InstructorsRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public InstructorsRepository(final DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Instructors> instructorsMapper = new RowMapper<Instructors>() {
        @Override
        public Instructors mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Instructors(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"));
        }
    };

    //list instructors
    public List<Instructors> getInstructors(String first_name, String last_name, String phone) {
        String sql = "select id, first_name, last_name, phone, email from instructors ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (first_name != null && last_name != null) {
            sql += "where last_name = :last_name and first_name = :first_name and phone = :phone";
            parameterSource.addValue("first_name", first_name).addValue("last_name", last_name).addValue("phone", phone);
        }
        sql += " order by first_name";
        return jdbcTemplate.query(sql, parameterSource, instructorsMapper);
    }


    //update or save instructors
    public void saveInstructors(Instructors instructors) {
        if (getInstructors(instructors.getFirst_name(), instructors.getLast_name(), instructors.getPhone())
                .stream().filter(other ->
                        !other.getId().equals(instructors.getId()))
                .findAny()
                .isPresent()
        ) {
            throw new DuplicateInstructorsException();
        }

        //update
        String updateSql = "update instructors set "
                + "first_name = :first_name, "
                + "last_name = :last_name, "
                + "phone = :phone, "
                + "email = :email "
                + "where id = :id";

        //insert
        String insertSql = "insert into instructors (first_name, last_name, phone, email)"
                + "values (:first_name, :last_name, :phone, :email)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", instructors.getId())
                .addValue("first_name", instructors.getFirst_name())
                .addValue("last_name", instructors.getLast_name())
                .addValue("phone", instructors.getPhone())
                .addValue("email", instructors.getEmail());

        if (jdbcTemplate.update(updateSql, parameterSource) != 1) {
            jdbcTemplate.update(insertSql, parameterSource);
        }

    }

    public void removeInstructors(Integer id) {
        String sql = "delete from instructors where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new RemoveInstructorsException();

        }
    }
}
