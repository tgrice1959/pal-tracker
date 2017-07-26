package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
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

    private final CounterService counter;
    private final GaugeService gauge;

    public TimeEntryController(TimeEntryRepository timeEntryRepository,
                               CounterService counter,
                               GaugeService gauge) {
        this.timeEntryRepository = timeEntryRepository;
        this.counter = counter;
        this.gauge = gauge;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry results = timeEntryRepository.create(timeEntryToCreate);
        if(results != null){
            counter.increment("TimeEntry.created");
            gauge.submit("timeEntries.count", timeEntryRepository.list().size());
            return new ResponseEntity<>(results,HttpStatus.CREATED);
        }else{
            return null;
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry results = timeEntryRepository.find(id);
        if(results != null){
            counter.increment("TimeEntry.read");
            return new ResponseEntity<>(results, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> results = timeEntryRepository.list();
        if(results != null){
            counter.increment("TimeEntry.list");
            return new ResponseEntity<>(results, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{l}")
    public ResponseEntity<TimeEntry> update(@PathVariable long l, @RequestBody TimeEntry expected) {
        TimeEntry results = timeEntryRepository.update(l, expected);
        if(results == null){
            counter.increment("TimeEntry.updated");
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @DeleteMapping("{l}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long l) {
        counter.increment("TimeEntry.deleted");
        gauge.submit("timeEntries.count", timeEntryRepository.list().size());
        timeEntryRepository.delete(l);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
