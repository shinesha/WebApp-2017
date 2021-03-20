package com.democo.gae.java.todo.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.democo.gae.java.todo.*;

public class EMFService {
  private static final EntityManagerFactory emfInstance = Persistence
      .createEntityManagerFactory("transactions-optional");

  private EMFService() {
  }

  public static EntityManagerFactory get() {
    return emfInstance;
  }
}