/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Kazi_tg54
 */
public class Config {
    
    private static Properties properties;
    
    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("app.properties"));
            
        } catch (IOException e) {
            e.printStackTrace();    
        }
    }
    
    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }
    
    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
    
}
