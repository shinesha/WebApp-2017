/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.democo.gae.java.todo;

import javax.jdo.annotations.*;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GenerationType;

	/**
	 * @author Viran Gohil 15500582
	 * CourseBean bean class with 4 attributes for 
	 * data transfer. 
	 */

@Entity
public class CourseBean 
{
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    private String courseName;
	
	
    private String courseCredits;
	
	
    private String courseDuration;
	
	
    private String courseTutor;

		    /**
		     *  Constructor
		     */
    public CourseBean(String courseName, String courseCredits, String courseDuration, 
    		String courseTutor) 
    {
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.courseDuration = courseDuration;
        this.courseTutor = courseTutor;
        System.out.println("new bean created with name of: " + courseName);
    }
    
    		/**
    		 * no argument constructor
    		 */
    public CourseBean() 
    {
    }
    
		    /**
		     *  get Course Name
		     *  @return
		     */
    public String getCourseName() 
    {
        return this.courseName;
    }
    
    
		    /**
		     *  set coursebean Course Name
		     *  @param courseName new courseName
		     */
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }
    
		    /**
		     *  get Course Credits
		     *  @return
		     */
    public String getCourseCredits() 
    {
        return this.courseCredits;
    }
    
		    /**
		     *  set coursebean Course Credits
		     *  @param courseCredits new courseCredits
		     */
    public void setCourseCredits(String courseCredits) 
    {
        this.courseCredits = courseCredits;
    }

		    /**
		     *  get CourseDuration
		     *  @return
		     */
    public String getCourseDuration() 
    {
        return this.courseDuration;
    }
    
		    /**
		     *  set coursebean CourseDuration
		     *  @param courseDuration new CourseDuration.
		     */
    public void setCourseDuration(String courseDuration) 
    {
        this.courseDuration = courseDuration;
    }
    
		    /**
		     *  get Course Tutor
		     *  @return
		     */
    public String getCourseTutor() 
    {
        return this.courseTutor;
    }
    
		    /**
		     *  set coursebean CourseTutor
		     *  @param courseTutor new CourseTutor
		     */
    public void setCourseTutor(String courseTutor) 
    {
        this.courseTutor = courseTutor;
    }

    public String toString() {
        return "CourseBean [courseName=" + this.courseName + ", courseCredits=" + this.courseCredits + ", courseDuration=" + this.courseDuration + ", courseTutor=" + this.courseTutor + "]";
    }
}