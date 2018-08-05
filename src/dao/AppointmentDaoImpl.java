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
import model.Appointment;
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
        Appointment appointment = null;
        Patient patient = null;
        Doctor doctor = null;
        String sql = "select a.id, d.id as doctor_id, d.first_name as doctor_first_name, d.last_name as doctor_last_name, p.pin as patient_pin, p.first_name as patient_first_name, p.last_name as patient_last_name, a.date from appointment a inner join doctor d on a.id_doctor=d.id inner join patient p on a.id_patient=p.id";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                appointment = new Appointment();
                patient = new Patient();
                doctor = new Doctor();
                
                //
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return appointments;
    }
    
    
    
}
