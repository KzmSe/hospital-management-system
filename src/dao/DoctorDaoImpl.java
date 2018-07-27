/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Doctor;
import model.Patient;
import util.DbUtil;

/**
 *
 * @author Lenovo
 */
public class DoctorDaoImpl implements DoctorDao{

    @Override
    public Doctor getDoctor(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Doctor doctor = null;
        String sql = "select * from doctor where username = ? and password = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setRank(rs.getString("rank"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return doctor;
    }
    
}
