package processing.dao;

import java.util.List;

import processing.entity.EventEntity;
import processing.model.Event;

public interface EventDao {

    public void saveAllEvents(List<Event> eventList);

    public List<EventEntity> findAll();

    public void clearDb();
}
