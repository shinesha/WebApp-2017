/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dto.CourseBean;
import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viran Gohil 15500582 Class to insert new course information in the DB
 * 
 */
@WebServlet(value = { "/insertCourse" })
public class InsertCourse extends HttpServlet {
	CourseDAO insertCourseObj;
	CourseBean course;

	/**
	 * Initialise
	 */
	public void init() throws ServletException {
		this.insertCourseObj = new CourseDAO();
		this.course = new CourseBean();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Get course information from user. Must be converted to String. 
		String cName = request.getParameter("CourseName");
		String cCredits = request.getParameter("CourseCredits");
		String cDuration = request.getParameter("CourseDuration");
		String cTutor = request.getParameter("CourseTutor");
		
		
		//Set course information into a CourseBean object. 
		this.course.setCourseName(cName);
		this.course.setCourseCredits(cCredits);
		this.course.setCourseDuration(cDuration);
		this.course.setCourseTutor(cTutor);
		System.out.println("GOT >>> " + this.course.getCourseName());
		
		//Pass the CourseBean object into the CourseDAO object applying the addcourse to 
		//databse methid. 
		if (this.insertCourseObj.addCourse(this.course)) {
			System.out.println(" 1 = courses saves successfully");
		} else {
			System.out.println(" 0 = failure");
		}
	}
}