<%@ page import="com.webserviceGAE.courseinfo.*" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>

<html>

<body>
<% 
String query = "select from " + CourseBean.class.getName();
PersistenceManager pm = PersManFact.get().getPersistenceManager();
List<CourseBean> coursesA = (List<CourseBean>)pm.newQuery(query).execute();

for (CourseBean course : coursesA)
	{
%>
	Course Name: <%= course.getCourseName() %> <BR>
	Course Credits: <%= course.getCourseCredits() %><BR>
	Course Duration: <%= course.getCourseDuration() %><BR>
	Course Tutor: <%= course.getCourseTutor() %> <BR><BR>
<% 
	}
%>

</body>
</html>