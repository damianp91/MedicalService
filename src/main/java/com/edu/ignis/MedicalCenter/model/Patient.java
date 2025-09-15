package com.edu.ignis.MedicalCenter.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Basic(optional = false)
  @Column(length = 30, nullable = false)
  private String name;
  @Column(length = 30, nullable = false)
  private String lastName;

  @Column(name = "dni", unique = true, nullable = false)
  private int dni;
  @Column(name = "registration_date", nullable = false)
  private LocalDate registrationDate;

  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Insurance insurance;

  // Constructor
  // Constructor empty is necesary because JPA needs for insert entities by
  // reflection
  public Patient () { }

  public Patient(String name, String lastName, int dni, LocalDate birthDate,
      Insurance insurance) {
    this.name = name;
    this.lastName = lastName;
    this.dni = dni;
    this.registrationDate = LocalDate.now();
    this.birthDate = birthDate;
    this.insurance = insurance;
  }

  // Getters
  public int getId() { return id; }

  public String getName() { return name; }

  public String getLastName() { return lastName; }

  public int getDni() { return dni; }

  public LocalDate getRegistrationDate() { return registrationDate; }

  public LocalDate getBirthDate() { return birthDate; }

  public Insurance getInsurance() { return insurance; }

  // Setters
  public void setName(String name) {
    this.name = name.toUpperCase();
  }

  public void setLastName(String lastName) {
    this.lastName = lastName.toUpperCase();
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

}
