/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import util.DbUtil;

/**
 *
 * @author Lenovo
 */
public class DepartmentDaoImpl implements DepartmentDao{

    @Override
    public List<Department> getAllDepartments() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList<>();
        String sql = "select * from department";
        
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setDepartment_name(rs.getString("department_name"));
                departments.add(department);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            DbUtil.close(con, ps, rs);
            
        }
        
        return departments;
    }
    
}
