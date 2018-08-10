/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Department {
    
    private int id;
    private String department_name;
    private List<Doctor> doctors;

    public Department() {
        doctors = new ArrayList();
    }

    public Department(int id, String department_name, List<Doctor> doctors) {
        this.id = id;
        this.department_name = department_name;
        this.doctors = doctors;
        doctors = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", department_name=" + department_name + ", doctors=" + doctors + '}';
    }
    
}
