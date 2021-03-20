<?xml version="1.0" encoding="ISO-8859-1"?>
<%@ page contentType="text/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ReturnAllCoursesServlet>
  <c:forEach var="item" items="${sList}" >
    <CourseBean>
      <courseName>${item.courseName}</courseName>
      <courseCredits>${item.courseCredits}</courseCredits>
      <courseDuration>${item.courseDuration}</courseDuration>
      <courseTutor>${item.courseTutor}</courseTutor>
    </CourseBean>
  </c:forEach>
</ReturnAllCoursesServlet>



