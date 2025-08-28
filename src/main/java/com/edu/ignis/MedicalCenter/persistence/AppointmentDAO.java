package com.edu.ignis.MedicalCenter.persistence;

import com.edu.ignis.MedicalCenter.model.Appointment;

public class AppointmentDAO extends GenericDAO<Appointment> {

  public AppointmentDAO() {
    super(Appointment.class);
  }
}
