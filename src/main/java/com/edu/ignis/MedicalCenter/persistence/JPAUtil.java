package com.edu.ignis.MedicalCenter.persistence;

import jakarta.persistence.*;

public class JPAUtil {
  private static final EntityManagerFactory emf =
  Persistence.createEntityManagerFactory("MedicalPU");

  public static EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
