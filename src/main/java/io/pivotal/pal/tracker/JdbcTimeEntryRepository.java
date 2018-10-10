package io.pivotal.pal.tracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTimeEntryRepository implements TimeEntryRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTimeEntryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public TimeEntry create(TimeEntry timeEntry){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update()

        return timeEntry;
    }

    public TimeEntry find(long findId){

    }

    public List<TimeEntry> list() {
        return null;
    }

    public TimeEntry update(long eq, TimeEntry any) {
        return null;
    }

    public void delete(long l) {

    }

}
