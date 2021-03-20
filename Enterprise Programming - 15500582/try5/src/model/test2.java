package model;

import dto.CourseBean;
import dao.CourseDAO;

public class test2 {
    public static void main(String[] args) {
        CourseDAO me = new CourseDAO();
        CourseBean joke = new CourseBean();
        joke.setCourseCredits("40");
        joke.setCourseName("Latin");
        joke.setCourseTutor("Dr Jones");
        joke.setCourseDuration("12 Months");
        me.addCourse(joke);
    }
}