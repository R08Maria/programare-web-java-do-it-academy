package com.example.do_it_academy.repository;

import com.example.do_it_academy.exception.*;
import com.example.do_it_academy.model.Courses;
import com.example.do_it_academy.model.Leads;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeadsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public LeadsRepository(final DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Leads> leadsMapper = new RowMapper<Leads>() {
        @Override
        public Leads mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Leads(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getTimestamp("contact_date").toLocalDateTime(),
                    resultSet.getTimestamp("birth_date").toLocalDateTime(),
                    resultSet.getString("conversation_summary"));
        }
    };

    public static final RowMapper<Courses> coursesMapper = new RowMapper<Courses>() {
        @Override
        public Courses mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Courses(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("duration"),
                    resultSet.getString("program"),
                    resultSet.getString("description")
                    );
        }
    };

    //list all leads
    public List<Leads> getLeads(String first_name, String last_name, String phone) {
        String sql = "select id, first_name, last_name, phone, email, contact_date, birth_date, conversation_summary from leads ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (first_name != null && last_name != null && phone != null) {
            sql += "where last_name = :last_name and first_name = :first_name and phone = :phone";
            parameterSource.addValue("first_name", first_name).addValue("last_name", last_name).addValue("phone", phone);
        }
        sql += " order by first_name";

        return jdbcTemplate.query(sql, parameterSource, leadsMapper);
    }

    //update or save leads
    public void saveLeads(Leads leads) {
        if (getLeads(leads.getFirst_name(), leads.getLast_name(), leads.getPhone())
                .stream().filter(other ->
                        !other.getId().equals(leads.getId()))
                .findAny()
                .isPresent()
        ) {
            throw new DuplicateLeadException();
        }

        //update
        String updateSql = "update leads set "
                + "first_name = :first_name, "
                + "last_name = :last_name, "
                + "phone = :phone, "
                + "email = :email, "
                + "contact_date = :contact_date, "
                + "birth_date = :birth_date, "
                + "conversation_summary = :conversation_summary "
                + "where id = :id";

        //insert
        String insertSql = "insert into leads (first_name, last_name, phone, email, contact_date, birth_date, conversation_summary)"
                + "values (:first_name, :last_name, :phone, :email, :contact_date, :birth_date, :conversation_summary)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", leads.getId())
                .addValue("first_name", leads.getFirst_name())
                .addValue("last_name", leads.getLast_name())
                .addValue("phone", leads.getPhone())
                .addValue("email", leads.getEmail())
                .addValue("contact_date", leads.getContact_date())
                .addValue("birth_date", leads.getBirth_date())
                .addValue("conversation_summary", leads.getConversation_summary());

        if (jdbcTemplate.update(updateSql, parameterSource) != 1) {
            jdbcTemplate.update(insertSql, parameterSource);
        }

    }

    public void removeLeads(Integer id) {
        String sql = "delete from leads where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new RemoveLeadsException();

        }
    }

    //list preferences
    public List<Courses> getPreferences(Integer id_lead){
        String sql = "select id_course, name, duration, program, description " +
                "from preferences " +
                "left join courses on preferences.id_course = courses.id " +
                "where id_lead = :id_lead";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_lead", id_lead);
        return jdbcTemplate.query(sql, parameterSource, coursesMapper);
    }


    //add preferences for current lead
    public void addPreferences(Integer id_lead, Integer id_course){

        if (getPreferences(id_lead)
                .stream().filter(other ->
                        other.getId().equals(id_course))
                .findAny()
                .isPresent()
        ) {
            throw new DuplicateCourseException();
        }


        //insert
        String sql = "insert into preferinces (id_course, id_lead)"
                + "values (:id_course, :id_lead)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id_leads", id_lead)
                .addValue("id_course", id_course);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new AddLearnersException();
        }

    }

//    remove preferences
public void removePreferences(Integer id_lead, Integer  id_course) {
    String sql = "delete from preferences where id_lead =:id_lead and id_course =:id_course ";
    MapSqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("id_lead", id_lead)
            .addValue("id_course", id_course);

    if (jdbcTemplate.update(sql, parameterSource) != 1) {
        throw new RemoveLearnersException();
    }
}
}
