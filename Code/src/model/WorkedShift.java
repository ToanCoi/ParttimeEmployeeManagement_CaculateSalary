/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class WorkedShift {
    private int id;
    private Date checkinTime;
    private Date checkoutTime;
    private Date date;
    private String weeksDay;
    private double coefficientsSalary;
    private double hourlyWages;

    public WorkedShift() {
    }

    public WorkedShift(int id, Date checkinTime, Date checkoutTime, Date date, String weeksDay, double coefficientsSalary, double hourlyWages) {
        this.id = id;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.date = date;
        this.weeksDay = weeksDay;
        this.coefficientsSalary = coefficientsSalary;
        this.hourlyWages = hourlyWages;
    }

    public int getId() {
        return id;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public Date getDate() {
        return date;
    }

    public String getWeeksDay() {
        return weeksDay;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public double getHourlyWages() {
        return hourlyWages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWeeksDay(String weeksDay) {
        this.weeksDay = weeksDay;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public void setHourlyWages(double hourlyWages) {
        this.hourlyWages = hourlyWages;
    }
    
    
}
