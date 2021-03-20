/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dto.DataTableObject;
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

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Viran Gohil 15500582 Class to return full list of courses and
 *         information in the format request by the user (XML, JSON or text)
 */

@WebServlet(value = { "/returnAllcourses" })
public class ReturnAllCourses extends HttpServlet {

	/**
	 * Initialise
	 */
	public void init() throws ServletException {
		CourseDAO returnAllCoursesObj = new CourseDAO();
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

		// Instantiate an ArrayList
		ArrayList<CourseBean> sList = new ArrayList();
		// Instantiate a Course DAO data access object.
		CourseDAO returnAllCoursesObj = new CourseDAO();
		// Execute CourseDAO object applying method to return all DB data and
		// save in array.
		sList = returnAllCoursesObj.getAllCourses("");
		System.out.println(sList);
		request.setAttribute("sList", sList);

		// select format of data returned
		String format = request.getParameter("format");
		if ("xml".equals(format)) {
			response.setContentType("text/xml");
			outputPage = "/WEB-INF/results/course-xml.jsp";

		} else if ("text/plain".equals(format)) {

			response.setContentType("text/plain");
			outputPage = "/WEB-INF/results/course-string.jsp";

		} else {
			// output JSOn as default as easiest to implement JQuery
			// DataTables plugin.
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			// Instantiate DataTable object
			DataTableObject dataTableObject = new DataTableObject();
			// Pass Array containing DB data into our DataTable Object
			dataTableObject.setAaData(sList);
			// Convert dataTable object to JSON
			// Pretty Printing to make JSON easier to read in the JSP page.
			Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
			String json = gson1.toJson(dataTableObject);
			System.out.println(json);
			outputPage = "/WEB-INF/results/course-json.jsp";
			out.print(json);
			// Data can also be viewed at ajaxDataTable.jsp

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include((ServletRequest) request, (ServletResponse) response);
	}
}