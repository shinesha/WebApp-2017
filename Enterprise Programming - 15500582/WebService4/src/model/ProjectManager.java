/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;
import dao.Project;
import dto.CourseBean;

/**
*
* @author Viran Gohil 15500582 
* Controller Class that brings together the DB connection 
* and methods to insert and retrieve. 
*/

public class ProjectManager {
	
				/**
				*Execution or database connection and
				*method to return all courses. 
				* 
				*/
public ArrayList<CourseBean> getAllCourses()throws Exception {
		ArrayList<CourseBean> courses = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			Project project= new Project();
			courses=project.getAllCourses(connection);
		}
		catch (Exception e) {
		throw e;
		}
		return courses;
		}

				/**
				*Execution of database connection and 
				*method to return courses with SQL
				*'WHERE' clause. 
				* 
				*/
public ArrayList<CourseBean> getCourse(String course_name)throws Exception {
		ArrayList<CourseBean> slist = null;
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			Project project= new Project();
			slist = project.getCourse(course_name);
		}
		catch (Exception e) {
		throw e;
		}
		return slist;
		}

}