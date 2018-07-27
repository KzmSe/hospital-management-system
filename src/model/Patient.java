package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Patient {
    
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;
    private String patientType;
    private int wardNo;
    private int bedNo;
    private Date date;
    private String image;
    private String bloodGroup;
    private List<Appointment> appointments;

    public Patient() {
        appointments = new ArrayList<>();
    }

    public Patient(int id, String firstName, String lastName, int age, String gender, String address, String phoneNumber, String patientType, int wardNo, int bedNo, Date date, String image, String bloodGroup, List<Appointment> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.patientType = patientType;
        this.wardNo = wardNo;
        this.bedNo = bedNo;
        this.date = date;
        this.image = image;
        this.bloodGroup = bloodGroup;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public int getWardNo() {
        return wardNo;
    }

    public void setWardNo(int wardNo) {
        this.wardNo = wardNo;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", patientType=" + patientType + ", wardNo=" + wardNo + ", bedNo=" + bedNo + ", date=" + date + ", image=" + image + ", bloodGroup=" + bloodGroup + ", appointments=" + appointments + '}';
    }

}
