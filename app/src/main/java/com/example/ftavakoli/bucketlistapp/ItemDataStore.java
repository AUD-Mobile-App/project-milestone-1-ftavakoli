package com.example.ftavakoli.bucketlistapp;

/**
 * Created by FTavakoli on 3/22/18.
 */
//for storing the information of each item

public class ItemDataStore {

    private String name, description, location;
    private boolean status;


    public ItemDataStore() {
    }

    public ItemDataStore(String name, String description, String location, boolean status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
