/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Manager extends Employee implements Serializable{
    private String username;
    private String password;
    private ArrayList<String> listSalary;

    public Manager() {
        listSalary = new ArrayList<>();
    }

    public Manager(String username, String password, int id, String name, String phoneNumber, String address, Date dateOfBirth, String gender, String email) {
        super(id, name, phoneNumber, address, dateOfBirth, gender, email);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getListSalary() {
        return listSalary;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setListSalary(ArrayList<String> listSalary) {
        this.listSalary = listSalary;
    }
    
}
