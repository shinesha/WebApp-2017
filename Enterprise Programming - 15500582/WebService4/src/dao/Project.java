/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CourseBean;

/**
 *
 * @author Viran Gohil 15500582 Class with methods to be execute with DB. and
 *         exceute queries.
 */

public class Project {
	private static final String Return = null;
	public Connection connection;
	private boolean status;

	/**
	 * Saves all courses querry in array
	 * 
	 */
	public ArrayList<CourseBean> getAllCourses(Connection connection) throws Exception {
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ALLCOURSES3");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CourseBean courseA = new CourseBean();
				courseA.setCourseName(rs.getString("course_name"));
				courseA.setCourseCredits(rs.getString("course_credits"));
				courseA.setCourseDuration(rs.getString("course_duration"));
				courseA.setCourseTutor(rs.getString("course_tutor"));
				list.add(courseA);
				System.out.println("courseA");
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Method to search DB using 'WHERE' clause. saves output into an array.
	 * 
	 */

	public ArrayList<CourseBean> getCourse(String course_name) throws Exception {
		ArrayList<CourseBean> slist = new ArrayList<CourseBean>();

		try {
			PreparedStatement ps = connection
			.prepareStatement("Select * FROM ALLCOURSES3 WHERE course_name ='" 
			+ course_name + "';");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CourseBean courseA = new CourseBean();
				courseA.setCourseName(rs.getString("course_name"));
				courseA.setCourseCredits(rs.getString("course_credits"));
				courseA.setCourseDuration(rs.getString("course_duration"));
				courseA.setCourseTutor(rs.getString("course_tutor"));
				slist.add(courseA);
				System.out.println("courseA");
			}
			return slist;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean addCourse(CourseBean course) {
		try {
			PreparedStatement ps = connection.prepareStatement(
			"insert into allcourses3(course_name, course_credits, course_duration, course_tutor)VALUES('"
			+ course.getCourseName() + "','" + course.getCourseCredits() + "','"
			+ course.getCourseDuration() + "', '" + course.getCourseTutor() + "'");
			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.status;

	}
}
