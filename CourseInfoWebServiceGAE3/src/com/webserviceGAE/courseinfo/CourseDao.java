package com.webserviceGAE.courseinfo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.webserviceGAE.courseinfo.PersManFact;

public enum CourseDao {
	INSTANCE;
	public List<CourseBean> ReturnAllCourses() {
		PersistenceManager pm = PersManFact.get().getPersistenceManager();
		// read the existing entries
		Query q = ((EntityManager) pm).createQuery("select m from CourseBean m");
		List<CourseBean> courses = q.getResultList();
		return courses;
	}

	public void add(String courseName, String courseCredits, String courseDuration, String courseTutor) {
		synchronized (this) {
			PersistenceManager pm = PersManFact.get().getPersistenceManager();
			CourseBean course = new CourseBean(courseName, courseCredits, courseDuration, courseTutor);
			pm.makePersistent(course);
			pm.close();
		}
	}

	public List<CourseBean> getCourse(String userId) {
		PersistenceManager pm = PersManFact.get().getPersistenceManager();
		Query q = ((EntityManager) pm).createQuery("select t from CourseBean t where t.courseName = :userId");
		q.setParameter("UserId", userId);
		List<CourseBean> courses = q.getResultList();

		return courses;
	}

}
