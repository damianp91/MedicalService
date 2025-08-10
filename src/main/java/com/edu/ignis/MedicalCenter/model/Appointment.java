package com.edu.ignis.MedicalCenter.model;

public class Appointment {
  // Atributes
  private int id;
  private Patient patient;
  private Specialty specialty;
  private boolean amountPay;
  private Status status;

  // Constructor
  public Appointment(Patient patient, Specialty specialty) {
    this.patient = patient;
    this.specialty = specialty;
  }

  // Getters
  public int getId() {
    return id;
  }
  public Patient getPatient() {
    return patient;
  }
  public Specialty getSpecialty() {
    return specialty;
  }
  public boolean isAmountPay() {
    return amountPay;
  }
  public Status getStatus() {
    return status;
  }
  
  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public void setSpecialty(Specialty specialty) {
    this.specialty = specialty;
  }

  public void setAmountPay(boolean amountPay) {
    this.amountPay = amountPay;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
