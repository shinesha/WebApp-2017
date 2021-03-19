package com.webserviceGAE.courseinfo;

import javax.persistence.EntityManagerFactory;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.persistence.Persistence;

public class PersManFact { 
	 private static final PersistenceManagerFactory pmfInstance = 
			 JDOHelper.getPersistenceManagerFactory("transactions-optional");
			 
	 private PersManFact() 
	 {
	 }
	 public static PersistenceManagerFactory get() 
	 {
	 return pmfInstance;
	 }
}
