package com.edu.ignis.MedicalCenter.controller;

import com.edu.ignis.MedicalCenter.model.Patient;
import com.edu.ignis.MedicalCenter.persistence.PatientDAO;

public class PatientController {

  private final PatientDAO patientDAO = new PatientDAO();
  
  public void savePatient(Patient patient) {
    patientDAO.create(patient);
  }

  public Patient findPatient(int id) {
    return patientDAO.find(id);
  }

  public void editPatient(Patient patient, int id) throws Exception {
    patientDAO.edit(patient, id);
  }

  public void deletePatient(int id) throws Exception {
    patientDAO.delete(id);
  }
}
