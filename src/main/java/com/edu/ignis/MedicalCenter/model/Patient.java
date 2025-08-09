package com.edu.ignis.MedicalCenter.model;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "patients")
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Basic
  private String name;
  private String lastName;
  
  @Column(name = "dni", unique = true, nullable = false)
  private int dni;
  @Temporal(TemporalType.DATE)
  private Date registrationDate;

  @Temporal(TemporalType.DATE)
  private Date birthDate;

  @Enumerated(EnumType.STRING)
  private Insurance insurance;

  public int getId() {
    return id;
  }
  
  // Constructor
  public Patient(String name, String lastName, int dni, Date registrationDate,
      Date birthDate, Insurance insurance) {
    this.name = name;
    this.lastName = lastName;
    this.dni = dni;
    this.registrationDate = registrationDate;
    this.birthDate = birthDate;
    this.insurance = insurance;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public int getDni() {
    return dni;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  @Override
  public String toString() {
    return "Patient [id: " + id + ", name: " + name + ", lastName: " + lastName +
        ", dni: " + dni + ", registrationDate: " + registrationDate +
        ", birthDate: " + birthDate + ", insurance: " + insurance + "]"
    ;
  }
}
