package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbUtil {
    
    public static Connection getConnection(){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/clinic";
            String username = Config.getDbUsername();
            String password = Config.getDbPassword();
            connection = DriverManager.getConnection(url, username, password);
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
        return connection;
    }
    
   public static void close(AutoCloseable... acs){
        for (AutoCloseable ac : acs) {
            if (ac != null) {
                try {
                    ac.close();
         
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
   
}
