package processing.service;

import processing.model.LogLine;

public interface LineParser {

    public LogLine parse(String line);

}
