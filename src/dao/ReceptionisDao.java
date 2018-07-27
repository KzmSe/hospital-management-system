/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Receptionist;

/**
 *
 * @author Lenovo
 */
public interface ReceptionisDao {
    
    Receptionist getReceptionist(String username, String password);
    
}
