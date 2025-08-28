package com.edu.ignis.MedicalCenter.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
  // Atributes
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "id_patient", nullable = false)
  private Patient idPatient;
  @Enumerated(EnumType.STRING)
  private Specialty specialty;
  private double amountPay;
  @Enumerated(EnumType.STRING)
  private Status status;

  // Constructor
  public Appointment() {};

  public Appointment(Patient patient, Specialty specialty) {
    this.idPatient = patient;
    this.specialty = specialty;
    this.amountPay = 4000;
    this.status = Status.ACTIVE;
  }

  // Getters
  public int getId() { return id; }

  public Patient getPatient() { return idPatient; }
  
  public Specialty getSpecialty() { return specialty; }
  
  public double getAmountPay() { return amountPay; }
  
  public Status getStatus() { return status; }
  
  // Setters
  public void setSpecialty(Specialty specialty) { this.specialty = specialty; }

  public void setAmountPay(double amountPay) { this.amountPay = amountPay; }

  public void setStatus(Status status) { this.status = status; }
}
