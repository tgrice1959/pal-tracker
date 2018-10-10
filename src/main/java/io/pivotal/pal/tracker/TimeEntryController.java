package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
    }
    @PostMapping(" /time-entries")
    public ResponseEntity create(TimeEntry timeEntryToCreate) {

      //HashMap timeEntryMap = new HashMap();



// Add the time Entry to Map

        return new ResponseEntity(timeEntryToCreate , HttpStatus.OK );
    }

    @GetMapping(" /time-entries")
    public ResponseEntity<TimeEntry> read(long l) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    public ResponseEntity update(long l, TimeEntry expected) {
        return null;
    }

    public ResponseEntity<TimeEntry> delete(long l) {
        return null;
    }
}
