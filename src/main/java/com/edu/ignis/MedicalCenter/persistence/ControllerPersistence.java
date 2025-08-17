package com.edu.ignis.MedicalCenter.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ControllerPersistence {
  
  private static final EntityManagerFactory emf = Persistence.
    createEntityManagerFactory("MedicalPU")
  ;

  public static EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
  
}
