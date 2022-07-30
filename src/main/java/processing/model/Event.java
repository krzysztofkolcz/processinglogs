package processing.model;

import java.util.Objects;

public class Event {

    String id;

    String type;

    String host;

    long duration;

    boolean alert;

    public Event(String id, String type, String host, long duration, boolean alert) {
	super();
	this.id = id;
	this.type = type;
	this.host = host;
	this.duration = duration;
	this.alert = alert;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
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

    public long getDuration() {
	return duration;
    }

    public void setDuration(long duration) {
	this.duration = duration;
    }

    public boolean isAlert() {
	return alert;
    }

    public void setAlert(boolean alert) {
	this.alert = alert;
    }

    @Override
    public int hashCode() {
	return Objects.hash(alert, duration, host, id, type);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Event other = (Event) obj;
	return alert == other.alert && duration == other.duration && Objects.equals(host, other.host)
		&& Objects.equals(id, other.id) && Objects.equals(type, other.type);
    }

    @Override
    public String toString() {
	return "Event [id=" + id + ", type=" + type + ", host=" + host + ", duration=" + duration + ", alert=" + alert
		+ "]";
    }

}
