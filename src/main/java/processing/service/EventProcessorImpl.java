package processing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import processing.model.Event;
import processing.model.LogLine;

public class EventProcessorImpl implements EventProcessor {

    Map<String, LogLine> map;
    public static long ALERT_TRESHOLD = 4l;
    List<Event> eventList;
    Logger LOG = LoggerFactory.getLogger(EventProcessorImpl.class);

    public EventProcessorImpl() {
	super();
	this.map = new HashMap<>();
	this.eventList = new ArrayList<>();
    }

    @Override
    public synchronized void processLine(LogLine log) {
	LOG.info("Processing logLine : {}", log);
	if (this.map.containsKey(log.getId())) {
	    LogLine pair = this.map.remove(log.getId());
	    LOG.info("Processing logLine : {} , found pair: {}", log, pair);
	    this.eventList.add(createEvent(log, pair));
	} else {
	    LOG.info("Processing logLine add to map: {}", log);
	    this.map.put(log.getId(), log);
	}

    }

    private Event createEvent(LogLine firstLog, LogLine secondLog) {
	long duration = Math.abs(firstLog.getTimestamp() - secondLog.getTimestamp());
	boolean alert = duration > ALERT_TRESHOLD;
	Event event = new Event(firstLog.getId(), firstLog.getType(), firstLog.getHost(), duration, alert);
	LOG.info("Event from log : {}", event);
	return event;
    }

    public synchronized List<Event> getStoredEventsAndClear() {
	LOG.info("Get and clear stored events");
	List<Event> result = new ArrayList<Event>(this.eventList);
	this.eventList.clear();
	return result;
    }

    public synchronized int getStoredEventsSize() {
	return this.eventList.size();
    }

}
