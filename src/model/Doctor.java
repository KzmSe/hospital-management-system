package model;

import java.util.ArrayList;
import java.util.List;


public class Doctor {
    
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String image;
    private String rank;
    private int age;
    private String gender;
    private String phoneNumber;
    private List<Appointment> appointments;

    public Doctor() {
        appointments = new ArrayList<>();
    }

    public Doctor(int id, String firstName, String lastName, String username, String password, String image, String rank, int age, String gender, String phoneNumber, List<Appointment> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.image = image;
        this.rank = rank;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.appointments = appointments;
        appointments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", image=" + image + ", rank=" + rank + ", age=" + age + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", appointments=" + appointments + '}';
    }
    
}
