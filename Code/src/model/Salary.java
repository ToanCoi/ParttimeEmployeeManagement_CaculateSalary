/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguye
 */
public class Salary {
    private int id;
    private double allowance;
    private double bonus;
    private boolean paid;

    public Salary() {
    }

    public Salary(int id, double allowance, double bonus, boolean paid) {
        this.id = id;
        this.allowance = allowance;
        this.bonus = bonus;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public double getAllowance() {
        return allowance;
    }

    public double getBonus() {
        return bonus;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    
}
