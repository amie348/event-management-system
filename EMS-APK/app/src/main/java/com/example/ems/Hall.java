package com.example.ems;

public class Hall {
    private String hallName;
    private String Location;
    private String Capacity;
    private String floor;
    private String Rent;

    private String id;


    public Hall(String hallName, String location, String capacity, String floor, String rent , String id) {
        this.hallName = hallName;
        Location = location;
        Capacity = capacity;
        this.floor = floor;
        Rent = rent;
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRent() {
        return Rent;
    }

    public void setRent(String rent) {
        Rent = rent;
    }
}
