/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.CourseBean;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Viran Gohil 15500582 Class to save and retrieve records.
 */

public class CourseDAO {
	// Instance of the DB connection
	private Connection conn = CourseDBConnect.getConnect().getLink();
	// Statement is the SQL interface
	private Statement stmt;
	// Table of data representing the database information
	private ResultSet rs;
	private String query = "";
	private CourseBean course;
	public boolean status = false;

	/**
	 *
	 * Method to retrieve all records in DB
	 * 
	 */
	public ArrayList<CourseBean> getAllCourses(String query) {
		// Arraylist to accept results of database query.
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		try {
			query = "Select * FROM ALLCOURSES3";
			System.out.print(query);
			// establish DB connection
			Statement stmt = this.conn.createStatement();
			// data returned by query.
			ResultSet rs = stmt.executeQuery("\n" + query);
			// iterate through all columns in table
			while (rs.next()) {
				// add column data to bean object
				CourseBean course = new CourseBean();
				course.setCourseName(rs.getString("course_name"));
				course.setCourseCredits(rs.getString("course_credits"));
				course.setCourseDuration(rs.getString("course_duration"));
				course.setCourseTutor(rs.getString("course_tutor"));
				// add bean object to arraylist.
				list.add(course);
				System.out.println("course");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 *
	 * Method to retrive data with sql where clause limiting rows.
	 */
	public ArrayList<CourseBean> getCourse(String course_name) {
		// Arraylist to accept results of database query.
		ArrayList<CourseBean> sList = new ArrayList<CourseBean>();
		try {
			this.query = "Select * FROM ALLCOURSES3 WHERE course_name ='" + course_name + "';";
			System.out.print(this.query);
			// establish DB connection
			Statement stmt = this.conn.createStatement();
			// data returned by query.
			ResultSet rs = stmt.executeQuery(this.query);
			// iterate through all columns in table
			while (rs.next()) {
				// add column data to bean object
				CourseBean courseA = new CourseBean();
				courseA.setCourseName(rs.getString("course_name"));
				courseA.setCourseCredits(rs.getString("course_credits"));
				courseA.setCourseDuration(rs.getString("course_duration"));
				courseA.setCourseTutor(rs.getString("course_tutor"));
				// add bean object to arraylist.
				sList.add(courseA);
				System.out.println(courseA);
			}
			this.status = true;
			System.out.println(this.query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}

	/**
	 *
	 * Method to add course information
	 * 
	 */
	public boolean addCourse(CourseBean course) {
		try {
			System.out.println("inside the DB Controller!");
			// sql statement
			this.query = "insert into allcourses3(course_name, course_credits, course_duration, course_tutor)VALUES('"
					+ course.getCourseName() + "','" + course.getCourseCredits() + "','" + course.getCourseDuration()
					+ "', '" + course.getCourseTutor() + "');";
			System.out.println(this.query);
			this.stmt = this.conn.createStatement();
			this.status = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.status;
	}
}
