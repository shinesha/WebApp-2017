<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:forEach var="item" items="${sList}" >
    ${item.courseName}
    ${item.courseCredits}
    ${item.courseDuration}
    ${item.courseTutor}
  </c:forEach>

