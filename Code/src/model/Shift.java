/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author nguye
 */
public class Shift implements Serializable{
    private int id;
    private String type;
    private Time startTime;
    private Time endTime;

    public Shift() {
    }

    public Shift(int id, String type, Time startTime, Time endTime) {
        this.id = id;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    
}
