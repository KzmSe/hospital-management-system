/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Doctor;

/**
 *
 * @author Lenovo
 */
public interface DoctorDao {
    
    Doctor getDoctor(String username, String password);
    
    List<Doctor> getAllDoctors();
    
    Doctor getDoctorById(int id);
    
    boolean deleteDoctorById(int id);
    
    boolean addDoctor(Doctor doctor);
    
    boolean updateDoctorById(Doctor doctor, int id);
    
    boolean updateLastLoginDate(Doctor doctor);
}
