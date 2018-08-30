/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.DuplicateUsernameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public boolean updateLastLoginDate(RootUser rootUser) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update root_user set last_login_date = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, LocalDateTime.now().toString());
            ps.setInt(2, rootUser.getId());
            ps.executeUpdate();
            result = true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, null);
            
        }
        
        return result;
    }

    @Override
    public boolean updateRootUser(RootUser rootUser, boolean usernameChanged) throws DuplicateUsernameException{
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement psCountUsername = null;
        int count = 0;
        ResultSet rs = null;
        boolean result = false;
        String sqlCountUsername = "select count(*) as username_count from root_user where username = ? and id != ?";
        String sql = "update root_user set first_name = ?, last_name = ?, username = ?, password = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            
            if (usernameChanged) {
                psCountUsername = con.prepareStatement(sqlCountUsername);
                psCountUsername.setString(1, rootUser.getUsername());
                psCountUsername.setInt(2, rootUser.getId());
                rs = psCountUsername.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("username_count");
                }
            }
            
            if (count == 0) {
                ps.setString(1, rootUser.getFirstName());
                ps.setString(2, rootUser.getLastName());
                ps.setString(3, rootUser.getUsername());
                ps.setString(4, rootUser.getPassword());
                ps.setInt(5, rootUser.getId());
                ps.executeUpdate();
                result = true;
            } else {
                throw new DuplicateUsernameException();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, psCountUsername, rs);
        }
        
        return result;
    }

    @Override
    public boolean updatePassword(RootUser rootUser) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String sql = "update root_user set password = ? where id = ?";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rootUser.getPassword());
            ps.setInt(2, rootUser.getId());
            ps.executeUpdate();
            result = true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, null);
            
        }
        
        return result;
    }
    
    
    
}
