package io.pivotal.pal.tracker;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class JdbcTimeEntryRepository implements TimeEntryRepository{

    private final JdbcTemplate jdbcTemplate;
    private ResultSetExtractor<TimeEntry> extractor = new ResultSetExtractor<TimeEntry>() {
        @Override
        public TimeEntry extractData(ResultSet rs) throws SQLException, DataAccessException {
            boolean hasnext = rs.next();
            if (hasnext) {
                long id = rs.getLong(1);
                long project_id = rs.getLong(2);
                long user_id = rs.getLong(3);
                LocalDate date = rs.getDate(4).toLocalDate();
                int hours = rs.getInt(5);

                return new TimeEntry(id, project_id, user_id, date, hours);
            }
            else
                return null;
        }
    };

    public JdbcTimeEntryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public TimeEntry create(TimeEntry timeEntry){
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO time_entries (project_id, user_id, date, hours) " +
                            "VALUES (?, ?, ?, ?)",
                    RETURN_GENERATED_KEYS
            );

            statement.setLong(1, timeEntry.getProjectId());
            statement.setLong(2, timeEntry.getUserId());
            statement.setDate(3, Date.valueOf(timeEntry.getDate()));
            statement.setInt(4, timeEntry.getHours());

            return statement;
        }, generatedKeyHolder);

        return find(generatedKeyHolder.getKey().longValue());
    }

    public TimeEntry find(long findId){
        String queryString = "select id, " +
                             "project_id, " +
                             "user_id, date, hours " +
                             "from time_entries where id = ?";
        return jdbcTemplate.query(queryString,
                                  new Object[]{findId},
                                  extractor);

    }

    public List<TimeEntry> list() {
        String queryString = "select id, " +
                "project_id, " +
                "user_id, date, hours " +
                "from time_entries";
        return jdbcTemplate.query(queryString, mapRow);

    }

    public TimeEntry update(long id, TimeEntry any) {
        String queryString = "update time_entries set " +
                "project_id = ?, " +
                "user_id = ?, " +
                "date = ?, " +
                "hours = ? " +
                "where id = ?";
        jdbcTemplate.update(queryString, any.getProjectId(), any.getUserId(), any.getDate(), any.getHours(), id);
        return find(id);
    }

    public void delete(long id) {
        String queryString = "delete from time_entries where id = ?";
        jdbcTemplate.update(queryString, id);
    }

    private final RowMapper<TimeEntry> mapRow = (rs, rowNum) -> new TimeEntry(
            rs.getLong("id"),
            rs.getLong("project_id"),
            rs.getLong("user_id"),
            rs.getDate("date").toLocalDate(),
            rs.getInt("hours")
    );


}
