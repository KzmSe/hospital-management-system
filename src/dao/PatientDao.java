/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Patient;

/**
 *
 * @author Lenovo
 */
public interface PatientDao {
    
    Patient getPatient(String username, String password);
    
    boolean addPatient(Patient patient);
    
    List<Patient> getAllPanients();
    
    Patient getPatientById(int id);
    
    boolean updatePatientById(Patient patient, int id);
    
    boolean deletePatientById(int id);
    
}
