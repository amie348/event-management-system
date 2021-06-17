package com.example.ems;

public class Event {
    private String Title;
    private String organizer;
    private String Description;
    private String limit;
    private String Date;
    private String budget;
    private String event;
    private String id;





    public Event(String title, String organizer, String description, String limit, String date, String budget , String event ,String id) {
        Title = title;
        this.organizer = organizer;
        Description = description;
        this.limit = limit;
        Date = date;
        this.budget = budget;
        this.event = event;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

