
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webService;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.ProjectManager;
import com.google.gson.Gson;
import dto.CourseBean;

/**
*
* @author Viran Gohil 15500582 
* Web Service Access Class. 
*/

@Path("/WebService")
public class CoursesWebService {
    
            /**
            * Return all courses in JSON format.
            * 
            */
    @GET
    @Path("/getAllCoursesJson")
    @Produces("application/json")
    public String getAllCoursesJson()
        {
        String courses = null;
        try 
        {
            ArrayList<CourseBean> list = null;
            ProjectManager projectManager= new ProjectManager();
            list = projectManager.getAllCourses();
            Gson gson = new Gson();
            System.out.println(gson.toJson(list));
            courses = gson.toJson(list);
        }
        catch (Exception e)
        {
            System.out.println("Exception Error"); //Console 
        }
        return courses;
        }
    
        
            /**
            * Return All courses in Text Format 
            * 
            * 
            */
    @GET
    @Path("/getAllCoursesText")
    @Produces (MediaType.TEXT_PLAIN)
    public ArrayList<CourseBean> getAllCoursesText()
        {
            ArrayList<CourseBean> list = new ArrayList<CourseBean>();
            ProjectManager projectManager= new ProjectManager();
            try {
                list = projectManager.getAllCourses();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(list);
        
        return list;
        }
    
            
            /**
            * Return all courses in XML format 
            * 
            */
    @GET
    @Path("/getAllCoursesXML")
    @Produces (MediaType.APPLICATION_XML)
    public ArrayList<CourseBean> getAllCoursesXML()
        {
            ArrayList<CourseBean> list = new ArrayList<CourseBean>();
            ProjectManager projectManager= new ProjectManager();
            try {
                list = projectManager.getAllCourses();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(list);
        
            return list;
    }
    
    
            /**
            * Execute SQL 'WHERE' clause and 
            * return couses in text format
            * 
            */
    @GET
    @Path("/{URL}")
    @Produces (MediaType.TEXT_PLAIN)
    public ArrayList<CourseBean> getCourseText(@PathParam("URL") String course_name){
        {
            ArrayList<CourseBean> slist = null;
            ProjectManager projectManager= new ProjectManager();
            try{
                slist = projectManager.getCourse(course_name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return slist;
        }
    }
    
            /**
            * Execute SQL 'WHERE' clause and 
            * return courses in JSON format. 
            * 
            */
    @GET
    @Path("/getCourseJson")
    @Produces("application/json")
    public String getCourseJSON(@PathParam("course_name") String course_name){
            String courses;
        
            ArrayList<CourseBean> slist = null;
            ProjectManager projectManager= new ProjectManager();
            try {
                slist = projectManager.getCourse(course_name);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Gson gson = new Gson();
            System.out.println(gson.toJson(slist));
            courses = gson.toJson(slist);
        
        return courses;    
    }
    
    @GET
    @Path("/{coursename}/{coursecredits}/{courseduration}/{coursetutor}")
    @Produces (MediaType.TEXT_PLAIN)
    public ArrayList<CourseBean> addCourse
            (@PathParam("coursename") String coursename, 
            @PathParam("coursecredits") String coursecredits, 
            @PathParam("courseduration") String courseduration,
            @PathParam("coursetutor") String coursetutor)
        {
            ArrayList<CourseBean> slist = null;
            ProjectManager projectManager= new ProjectManager();
            try{
                slist = projectManager.getCourse(coursename);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return slist;
        }

}
