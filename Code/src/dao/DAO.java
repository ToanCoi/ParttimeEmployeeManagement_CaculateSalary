/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nguye
 */
public class DAO {
    public static Connection connection;
    
    public DAO() {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/se_2021";
            String username = "";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
