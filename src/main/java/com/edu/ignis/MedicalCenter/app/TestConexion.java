package com.edu.ignis.MedicalCenter.app;

import com.edu.ignis.MedicalCenter.persistence.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestConexion {
  public static void main(String[] args) {
    try {
      EntityManager em = JPAUtil.getEntityManager();
      em.getTransaction().begin();
      System.out.println("Conexión exitosa a la base de datos MySQL.");
      em.getTransaction().commit();
      em.close();
    } catch (Exception e) {
      System.err.println("Error al conectar con la base de datos:");
      e.printStackTrace();
    }
  }
}
