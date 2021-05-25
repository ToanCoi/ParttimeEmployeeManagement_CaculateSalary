/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author nguye
 */
public class WorkedShift implements Serializable{
    private int id;
    private Time checkinTime;
    private Time checkoutTime;
    private int hourInShift;
    private int hourOutShift;
    private Date date;
    private String weeksDay;
    private double coefficientsSalary;
    private double hourlyWages;
    private double inShiftSalary;
    private double outShiftSalary;
    private int lateTime;
    private double lateFee;
    private double shiftSalary;
    private ParttimeEmployee employee;
    private Shift shift;

    public WorkedShift() {
    }   

    public WorkedShift(int id, Time checkinTime, Time checkoutTime, int hourInShift, int hourOutShift, Date date, String weeksDay, double coefficientsSalary, double hourlyWages, double inShiftSalary, double outShiftSalary, int lateTime, double lateFee, double shiftSalary, ParttimeEmployee employee, Shift shift) {
        this.id = id;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.hourInShift = hourInShift;
        this.hourOutShift = hourOutShift;
        this.date = date;
        this.weeksDay = weeksDay;
        this.coefficientsSalary = coefficientsSalary;
        this.hourlyWages = hourlyWages;
        this.inShiftSalary = inShiftSalary;
        this.outShiftSalary = outShiftSalary;
        this.lateTime = lateTime;
        this.lateFee = lateFee;
        this.shiftSalary = shiftSalary;
        this.employee = employee;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public Time getCheckinTime() {
        return checkinTime;
    }

    public Time getCheckoutTime() {
        return checkoutTime;
    }

    public int getHourInShift() {
        return hourInShift;
    }

    public int getHourOutShift() {
        return hourOutShift;
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

    public double getInShiftSalary() {
        return inShiftSalary;
    }

    public double getOutShiftSalary() {
        return outShiftSalary;
    }

    public int getLateTime() {
        return lateTime;
    }

    public double getLateFee() {
        return lateFee;
    }

    public double getShiftSalary() {
        return shiftSalary;
    }

    public ParttimeEmployee getEmployee() {
        return employee;
    }

    public Shift getShift() {
        return shift;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCheckinTime(Time checkinTime) {
        this.checkinTime = checkinTime;
    }

    public void setCheckoutTime(Time checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public void setHourInShift(int hourInShift) {
        this.hourInShift = hourInShift;
    }

    public void setHourOutShift(int hourOutShift) {
        this.hourOutShift = hourOutShift;
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

    public void setInShiftSalary(double inShiftSalary) {
        this.inShiftSalary = inShiftSalary;
    }

    public void setOutShiftSalary(double outShiftSalary) {
        this.outShiftSalary = outShiftSalary;
    }

    public void setLateTime(int lateTime) {
        this.lateTime = lateTime;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public void setShiftSalary(double shiftSalary) {
        this.shiftSalary = shiftSalary;
    }

    public void setEmployee(ParttimeEmployee employee) {
        this.employee = employee;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    
}
