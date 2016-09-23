package com.example.samu_pc.iracingapp;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Created by Samu-PC on 20/09/2016.
 */
public class Series {
    private int id;
    private String name;
    private String track;
    private String car;
    private String schedule;
    private String notes;

    public Series(int id, String name, String track, String car, String schedule, String notes) {
        this.id=id;
        this.name = name;
        this.track = track;
        this.car = car;
        this.schedule = schedule;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
