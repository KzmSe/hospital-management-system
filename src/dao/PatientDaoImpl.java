/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Patient;
import model.RootUser;
import util.DbUtil;

/**
 *
 * @author Lenovo
 */
public class PatientDaoImpl implements PatientDao{

    @Override
    public Patient getPatient(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Patient patient = null;
        String sql = "select * from patient where username = ? and password = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setAddress(rs.getString("address"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setPatientType(rs.getString("patient_type"));
                patient.setWardNo(rs.getInt("ward_no"));
                patient.setBedNo(rs.getInt("bed_no"));
                patient.setDate(rs.getDate("date"));
                patient.setImage(rs.getString("image"));
                patient.setBloodGroup(rs.getString("blood_group"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return patient;
    }

    @Override
    public boolean addPatient(Patient patient) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "insert into patient(first_name, last_name, age, gender, address, phone_number, patient_type, ward_no, bed_no, date, image, blood_group)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getPhoneNumber());
            ps.setString(7, patient.getPatientType());
            ps.setInt(8, patient.getWardNo());
            ps.setInt(9, patient.getBedNo());
            ps.setDate(10, new Date(patient.getDate().getTime()));
            ps.setString(11, patient.getImage());
            ps.setString(12, patient.getBloodGroup());
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
    public List<Patient> getAllPanients() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Patient> patients = new ArrayList<>();
        Patient patient = null;
        String sql = "select * from patient";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setAddress(rs.getString("address"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setPatientType(rs.getString("patient_type"));
                patient.setWardNo(rs.getInt("ward_no"));
                patient.setBedNo(rs.getInt("bed_no"));
                patient.setDate(rs.getDate("date"));
                patient.setImage(rs.getString("image"));
                patient.setBloodGroup(rs.getString("blood_group"));
                
                patients.add(patient);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return patients;
    }

    @Override
    public Patient getPatientById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Patient patient = null;
        String sql = "select * from patient where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setAddress(rs.getString("address"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setPatientType(rs.getString("patient_type"));
                patient.setWardNo(rs.getInt("ward_no"));
                patient.setBedNo(rs.getInt("bed_no"));
                patient.setDate(rs.getDate("date"));
                patient.setImage(rs.getString("image"));
                patient.setBloodGroup(rs.getString("blood_group"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return patient;
    }

    public boolean updatePatientById(Patient patient, int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update patient set first_name = ?, last_name = ?, age = ?, gender = ?, address = ?, phone_number = ?, patient_type = ?,"
                + "ward_no = ?, bed_no = ?, date = ?, image = ?, blood_group = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getPhoneNumber());
            ps.setString(7, patient.getPatientType());
            ps.setInt(8, patient.getWardNo());
            ps.setInt(9, patient.getBedNo());
            ps.setDate(10, new Date(patient.getDate().getTime()));
            ps.setString(11, patient.getImage());
            ps.setString(12, patient.getBloodGroup());
            ps.setInt(13, id);
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
    public boolean deletePatientById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "delete from patient where id = ?";
        
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
    
}
