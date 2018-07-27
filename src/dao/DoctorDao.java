/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Doctor;

/**
 *
 * @author Lenovo
 */
public interface DoctorDao {
    
    Doctor getDoctor(String username, String password);
    
}
