package dao;

import java.util.ArrayList;
import dto.CourseBean;

/**
 *
 * @author Viran Gohil 15500582 Class to enable external access to methods to
 *         insert and retrive records whilst hiding the connection details
 *         (username and password) and method logic.
 */

public interface CourseInfo {

	public boolean addCourse(CourseBean course);

	public ArrayList<CourseBean> getAllCourses(String query);

	public ArrayList<CourseBean> getCourse(String course_name);
}
