package processing;

import java.io.IOException;

import processing.dao.EventDao;
import processing.dao.EventDaoImpl;
import processing.service.EventProcessor;
import processing.service.EventProcessorImpl;
import processing.service.LineParser;
import processing.service.LineParserImpl;
import processing.service.Processing;

public class App {

    public static void main(String[] args) {
	String path = args[0];
	LineParser lineParser = new LineParserImpl();
	EventProcessor eventProcessor = new EventProcessorImpl();
	EventDao eventDao = new EventDaoImpl();
	Processing processing = new Processing(lineParser, eventProcessor, eventDao);
	try {
	    processing.read(path);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
