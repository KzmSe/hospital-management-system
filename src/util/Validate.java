/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Doctor;
import model.Receptionist;
import model.RootUser;

/**
 *
 * @author Kazi_tg54
 */
public class Validate {
    
    public static boolean validateEmptyFields(String... fields) {
        
        boolean result = true;
        
        for (String str : fields) {
            if (str == null || str.isEmpty()) {
                result = false;
            }
        }
        
        return result;
    }
    
}
