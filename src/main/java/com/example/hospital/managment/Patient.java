package com.example.hospital.managment;

public class Patient {
    private int patientId;
    private String name;
    private String diseases;
    private int age;

    public Patient(int patientId, String name, String diseases, int age) {
        this.patientId = patientId;
        this.name = name;
        this.diseases = diseases;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
