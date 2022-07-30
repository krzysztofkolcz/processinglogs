package processing.service;

import java.util.List;

import processing.model.Event;
import processing.model.LogLine;

public interface EventProcessor {

    public void processLine(LogLine log);

    public List<Event> getStoredEventsAndClear();

    public int getStoredEventsSize();
}
