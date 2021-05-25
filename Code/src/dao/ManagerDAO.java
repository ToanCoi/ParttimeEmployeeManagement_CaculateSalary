/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Manager;
import java.sql.*;

/**
 *
 * @author nguye
 */
public class ManagerDAO extends DAO {

    public ManagerDAO() {
    }
    
    public boolean checkLogin(Manager manager) {
        
        String sql = "SELECT id FROM tblmanager WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, manager.getUsername());
            ps.setString(2, manager.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                sql = "SELECT * FROM tblemployee WHERE id = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, String.valueOf(id));
                ResultSet rs1 = ps.executeQuery();
                while(rs1.next()) {
                    manager.setId(id);
                    manager.setName(rs1.getString("name"));
                    return true;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
