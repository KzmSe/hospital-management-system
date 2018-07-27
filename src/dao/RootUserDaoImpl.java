/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import model.RootUser;
import util.DbUtil;

/**
 *
 * @author Lenovo
 */
public class RootUserDaoImpl implements RootUserDao{

    @Override
    public RootUser getRootUser(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RootUser rootUser = null;
        String sql = "select * from root_user where username = ? and password = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                rootUser = new RootUser();
                rootUser.setId(rs.getInt("id"));
                rootUser.setUsername(rs.getString("username"));
                rootUser.setPassword(rs.getString("password"));
                rootUser.setFirstName(rs.getString("first_name"));
                rootUser.setLastName(rs.getString("last_name"));
                rootUser.setLastLoginDate(rs.getTimestamp("last_login_date").toLocalDateTime());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return rootUser;
    }
    
    
    
}
