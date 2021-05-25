/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Manager;
import model.Salary;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nguye
 */
public class SalaryDAOTest {
    private SalaryDAO sd = new SalaryDAO();
    
    public SalaryDAOTest() {
    }

    /**
     * Test of searchSalary method, of class SalaryDAO.
     */
    @Test
    public void testSearchSalaryException() {
        Manager m = new Manager();
        m.setId(100);
        Date start = Date.valueOf("2021-05-03");
        Date end = Date.valueOf("2021-05-08");

        
        ArrayList<Salary> listSalary = sd.searchSalary(m, start, end);
        assertNotNull(listSalary);
        assertEquals(0, listSalary.size());
    }
    
    @Test
    public void testSearchSalaryStandard() {
        Manager m = new Manager();
        m.setId(100);
        Date start = Date.valueOf("2021-05-24");
        Date end = Date.valueOf("2021-05-29");

        
        ArrayList<Salary> listSalary = sd.searchSalary(m, start, end);
        assertNotNull(listSalary);
        assertEquals(2, listSalary.size());
    }

    /**
     * Test of updateSalary method, of class SalaryDAO.
     */
    @Test
    public void testUpdateSalaryException() {
        Salary salary = new Salary();
        salary.setId(1);
        
        Connection connection = DAO.connection;
        try {
            connection.setAutoCommit(false);
            
            boolean temp = sd.updateSalary(salary);
            assertEquals(false, temp);
            
            connection.rollback();
            connection.setAutoCommit(true);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testUpdateSalaryStandard() {
        Salary salary = new Salary();
        salary.setId(2);
        
        Connection connection = DAO.connection;
        try {
            connection.setAutoCommit(false);
            
            boolean temp = sd.updateSalary(salary);
            assertEquals(true, temp);
            
            connection.rollback();
            connection.setAutoCommit(true);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
