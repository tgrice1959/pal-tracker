package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {



    public TimeEntry create(TimeEntry timeEntryToCreate);
    //{
      //   timeEntryMap.put(timeEntryToCreate.getId(),timeEntryToCreate);
      //  return new ResponseEntity( HttpStatus.OK);
    //}

    public TimeEntry find(long l) ;





    public List<TimeEntry> list();
   // {

      //  ArrayList<TimeEntry> listofTimeEntries = new ArrayList<TimeEntry>();


      //  return null;
    //}

    public TimeEntry update(long eq, TimeEntry any);
    //{
    //    return null;
   // }

    public void delete(long l);
    //{
    //    return null;
    //}
}
