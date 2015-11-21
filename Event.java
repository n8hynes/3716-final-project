package MunSocMan;

import java.util.Date;

public class Event {

    private String name;
    private String description;
    private Date dateTime;
    private String location;

    public Event(String name, String description, Date dateTime, String location) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
