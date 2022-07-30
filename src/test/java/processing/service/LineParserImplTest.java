package processing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import processing.model.LogLine;
import processing.service.LineParserImpl;

class LineParserImplTest {

    @Test
    void test() {
	// given
	LineParserImpl sut = new LineParserImpl();

	// when
	LogLine logLine = sut.parse(
		"{\"id\":\"scsmbstgra\", \"state\":\"STARTED\", \"type\":\"APPLICATION_LOG\", \"host\":\"12345\", \"timestamp\": 1491377495212}");

	// then
	LogLine expected = new LogLine("scsmbstgra", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
	assertEquals(expected, logLine);
    }

    @Test
    void testNullProperties() {
	// given
	LineParserImpl sut = new LineParserImpl();

	// when
	LogLine logLine = sut.parse("{\"id\":\"scsmbstgra\", \"state\":\"STARTED\", \"timestamp\": 1491377495212}");

	// then
	LogLine expected = new LogLine("scsmbstgra", "STARTED", null, null, 1491377495212l);
	assertEquals(expected, logLine);
    }

    // TODO - more tests
}
