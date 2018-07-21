package model;

import java.time.LocalDateTime;


public class Appointment {
    
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime date;

    public Appointment() {
    }

    public Appointment(int id, Patient patient, Doctor doctor, LocalDateTime date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", date=" + date + '}';
    }
    
}
