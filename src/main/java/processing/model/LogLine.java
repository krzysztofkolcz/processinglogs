package processing.model;

import java.util.Objects;

public class LogLine {

    String id;

    String state;

    String type;

    String host;

    long timestamp;

    public LogLine(String id, String state, String type, String host, long timestamp) {
	super();
	this.id = id;
	this.state = state;
	this.type = type;
	this.host = host;
	this.timestamp = timestamp;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public long getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
	return Objects.hash(host, id, state, timestamp, type);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	LogLine other = (LogLine) obj;
	return Objects.equals(host, other.host) && Objects.equals(id, other.id) && Objects.equals(state, other.state)
		&& timestamp == other.timestamp && Objects.equals(type, other.type);
    }

    @Override
    public String toString() {
	return "LogLine [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp="
		+ timestamp + "]";
    }

}
