package processing.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import processing.entity.EventEntity;
import processing.model.Event;

class EventDaoImplTest {

    @Test
    void test() {
	// given
	EventDao sut = new EventDaoImpl();
	EventEntity eventEntity = new EventEntity("1", false, "APPLICATION_LOG", "12345", 3l);

	Event event1 = new Event("scsmbstgra", "APPLICATION_LOG", "12345", 1l, false);
	Event event2 = new Event("scsmbstgrb", "APPLICATION_LOG", "12345", 9l, true);
	List<Event> events = Arrays.asList(event1, event2);

	// when
	sut.saveAllEvents(events);

	// then
	List<EventEntity> result = sut.findAll();
	assertEquals(2, result.size());
	sut.clearDb();
    }

}
