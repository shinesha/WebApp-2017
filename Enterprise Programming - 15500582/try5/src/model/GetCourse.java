/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dto.CourseBean;
import dao.CourseDAO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 *
 * @author Viran Gohil 15500582 Class to return course list sorted by user
 *         inputing course name and/or format (XML, JSON or text)
 */

@WebServlet(value = { "/get-course" })
public class GetCourse extends HttpServlet {
	CourseDAO aCourse;
	CourseBean returnSomeCoursesObj;
	

	/**
	 * Initialise
	 */
	public void init() throws ServletException {
		CourseDAO aCourse = new CourseDAO();
		this.returnSomeCoursesObj = new CourseBean();
		
	}

	/**
	 * Handles the HTTP <code>GET</code> medthod
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet error.
	 * @throws IOException
	 *             if an I/O error.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outputPage;
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		// Instantiate ArrayList
		ArrayList<CourseBean> sList = new ArrayList<CourseBean>();
		// Instantiate
		CourseDAO aCourse = new CourseDAO();
		// User inputs coursename to search by row in DB.
		String course_name = request.getParameter("coursename");

		System.out.println(course_name);
		// Execute method and save output in array
		sList = aCourse.getCourse(course_name);

		request.setAttribute("aCourse", sList);
		System.out.println(sList);
		// user selects format
		String format = request.getParameter("format");
		// Select xml to output to jsp page
		
		if ("xml".equals(format)) {
			response.setContentType("text/xml");
			outputPage = "/WEB-INF/results/course-xml2.jsp";
			// select json to output to jsp page.
		} else if ("json".equals(format)) {
			response.setContentType("application/json");

			PrintWriter out = response.getWriter();

			// Factory method construct to deserialize. Java Array to Json.
			Gson gson = new Gson();
			String jsonorsomething = gson.toJson(sList);
			response.setContentType("application/json");
			request.setAttribute("Json", jsonorsomething);

			outputPage = "/WEB-INF/results/course-json2.jsp";

			System.out.println(jsonorsomething);
			// return in text format if no format selected.
		} else {
			response.setContentType("text/plain");
			outputPage = "/WEB-INF/results/course-string2.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include((ServletRequest) request, (ServletResponse) response);
	}
}