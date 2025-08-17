package com.edu.ignis.MedicalCenter.persistence;

import com.edu.ignis.MedicalCenter.model.Patient;

public class PatientDAO extends GenericDAO<Patient> {
  
  public PatientDAO() {
    super(Patient.class);
  }
}
