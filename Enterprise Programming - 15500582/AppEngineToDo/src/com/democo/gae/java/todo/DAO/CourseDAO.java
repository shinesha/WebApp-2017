package com.democo.gae.java.todo.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.democo.gae.java.todo.DAO.EMFService;


import com.democo.gae.java.todo.CourseBean;


public enum CourseDAO {
	INSTANCE;

	//MISSING ADD COURSE METHOD WHERE THE DATA CONNECTION IS WITHIN THE SERVLET. 
	//WRONG WAY TO DO THIS BUT I AM OUT OF TIME BEFORE ASIGNMENT SUBMISSION. 
	
	public List<CourseBean> getAllCourses() {
		EntityManager em = EMFService.get().createEntityManager();	
		Query q = em.createQuery("select c from CourseBean c");
		List<CourseBean> courses = q.getResultList();
	    
		return courses;
	}

// Method TO return course based on course name input 
  public CourseBean getCourse(String course_name) {
	  EntityManager em = EMFService.get().createEntityManager();	
		  Query q = em.createQuery("select er from CourseBean er where er.daykey = :course_name");
		    q.setParameter("course_name", course_name);
	        List<CourseBean> le = q.getResultList();

		    return le.get(0);
		  }


	   
// end of class	
}
