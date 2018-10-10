package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    @Autowired
    TimeEntryRepository timeEntryRepository;


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry results = timeEntryRepository.create(timeEntryToCreate);
        if(results != null){
            return new ResponseEntity<>(results,HttpStatus.CREATED);
        }else{
            return null;
        }

      //HashMap timeEntryMap = new HashMap();


// Add the time Entry to Map

    }

    @GetMapping("{l}")
    public ResponseEntity<TimeEntry> read(@PathVariable long l) {
        TimeEntry results = timeEntryRepository.find(l);
        if(results != null){
            return new ResponseEntity<>(results, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> results = timeEntryRepository.list();
        if(results != null){
            return new ResponseEntity<>(results, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{l}")
    public ResponseEntity<TimeEntry> update(@PathVariable long l, @RequestBody TimeEntry expected) {
        TimeEntry results = timeEntryRepository.update(l, expected);
        if(results == null){
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @DeleteMapping("{l}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long l) {
        timeEntryRepository.delete(l);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
