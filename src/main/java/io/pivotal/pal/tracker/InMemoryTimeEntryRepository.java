package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
     HashMap<Long, TimeEntry> map = new HashMap<Long, TimeEntry>();

    long idval=1L;
    long id = 0;

    public TimeEntry create(TimeEntry timeEntry) {
        id ++;
        TimeEntry savedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        map.put(id, savedTimeEntry);
        return savedTimeEntry;
    }


    public TimeEntry find(long id) {

        return map.get(id);
    }


    public List<TimeEntry> list() {
        List<TimeEntry> timeEntries = new ArrayList(map.values());
        return timeEntries;
    }

    public TimeEntry update(long id, TimeEntry any) {
        TimeEntry updateResponse = map.get(id);
        if (updateResponse == null) {
            return null;
        }
        updateResponse.setDate(any.getDate());
        updateResponse.setHours(any.getHours());
        updateResponse.setProjectId(any.getProjectId());
        updateResponse.setUserId(any.getUserId());

        return updateResponse;
    }

    @Override
    public void delete(long l)
    {
        map.remove(l);
    }




}
