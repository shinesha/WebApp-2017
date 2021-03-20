/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.io.PrintStream;

import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author Viran Gohil 15500582 
* Course basic bean. 
*/

@XmlRootElement
public class CourseBean 
{
    private String courseName;
    private String courseCredits;
    private String courseDuration;
    private String courseTutor;
    
    public CourseBean() 
    {
    }

    public CourseBean(String courseName, String courseCredits, String courseDuration, String courseTutor) 
    {
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.courseDuration = courseDuration;
        this.courseTutor = courseTutor;
        System.out.println("new bean created with name of: " + courseName);
    }

    public String getCourseName() 
    {
        return this.courseName;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseCredits() 
    {
        return this.courseCredits;
    }

    public void setCourseCredits(String courseCredits) 
    {
        this.courseCredits = courseCredits;
    }

    public String getCourseDuration() 
    {
        return this.courseDuration;
    }

    public void setCourseDuration(String courseDuration) 
    {
        this.courseDuration = courseDuration;
    }

    public String getCourseTutor() 
    {
        return this.courseTutor;
    }

    public void setCourseTutor(String courseTutor) 
    {
        this.courseTutor = courseTutor;
    }

    public String toString() 
    {
        return "CourseBean [courseName=" + this.courseName + ", courseCredits=" + this.courseCredits + ", courseDuration=" + this.courseDuration + ", courseTutor=" + this.courseTutor + "]";
    }
}