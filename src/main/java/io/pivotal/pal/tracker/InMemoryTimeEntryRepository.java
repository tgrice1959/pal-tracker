package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    long idval=1L;
    public TimeEntry create(TimeEntry timeEntry) {
         TimeEntry te =  new TimeEntry(idval,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
         idval++;
         return te ;
    }

    @Override
    public TimeEntry find(long l) {
        return new TimeEntry();
    }


    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        any.setId(eq);
        return any;
    }

    @Override
    public ResponseEntity<TimeEntry> delete(long l)
    {
        return new ResponseEntity(new TimeEntry() , HttpStatus.OK );

    }




}
