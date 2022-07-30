package processing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long rowId;

    @Column
    String id;

    @Column(nullable = true)
    String type;

    @Column(nullable = true)
    String host;

    @Column
    long duration;

    @Column
    boolean alert;

    public EventEntity() {
	super();
    }

    public EventEntity(String id, boolean alert, String type, String host, long duration) {
	super();
	this.id = id;
	this.alert = alert;
	this.type = type;
	this.host = host;
	this.duration = duration;
    }

    public long getRowId() {
	return rowId;
    }

    public void setRowId(long rowId) {
	this.rowId = rowId;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public boolean getAlert() {
	return alert;
    }

    public void setAlert(boolean alert) {
	this.alert = alert;
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

    @Override
    public String toString() {
	return "LogEntity [rowId=" + rowId + ", id=" + id + ", alert=" + alert + ", type=" + type + ", host=" + host
		+ ", duration=" + duration + "]";
    }

}
