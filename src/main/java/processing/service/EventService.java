package processing.service;

import java.util.List;

import processing.model.Event;

public interface EventService {

    public void saveAllEvents(List<Event> eventList);
}
