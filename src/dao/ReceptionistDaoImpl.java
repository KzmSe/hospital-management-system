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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Patient;
import model.Receptionist;
import util.DbUtil;

/**
 *
 * @author Lenovo
 */
public class ReceptionistDaoImpl implements ReceptionisDao{

    @Override
    public Receptionist getReceptionist(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Receptionist receptionist = null;
        String sql = "select * from receptionist where username = ? and password = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                receptionist = new Receptionist();
                receptionist.setId(rs.getInt("id"));
                receptionist.setFirstName(rs.getString("first_name"));
                receptionist.setLastName(rs.getString("last_name"));
                receptionist.setAge(rs.getInt("age"));
                receptionist.setGender(rs.getString("gender"));
                receptionist.setAddress(rs.getString("address"));
                receptionist.setPhoneNumber(rs.getString("phone_number"));
                receptionist.setLastLoginDate(rs.getTimestamp("last_login_date")==null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
                receptionist.setImage(rs.getString("image"));
                receptionist.setUsername(rs.getString("username"));
                receptionist.setPassword(rs.getString("password"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return receptionist;
    }

    @Override
    public List<Receptionist> getAllReceptionists() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Receptionist receptionist = null;
        List<Receptionist> receptionists = new ArrayList<>();
        String sql = "select * from receptionist";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                receptionist = new Receptionist();
                receptionist.setId(rs.getInt("id"));
                receptionist.setFirstName(rs.getString("first_name"));
                receptionist.setLastName(rs.getString("last_name"));
                receptionist.setAge(rs.getInt("age"));
                receptionist.setGender(rs.getString("gender"));
                receptionist.setAddress(rs.getString("address"));
                receptionist.setPhoneNumber(rs.getString("phone_number"));
                receptionist.setLastLoginDate(rs.getTimestamp("last_login_date")==null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
                receptionist.setImage(rs.getString("image"));
                receptionist.setUsername(rs.getString("username"));
                receptionist.setPassword(rs.getString("password"));
                
                receptionists.add(receptionist);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return receptionists;
    }

    @Override
    public boolean addReceptionist(Receptionist receptionist) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "insert into receptionist(first_name, last_name, age, gender, address, phone_number, username, password, image) values(?,?,?,?,?,?,?,?,?)";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receptionist.getFirstName());
            ps.setString(2, receptionist.getLastName());
            ps.setInt(3, receptionist.getAge());
            ps.setString(4, receptionist.getGender());
            ps.setString(5, receptionist.getAddress());
            ps.setString(6, receptionist.getPhoneNumber());
            ps.setString(7, receptionist.getUsername());
            ps.setString(8, receptionist.getPassword());
            ps.setString(9, receptionist.getImage());
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
    public Receptionist getReceptionistById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Receptionist receptionist = null;
        String sql = "select * from receptionist where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                receptionist = new Receptionist();
                receptionist.setId(rs.getInt("id"));
                receptionist.setFirstName(rs.getString("first_name"));
                receptionist.setLastName(rs.getString("last_name"));
                receptionist.setAge(rs.getInt("age"));
                receptionist.setGender(rs.getString("gender"));
                receptionist.setAddress(rs.getString("address"));
                receptionist.setPhoneNumber(rs.getString("phone_number"));
                receptionist.setLastLoginDate(rs.getTimestamp("last_login_date")==null ? null : rs.getTimestamp("last_login_date").toLocalDateTime());
                receptionist.setImage(rs.getString("image"));
                receptionist.setUsername(rs.getString("username"));
                receptionist.setPassword(rs.getString("password"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return receptionist;
    }

    @Override
    public boolean updateReceptionistById(Receptionist receptionist, int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update receptionist set first_name = ?, last_name = ?, age = ?, gender = ?, address = ?, phone_number = ?,"
                + "username = ?, password = ?, image = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, receptionist.getFirstName());
            ps.setString(2, receptionist.getLastName());
            ps.setInt(3, receptionist.getAge());
            ps.setString(4, receptionist.getGender());
            ps.setString(5, receptionist.getAddress());
            ps.setString(6, receptionist.getPhoneNumber());
            ps.setString(7, receptionist.getUsername());
            ps.setString(8, receptionist.getPassword());
            ps.setString(9, receptionist.getImage());
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

    @Override
    public boolean deleteReceptionistById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "delete from receptionist where id = ?";
        
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
