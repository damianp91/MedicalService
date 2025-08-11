package com.edu.ignis.MedicalCenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
  // Atributes
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @OneToMany
  private Patient patient;

  private Specialty specialty;
  private double amountPay;
  private Status status;

  // Constructor
  public Appointment(Patient patient, Specialty specialty) {
    this.patient = patient;
    this.specialty = specialty;
    this.amountPay = 4000;
    this.status = Status.ACTIVE;
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
  public double getAmountPay() {
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

  public void setAmountPay(double amountPay) {
    this.amountPay = amountPay;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
