package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {




    public TimeEntry create(TimeEntry timeEntryToCreate);
    //{
      //   timeEntryMap.put(timeEntryToCreate.getId(),timeEntryToCreate);
      //  return new ResponseEntity( HttpStatus.OK);
    //}

    public TimeEntry find(long l) ;





    public ResponseEntity<List<TimeEntry>> list();
   // {

      //  ArrayList<TimeEntry> listofTimeEntries = new ArrayList<TimeEntry>();


      //  return null;
    //}

    public TimeEntry update(long eq, TimeEntry any);
    //{
    //    return null;
   // }

    public ResponseEntity<TimeEntry> delete(long l);
    //{
    //    return null;
    //}
}
