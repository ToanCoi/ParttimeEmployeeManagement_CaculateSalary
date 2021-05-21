/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class ParttimeEmployee extends Employee implements Serializable{
    private double hourlyWages;

    public ParttimeEmployee() {
    }

    public ParttimeEmployee(double hourlyWages, int id, String name, String phoneNumber, String address, LocalDate dateOfBirth, String gender, String email) {
        super(id, name, phoneNumber, address, dateOfBirth, gender, email);
        this.hourlyWages = hourlyWages;
    }

    public double getHourlyWages() {
        return hourlyWages;
    }

    public void setHourlyWages(double hourlyWages) {
        this.hourlyWages = hourlyWages;
    }
    
}
