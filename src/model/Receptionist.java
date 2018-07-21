package model;

import java.time.LocalDateTime;


public class Receptionist {
    
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;
    private LocalDateTime lastLoginDate;
    private String username;
    private String password;
    private String image;

    public Receptionist() {
    }

    public Receptionist(int id, String firstName, String lastName, int age, String gender, String address, String phoneNumber, LocalDateTime lastLoginDate, String username, String password, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.lastLoginDate = lastLoginDate;
        this.username = username;
        this.password = password;
        this.image = image;
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

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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

    @Override
    public String toString() {
        return "Receptionist{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", lastLoginDate=" + lastLoginDate + ", username=" + username + ", password=" + password + ", image=" + image + '}';
    }
    
}
