package processing.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import processing.model.Event;
import processing.model.LogLine;
import processing.service.EventProcessorImpl;

class EventProcessorImplTest {

    @Test
    void test() {
	// given
	EventProcessorImpl sut = new EventProcessorImpl();
	LogLine log1 = new LogLine("scsmbstgra", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
	LogLine log2 = new LogLine("scsmbstgra", "STARTED", "APPLICATION_LOG", "12345", 1491377495213l);

	// when
	sut.processLine(log1);

	// then
	assertEquals(0, sut.getStoredEventsSize());

	// when
	sut.processLine(log2);

	// then
	assertEquals(1, sut.getStoredEventsSize());

	// when
	List<Event> eventList = sut.getStoredEventsAndClear();

	// then
	Event event = new Event("scsmbstgra", "APPLICATION_LOG", "12345", 1l, false);
	assertEquals(0, sut.getStoredEventsSize());
	assertEquals(1, eventList.size());
	assertEquals(event, eventList.get(0));
    }

    @Test
    void testManyEvents() {
	// given
	EventProcessorImpl sut = new EventProcessorImpl();
	LogLine log1 = new LogLine("scsmbstgra", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
	LogLine log2 = new LogLine("scsmbstgra", "FINISHED", "APPLICATION_LOG", "12345", 1491377495213l);

	LogLine log3 = new LogLine("scsmbstgrb", "FINISHED", "APPLICATION_LOG", "12345", 1491377495219l);
	LogLine log4 = new LogLine("scsmbstgrb", "STARTED", "APPLICATION_LOG", "12345", 1491377495210l);

	// when
	sut.processLine(log1);
	sut.processLine(log2);
	sut.processLine(log3);
	sut.processLine(log4);

	// then
	assertEquals(2, sut.getStoredEventsSize());

	// when
	List<Event> eventList = sut.getStoredEventsAndClear();

	// then
	Event event1 = new Event("scsmbstgra", "APPLICATION_LOG", "12345", 1l, false);
	Event event2 = new Event("scsmbstgrb", "APPLICATION_LOG", "12345", 9l, true);
	assertEquals(0, sut.getStoredEventsSize());
	assertEquals(2, eventList.size());
	assertThat(eventList, contains(event1, event2));
    }

    // TODO - more tests
}
