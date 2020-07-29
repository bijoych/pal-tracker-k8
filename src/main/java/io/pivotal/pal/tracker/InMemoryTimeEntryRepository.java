package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap timeEntryMap = new HashMap<Long, TimeEntry>();
    long counter=1L;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry timeEntry1 = new TimeEntry(counter,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryMap.put(counter,timeEntry1);
        counter++;
        return timeEntry1;
    }

    public TimeEntry find(long id) {
        if (timeEntryMap.get(id) != null)
            return (TimeEntry) timeEntryMap.get(id);
        else
            return null;
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntryMap.get(id) != null){
            TimeEntry timeEntry1 = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
            timeEntryMap.put(id, timeEntry1);
            return timeEntry1;
        }
        else
            return null;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
