/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
                doctor.setLastLoginDate(rs.getTimestamp("last_login_date") == null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Doctor doctor = null;
        List<Doctor> doctors = new ArrayList<>();
        String sql = "select * from doctor";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
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
                doctor.setLastLoginDate(rs.getTimestamp("last_login_date") == null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
                doctors.add(doctor);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return doctors;
    }

    @Override
    public Doctor getDoctorById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Doctor doctor = null;
        String sql = "select * from doctor where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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
                doctor.setLastLoginDate(rs.getTimestamp("last_login_date") == null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return doctor;
    }

    @Override
    public boolean deleteDoctorById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "delete from doctor where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, null);
            
        }
        
        return result;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "insert into doctor(first_name, last_name, username, password, image, rank, age, gender, phone_number) values(?,?,?,?,?,?,?,?,?)";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getUsername());
            ps.setString(4, doctor.getPassword());
            ps.setString(5, doctor.getImage());
            ps.setString(6, doctor.getRank());
            ps.setInt(7, doctor.getAge());
            ps.setString(8, doctor.getGender());
            ps.setString(9, doctor.getPhoneNumber());
            ps.executeUpdate();
            result = true; 
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, null);
            
        }
        
        return result;
    }

    @Override
    public boolean updateDoctorById(Doctor doctor, int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update doctor set first_name = ?, last_name = ?, age = ?, gender = ?, rank = ?, phone_number = ?,"
                + "username = ?, password = ?, image = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setInt(3, doctor.getAge());
            ps.setString(4, doctor.getGender());
            ps.setString(5, doctor.getRank());
            ps.setString(6, doctor.getPhoneNumber());
            ps.setString(7, doctor.getUsername());
            ps.setString(8, doctor.getPassword());
            ps.setString(9, doctor.getImage());
            ps.setInt(10, id);
            ps.executeUpdate();
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, null);
            
        }
        
        return result;
    }
    
}
