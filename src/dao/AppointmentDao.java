/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import model.Appointment;
import model.Doctor;
import model.Patient;

/**
 *
 * @author Kazi_tg54
 */
public interface AppointmentDao {
    
    List<Appointment> getAllAppointments();
    
    List<Appointment> getAllAppointmentsById(int id);
    
    boolean deleteAppointmentById(int id);
    
    Appointment getAppointmentById(int id);
    
    boolean addAppointment(int idPatient, int idDoctor, Date dateAndTime);
    
    boolean updateAppointment(int idPatient, int idDoctor, Date dateAndTime, int id);
}
