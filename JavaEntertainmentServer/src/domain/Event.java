package domain;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    private String eID;
    private String name;
    private String address;
    private int duration;
    private Date eventDate;
    private String eventTime;
    private String status;

    public Event() {
        eID = "";
        name = "";
        address = "";
        duration = 0;
        eventDate = new Date();
        eventTime = "";
        status = "";
    }

    public Event(String eID, String name, String address, int duration, Date eventDate, String eventTime, String status) {
        setEID(eID);
        setName(name);
        setAddress(address);
        setDuration(duration);
        setEventDate(eventDate);
        setEventTime(eventTime);
        setStatus(status);
    }

    public Event(Event e) {
        if (e == null) {
            throw new IllegalArgumentException("Event object cannot be null");
        }
        this.eID = e.eID;
        this.name = e.name;
        this.address = e.address;
        this.duration = e.duration;
        this.eventDate = e.eventDate;
        this.eventTime = e.eventTime;
        this.status = e.status;
    }

    public String getEID() {
        return eID;
    }

    public void setEID(String eID) {
        if (eID == null || eID.trim().isEmpty()) {
            throw new IllegalArgumentException("Event ID cannot be empty");
        }
        this.eID = eID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter the name of the event");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("You must enter an address");
        }
        this.address = address;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("The duration has to be valid");
        }
        this.duration = duration;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        if (eventDate == null) {
            throw new IllegalArgumentException("There must be a date");
        }
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        if (eventTime == null) {
            throw new IllegalArgumentException("There must be a time");
        }
        this.eventTime = eventTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("There must be a status");
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nEvent ID = " + eID +
               "\nName = " + name +
               "\nAddress = " + address +
               "\nDuration = " + duration +
               "\nEvent Date = " + eventDate +
               "\nEvent Time = " + eventTime +
               "\nStatus = " + status;
    }
}
