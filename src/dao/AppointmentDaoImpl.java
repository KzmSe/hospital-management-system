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
import java.util.Date;
import java.util.List;
import model.Appointment;
import model.Department;
import model.Doctor;
import model.Patient;
import util.DbUtil;

/**
 *
 * @author Kazi_tg54
 */
public class AppointmentDaoImpl implements AppointmentDao{

    @Override
    public List<Appointment> getAllAppointments() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select a.id, p.first_name as patient_first_name, p.last_name as patient_last_name, p.pin as patient_pin, d.first_name as doctor_first_name, d.last_name as doctor_last_name, de.department_name, d.pin as doctor_pin, a.date from appointment a inner join patient p on a.id_patient=p.id inner join doctor d on a.id_doctor=d.id inner join department de on d.id_department=de.id";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_name(rs.getString("department_name"));
                Doctor doctor = new Doctor();
                doctor.setFirstName(rs.getString("doctor_first_name"));
                doctor.setLastName(rs.getString("doctor_last_name"));
                doctor.setPin(rs.getString("doctor_pin"));
                doctor.setDepartment(department);
                Patient patient = new Patient();
                patient.setFirstName(rs.getString("patient_first_name"));
                patient.setLastName(rs.getString("patient_last_name"));
                patient.setPin(rs.getString("patient_pin"));
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setDoctor(doctor);
                appointment.setPatient(patient);
                appointment.setDate(rs.getTimestamp("date").toLocalDateTime());
                
                appointments.add(appointment);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return appointments;
    }

    @Override
    public boolean addAppointment(int idPatient, int idDoctor, Date dateAndTime) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "insert into appointment(id_patient, id_doctor, date) values(?,?,?)";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPatient);
            ps.setInt(2, idDoctor);
            ps.setTimestamp(3, new java.sql.Timestamp(dateAndTime.getTime()));
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
    public boolean deleteAppointmentById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "delete from appointment where id = ?";
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
    public Appointment getAppointmentById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Appointment appointment = null;
        String sql = "select a.id as id_appointment, p.id as id_patient, p.first_name as patient_first_name, p.last_name as patient_last_name, p.pin as patient_pin, d.id as id_doctor, d.first_name as doctor_first_name, d.last_name as doctor_last_name, de.department_name, d.pin as doctor_pin, a.date from appointment a inner join patient p on a.id_patient=p.id inner join doctor d on a.id_doctor=d.id inner join department de on d.id_department=de.id where a.id = ?";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Department department = new Department();
                department.setDepartment_name(rs.getString("department_name"));
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("doctor_first_name"));
                doctor.setLastName(rs.getString("doctor_last_name"));
                doctor.setPin(rs.getString("doctor_pin"));
                doctor.setDepartment(department);
                Patient patient = new Patient();
                patient.setId(rs.getInt("id_patient"));
                patient.setFirstName(rs.getString("patient_first_name"));
                patient.setLastName(rs.getString("patient_last_name"));
                patient.setPin(rs.getString("patient_pin"));
                appointment = new Appointment();
                appointment.setId(rs.getInt("id_appointment"));
                appointment.setDoctor(doctor);
                appointment.setPatient(patient);
                appointment.setDate(rs.getTimestamp("date").toLocalDateTime());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointmentsById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select a.id, p.first_name as patient_first_name, p.last_name as patient_last_name, p.pin as patient_pin, d.id as id_doctor, d.first_name as doctor_first_name, d.last_name as doctor_last_name, de.department_name, d.pin as doctor_pin, a.date from appointment a inner join patient p on a.id_patient=p.id inner join doctor d on a.id_doctor=d.id inner join department de on d.id_department=de.id where d.id = ?";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Department department = new Department();
                department.setDepartment_name(rs.getString("department_name"));
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id_doctor"));
                doctor.setFirstName(rs.getString("doctor_first_name"));
                doctor.setLastName(rs.getString("doctor_last_name"));
                doctor.setPin(rs.getString("doctor_pin"));
                doctor.setDepartment(department);
                Patient patient = new Patient();
                patient.setFirstName(rs.getString("patient_first_name"));
                patient.setLastName(rs.getString("patient_last_name"));
                patient.setPin(rs.getString("patient_pin"));
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setDoctor(doctor);
                appointment.setPatient(patient);
                appointment.setDate(rs.getTimestamp("date").toLocalDateTime());
                
                appointments.add(appointment);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return appointments;
    }
    
    
    
}
