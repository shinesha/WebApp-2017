package com.webserviceGAE.courseinfo;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AddCourseServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {		
			String cName = req.getParameter("CourseName");
		    String cCredits = req.getParameter("CourseCredits");
		    String cDuration = req.getParameter("CourseDuration");
		    String cTutor = req.getParameter("CourseTutor");
			
		    CourseBean course = new CourseBean(cName, cCredits, cDuration, cTutor);
		    PersistenceManager pm = PersManFact.get().getPersistenceManager();
		    
		    try {
		    	pm.makePersistent(course);
		    }	finally {
		    	pm.close();
		    }
		    
		    resp.setContentType("text/plain");

		    resp.getWriter().println("Hello, " + course);
	}
}
