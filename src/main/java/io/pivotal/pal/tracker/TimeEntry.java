package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public TimeEntry(long l, long l1, LocalDate parse, int i) {
    }

    public TimeEntry(long l, long l1, long l2, LocalDate parse, int i) {
    }

    public TimeEntry() {

    }


    @Override
    public boolean equals(Object o) {

        // Compare the data members and return accordingly
        TimeEntry c = (TimeEntry) o;
        if ((id == c.id) && (userId == c.userId))
            return true;
        else
            return false;

    }

}