package processing.service;

import com.google.gson.Gson;

import processing.model.LogLine;

public class LineParserImpl implements LineParser {

    private Gson gson;

    public LineParserImpl() {
	super();
	this.gson = new Gson();
    }

    @Override
    public LogLine parse(String line) {
	LogLine log = this.gson.fromJson(line, LogLine.class);
	return log;
    }

}