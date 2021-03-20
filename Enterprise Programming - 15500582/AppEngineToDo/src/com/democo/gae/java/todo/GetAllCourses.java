package com.democo.gae.java.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.democo.gae.java.todo.DAO.*;

/**
 * Servlet implementation class getMeterReading
 */
@SuppressWarnings("serial")
public class GetAllCourses extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outputPage;

		// Instantiate an ArrayList
		
		// Instantiate a Course DAO data access object.
		// Execute CourseDAO object applying method to return all DB data and
		// save in array.
		CourseDAO.INSTANCE.getAllCourses();

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
			//DataTableObject dataTableObject = new DataTableObject();
			// Pass Array containing DB data into our DataTable Object
			//dataTableObject.setAaData(sList);
			// Convert dataTable object to JSON
			// Pretty Printing to make JSON easier to read in the JSP page.
			//Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
			//String json = gson1.toJson(dataTableObject);
			//System.out.println(json);
			outputPage = "/WEB-INF/results/course-json.jsp";
			//out.print(json);
			// Data can also be viewed at ajaxDataTable.jsp

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include((ServletRequest) request, (ServletResponse) response);
	}
}
