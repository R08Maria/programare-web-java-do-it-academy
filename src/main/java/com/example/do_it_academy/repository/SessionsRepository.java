package com.example.do_it_academy.repository;

import com.example.do_it_academy.exception.*;
import com.example.do_it_academy.model.Leads;
import com.example.do_it_academy.model.Sessions;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SessionsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SessionsRepository(final DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public static final RowMapper<Sessions> sessionsMapper = new RowMapper<Sessions>() {
        @Override
        public Sessions mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Sessions(resultSet.getInt("id"),
                    resultSet.getInt("id_instructor"),
                    resultSet.getInt("id_course"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("live"),
                    resultSet.getTimestamp("start_date").toLocalDateTime(),
                    resultSet.getInt("price"),
                    resultSet.getInt("capacity")
            );
        }
    };

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
                    resultSet.getString("conversation_summary")
            );
        }
    };

    //list all sessions from given date
    public List<Sessions> getSessions(LocalDateTime start_date) {
        String sql = "select id, id_instructor, id_course, name, live, start_date, price, capacity from sessions ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (start_date != null) {
            sql += "where DATE(start_date) = :start";
            parameterSource.addValue("start", start_date);
        }
        sql += " order by start_date";

        return jdbcTemplate.query(sql, parameterSource, sessionsMapper);
    }

    ;

    //save a new session or update one
    public void saveSessions(Sessions sessions) {
        if (getSessions(sessions.getStart_date())
                .stream().filter(other ->
                        !other.getId().equals(sessions.getId()))
                .findAny()
                .isPresent()
        ) {
            throw new DuplicateSessionsException();
        }

        //update
        String updateSql = "update sessions set "
                + "id_instructor = :id_instructor, "
                + "id_course = :id_course, "
                + "name = :name, "
                + "live = :live, "
                + "start_date = :start_date, "
                + "price = :price, "
                + "capacity = :capacity "
                + "where id = :id";

        //insert
        String insertSql = "insert into sessions (id_instructor, id_course, name, live, start_date, price, capacity)"
                + "values (:id_instructor, :id_course, :name, :live, :start_date, :price, :capacity)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", sessions.getId())
                .addValue("id_instructor", sessions.getId_instructor())
                .addValue("id_course", sessions.getId_course())
                .addValue("name", sessions.getName())
                .addValue("live", sessions.isLive())
                .addValue("start_date", sessions.getStart_date())
                .addValue("price", sessions.getPrice())
                .addValue("capacity", sessions.getCapacity());

        if (jdbcTemplate.update(updateSql, parameterSource) != 1) {
            jdbcTemplate.update(insertSql, parameterSource);
        }
    }

    public void removeSessions(Integer id) {
        String sql = "delete from sessions where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new RemoveSessionsException();

        }
    }

    //list learners from session
    public List<Leads> getLearners(Integer id_session) {
        String sql = "select leads.id, last_name, first_name, phone, email, contact_date, birth_date, conversation_summary " +
                "from learners " +
                "left join leads on learners.id_lead = leads.id " +
                "where id_session = :id_session";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id_session", id_session);
        return jdbcTemplate.query(sql, parameterSource, leadsMapper);
    }

    //add learners at current session
    public void addLearners(Integer id_session, Integer id_lead) {

        String sqlCapacity = "select capacity from sessions where id = :id_session";
        MapSqlParameterSource sqlCapacityParameterSource = new MapSqlParameterSource()
                .addValue("id_session", id_session);
        Integer capacity = jdbcTemplate.queryForObject(sqlCapacity, sqlCapacityParameterSource, Integer.class);

        Integer learnersCount = (int) getLearners(id_session).stream().count();

        if(learnersCount>=capacity){
            throw new FullSessionException();
        }

        if (getLearners(id_session)
                .stream().filter(other ->
                        other.getId().equals(id_lead))
                .findAny()
                .isPresent()
        ) {
            throw new DuplicateLearnerException();
        }

        String sql = "insert into learners (id_session, id_lead)" +
                "values(:id_session, :id_lead)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id_session", id_session)
                .addValue("id_lead", id_lead);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new AddLearnersException();
        }
    }

    public void removeLearners(Integer id_session, Integer id_lead) {
        String sql = "delete from learners where id_session =:id_session and id_lead =:id_lead";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id_session", id_session)
                .addValue("id_learner", id_lead);

        if (jdbcTemplate.update(sql, parameterSource) != 1) {
            throw new RemoveLearnersException();
        }
    }

}
