/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Salary implements Serializable{
    private int id;
    private int sumHourInShift;
    private int sumHourOutShift;
    private double sumInShiftSalary;
    private double sumOutShiftSalary;
    private int sumLateTime;
    private double sumLateFee;
    private double allowance;
    private double bonus;
    private double realSalary;
    private boolean paid;
    private ArrayList<WorkedShift> listWorkedShift;

    public Salary() {
        listWorkedShift = new ArrayList<>();
        this.sumHourInShift = 0;
        this.sumHourOutShift = 0;
        this.sumInShiftSalary = 0;
        this.sumOutShiftSalary = 0;
        this.sumLateTime = 0;
        this.sumLateFee = 0;
    }

    public Salary(int id, int sumHourInShift, int sumHourOutShift, double sumInShiftSalary, double sumOutShiftSalary, int sumLateTime, double sumLateFee, double allowance, double bonus, double realSalary, boolean paid, ArrayList<WorkedShift> listWorkedShift) {
        this.id = id;
        this.sumHourInShift = sumHourInShift;
        this.sumHourOutShift = sumHourOutShift;
        this.sumInShiftSalary = sumInShiftSalary;
        this.sumOutShiftSalary = sumOutShiftSalary;
        this.sumLateTime = sumLateTime;
        this.sumLateFee = sumLateFee;
        this.allowance = allowance;
        this.bonus = bonus;
        this.realSalary = realSalary;
        this.paid = paid;
        this.listWorkedShift = listWorkedShift;
    }

    public int getId() {
        return id;
    }

    public int getSumHourInShift() {
        return sumHourInShift;
    }

    public int getSumHourOutShift() {
        return sumHourOutShift;
    }

    public double getSumInShiftSalary() {
        return sumInShiftSalary;
    }

    public double getSumOutShiftSalary() {
        return sumOutShiftSalary;
    }

    public int getSumLateTime() {
        return sumLateTime;
    }

    public double getSumLateFee() {
        return sumLateFee;
    }

    public double getAllowance() {
        return allowance;
    }

    public double getBonus() {
        return bonus;
    }

    public double getRealSalary() {
        return realSalary;
    }

    public boolean isPaid() {
        return paid;
    }

    public ArrayList<WorkedShift> getListWorkedShift() {
        return listWorkedShift;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSumHourInShift(int sumHourInShift) {
        this.sumHourInShift = sumHourInShift;
    }

    public void setSumHourOutShift(int sumHourOutShift) {
        this.sumHourOutShift = sumHourOutShift;
    }

    public void setSumInShiftSalary(double sumInShiftSalary) {
        this.sumInShiftSalary = sumInShiftSalary;
    }

    public void setSumOutShiftSalary(double sumOutShiftSalary) {
        this.sumOutShiftSalary = sumOutShiftSalary;
    }

    public void setSumLateTime(int sumLateTime) {
        this.sumLateTime = sumLateTime;
    }

    public void setSumLateFee(double sumLateFee) {
        this.sumLateFee = sumLateFee;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setRealSalary(double realSalary) {
        this.realSalary = realSalary;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setListWorkedShift(ArrayList<WorkedShift> listWorkedShift) {
        this.listWorkedShift = listWorkedShift;
    }

    
}
