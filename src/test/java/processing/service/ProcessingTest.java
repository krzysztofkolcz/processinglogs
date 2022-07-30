package processing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import processing.dao.EventDao;
import processing.dao.EventDaoImpl;

class ProcessingTest {

    @Test
    void test() {
	String path = "src/test/resources/logfile.txt";
	LineParser lineParser = new LineParserImpl();
	EventProcessor eventProcessor = new EventProcessorImpl();
	EventDao eventDao = new EventDaoImpl();
	Processing processing = new Processing(lineParser, eventProcessor, eventDao);
	try {
	    processing.read(path);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	eventDao.findAll().forEach(System.out::println);
	assertEquals(8, eventDao.findAll().size());
	eventDao.clearDb();
    }
}
