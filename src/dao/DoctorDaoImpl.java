/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.DuplicatePinException;
import exception.DuplicateUsernameAndPinException;
import exception.DuplicateUsernameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Department;
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
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id where dc.username = ? and dc.password = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id where dc.id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
    public boolean addDoctor(Doctor doctor) throws DuplicateUsernameAndPinException, DuplicateUsernameException, DuplicatePinException{
        Connection con = null;
        
        PreparedStatement ps = null;
        PreparedStatement psCountUsername = null;
        PreparedStatement psCountPin = null;
        
        int countUsername = 0;
        int countPin = 0;
        
        ResultSet rsUsername = null;
        ResultSet rsPin = null;
        
        boolean result = false;
        
        String sqlCountPin = "select count(*) as pin_count from doctor where pin = ?";
        String sqlCountUsername = "select count(*) as username_count from doctor where username = ?";
        String sql = "insert into doctor(first_name, last_name, username, password, image, id_department, age, gender, phone_number, pin) values(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            con = DbUtil.getConnection();
            
            ps = con.prepareStatement(sql);
            psCountUsername = con.prepareStatement(sqlCountUsername);
            psCountPin = con.prepareStatement(sqlCountPin);
            psCountUsername.setString(1, doctor.getUsername());
            psCountPin.setString(1, doctor.getPin());
            
            rsUsername = psCountUsername.executeQuery();
            rsPin = psCountPin.executeQuery();
            
            if (rsUsername.next()) {
                countUsername = rsUsername.getInt("username_count");
            }
            if (rsPin.next()) {
                countPin = rsPin.getInt("pin_count");
            }
            
            if (countUsername == 0 && countPin == 0) {
                ps.setString(1, doctor.getFirstName());
                ps.setString(2, doctor.getLastName());
                ps.setString(3, doctor.getUsername());
                ps.setString(4, doctor.getPassword());
                ps.setString(5, doctor.getImage());
                ps.setInt(6, doctor.getDepartment().getId());
                ps.setInt(7, doctor.getAge());
                ps.setString(8, doctor.getGender());
                ps.setString(9, doctor.getPhoneNumber());
                ps.setString(10, doctor.getPin());
                ps.executeUpdate();
                result = true; 
            } else {
                
                if (countUsername == 1 && countPin == 1) {
                    throw new DuplicateUsernameAndPinException();
                } else if (countUsername == 1 && countPin == 0) {
                    throw new DuplicateUsernameException();
                } else if (countPin == 1 && countUsername == 0){
                    throw new DuplicatePinException();
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, psCountUsername, psCountPin, rsUsername, rsPin);
            
        }
        
        return result;
    }

    @Override
    public boolean updateDoctorById(Doctor doctor, boolean usernameChanged) throws DuplicateUsernameException{
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement psCount = null;
        int count = 0;
        ResultSet rs = null;
        boolean result = false;
        String sqlCount = "select count(*) as username_count from doctor where username = ? and id != ?";
        String sql = "update doctor set first_name = ?, last_name = ?, age = ?, gender = ?, id_department = ?, phone_number = ?,"
                + "username = ?, password = ?, image = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            
            if (usernameChanged) {
                psCount = con.prepareStatement(sqlCount);
                psCount.setString(1, doctor.getUsername());
                psCount.setInt(2, doctor.getId());
                rs = psCount.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("username_count");
                }
            }
            
            if (count == 0) {
                ps.setString(1, doctor.getFirstName());
                ps.setString(2, doctor.getLastName());
                ps.setInt(3, doctor.getAge());
                ps.setString(4, doctor.getGender());
                ps.setInt(5, doctor.getDepartment().getId());
                ps.setString(6, doctor.getPhoneNumber());
                ps.setString(7, doctor.getUsername());
                ps.setString(8, doctor.getPassword());
                ps.setString(9, doctor.getImage());
                ps.setInt(10, doctor.getId());
                ps.executeUpdate();
                result = true;
            } else {
                throw new DuplicateUsernameException();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, psCount, rs);
            
        }
        
        return result;
    }

    @Override
    public boolean updateLastLoginDate(Doctor doctor) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update doctor set last_login_date = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, LocalDateTime.now().toString());
            ps.setInt(2, doctor.getId());
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
    public List<Doctor> getDoctorsByDepartment(int id_department) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Doctor> doctors = new ArrayList<>();
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id where dp.id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_department);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
    public Doctor getDoctorByPin(String pin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Doctor doctor = null;
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id where dc.pin = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pin);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
    public List<Doctor> getDoctorsByDepartment(String departmentName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Doctor> doctors = new ArrayList<>();
        String sql = "select dc.id as id_doctor, dc.first_name, dc.last_name, dc.username, dc.password, dc.image, dc.age, dc.gender, dc.phone_number, dc.last_login_date, dc.pin, dp.id as id_department, dp.department_name from doctor dc inner join department dp on dc.id_department=dp.id where dp.department_name = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, departmentName);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setGender(rs.getString("gender"));
                doctor.setAge(rs.getInt("age"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setUsername(rs.getNString("username"));
                doctor.setPassword(rs.getNString("password"));
                doctor.setImage(rs.getString("image"));
                doctor.setPin(rs.getString("pin"));
                
                Department department = new Department();
                department.setId(rs.getInt("id_department"));
                department.setDepartment_name(rs.getString("department_name"));
                
                doctor.setDepartment(department);
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
    public boolean updatePassword(Doctor doctor) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update doctor set password = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, doctor.getPassword());
            ps.setInt(2, doctor.getId());
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
