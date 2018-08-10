/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.DuplicatePinException;
import exception.DuplicateUsernameAndPinException;
import exception.DuplicateUsernameException;
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
    
    Doctor getDoctorByPin(String pin);
    
    List<Doctor> getDoctorsByDepartment(int id_department);
    
    boolean deleteDoctorById(int id);
    
    boolean addDoctor(Doctor doctor) throws DuplicateUsernameAndPinException, DuplicateUsernameException, DuplicatePinException;
    
    boolean updateDoctorById(Doctor doctor, int id);
    
    boolean updateLastLoginDate(Doctor doctor);
}
