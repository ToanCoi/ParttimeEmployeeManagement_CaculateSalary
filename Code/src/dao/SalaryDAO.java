/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Salary;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import model.Manager;
import model.ParttimeEmployee;
import model.Shift;
import model.WorkedShift;

/**
 *
 * @author nguye
 */
public class SalaryDAO extends DAO {

    public SalaryDAO() {
    }

    public ArrayList<Salary> searchSalary(Manager m, Date start, Date end) {
        ArrayList<Salary> listSalary = new ArrayList<>();

        String sql = "SELECT * FROM tblsalary WHERE tblManagerid = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, String.valueOf(m.getId()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //create salary
                sql = "SELECT * FROM tblworkedshift WHERE (DATEDIFF(?, date) <= 0 AND DATEDIFF(?, date) >= 0 AND tblSalaryid = ?)";
                ps = connection.prepareStatement(sql);
                ps.setString(1, start.toString());
                ps.setString(2, end.toString());
                ps.setString(3, String.valueOf(rs.getInt("id")));
                ResultSet rs1 = ps.executeQuery();

                ArrayList<WorkedShift> listWorkedShift = new ArrayList<>();
                while (rs1.next()) {
                    //create workedshift    
                    //create parttime employee
                    sql = "SELECT tblemployee.id, tblemployee.name, tblemployee.phoneNumber, tblemployee.address, "
                            + "tblemployee.dateOfBirth, tblemployee.gender, tblemployee.email, tblparttimeemployee.hourlyWages "
                            + "FROM tblemployee, tblparttimeemployee "
                            + "WHERE tblemployee.id = tblparttimeemployee.id AND tblemployee.id = ?;";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, String.valueOf(rs1.getInt("tblParttimeEmployeeid")));
                    ParttimeEmployee e = new ParttimeEmployee();
                    ResultSet rs2 = ps.executeQuery();
                    if (rs2.next()) {
                        e.setId(rs2.getInt("id"));
                        e.setName(rs2.getString("name"));
                        e.setPhoneNumber(rs2.getString("phoneNumber"));
                        e.setAddress(rs2.getString("address"));
                        e.setDateOfBirth(rs2.getDate("dateOfBirth"));
                        e.setGender(rs2.getString("gender"));
                        e.setEmail(rs2.getString("email"));
                        e.setHourlyWages(rs2.getDouble("hourlyWages"));
                    }

                    //create shift
                    sql = "SELECT * FROM tblshift where id = ?";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, String.valueOf(rs1.getInt("tblShiftid")));
                    Shift shift = new Shift();
                    rs2 = ps.executeQuery();
                    if (rs2.next()) {
                        shift.setId(rs2.getInt("id"));
                        shift.setType(rs2.getString("type"));
                        shift.setStartTime(rs2.getTime("startTime"));
                        shift.setEndTime(rs2.getTime("endTime"));
                    }

                    WorkedShift ws = new WorkedShift();
                    ws.setId(rs1.getInt("id"));
                    ws.setCheckinTime(rs1.getTime("checkinTime"));
                    ws.setCheckoutTime(rs1.getTime("checkoutTime"));
                    ws.setDate(rs1.getDate("date"));
                    ws.setWeeksDay(rs1.getString("weeksDay"));
                    ws.setCoefficientsSalary(rs1.getDouble("coefficientsSalary"));
                    ws.setHourlyWages(rs1.getDouble("hourlyWages"));
                    ws.setEmployee(e);
                    ws.setShift(shift);
                    ws.setHourInShift(ws.getShift().getEndTime().getHours() - ws.getCheckinTime().getHours());
                    ws.setInShiftSalary(ws.getHourInShift() * ws.getHourlyWages());
                    int temp = ws.getCheckoutTime().getHours() - ws.getShift().getEndTime().getHours();
                    if (temp > 0) {
                        ws.setHourOutShift(temp);
                        ws.setOutShiftSalary(temp * ws.getHourlyWages() * 1.5);
                    } else if (temp == 0) {
                        ws.setHourOutShift(0);
                        ws.setOutShiftSalary(0);
                    } else if (temp < 0) {
                        ws.setLateTime(temp * -1);
                    }
                    ws.setLateTime(ws.getCheckinTime().getHours() - ws.getShift().getStartTime().getHours() + ws.getLateTime());
                    if (ws.getCheckinTime().getMinutes() - ws.getShift().getStartTime().getMinutes() > 0) {
                        ws.setLateTime(ws.getLateTime() + 1);
                    }
                    ws.setLateFee(ws.getLateTime() * 2 * ws.getHourlyWages());
                    ws.setShiftSalary((ws.getInShiftSalary() + ws.getOutShiftSalary() - ws.getLateFee()) * ws.getCoefficientsSalary());
                    listWorkedShift.add(ws);
                }

                Salary salary = new Salary();
                salary.setId(rs.getInt("id"));
                salary.setAllowance(rs.getDouble("allowance"));
                salary.setBonus(rs.getDouble("bonus"));
                salary.setPaid(rs.getBoolean("paid"));
                salary.setListWorkedShift(listWorkedShift);
                listWorkedShift.stream().map(w -> {
                    salary.setSumHourInShift(salary.getSumHourInShift() + w.getHourInShift());
                    return w;
                }).map(w -> {
                    salary.setSumHourOutShift(salary.getSumHourOutShift() + w.getHourOutShift());
                    return w;
                }).map(w -> {
                    salary.setSumInShiftSalary(salary.getSumInShiftSalary() + w.getInShiftSalary());
                    return w;
                }).map(w -> {
                    salary.setSumOutShiftSalary(salary.getSumOutShiftSalary() + w.getOutShiftSalary());
                    return w;
                }).map(w -> {
                    salary.setSumLateTime(salary.getSumLateTime() + w.getLateTime());
                    return w;
                }).forEachOrdered(w -> {
                    salary.setSumLateFee(salary.getSumLateFee() + w.getLateFee());
                });
                salary.setRealSalary(salary.getSumInShiftSalary()
                        + salary.getSumOutShiftSalary() - salary.getSumLateFee() + salary.getAllowance() + salary.getBonus());
                if(salary.getListWorkedShift().size() > 0)
                    listSalary.add(salary);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        listSalary.sort(new Comparator<Salary>() {
            @Override
            public int compare(Salary o1, Salary o2) {
                return o1.getListWorkedShift().get(0).getEmployee().getName().compareTo(o2.getListWorkedShift().get(0).getEmployee().getName());
            }
            
        });
        return listSalary;
    }
    
    public boolean updateSalary(Salary salary) {
        String sql = "UPDATE tblSalary SET paid = b'1' WHERE id = ? AND paid != 1";
        int res = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, String.valueOf(salary.getId()));
            res = ps.executeUpdate(); 
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return res != 0;
    }

}
