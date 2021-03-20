<%--
	Document: Submit Form
	Author	: Viran Gohil 

 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form1" method="GET" action="insertCourse" id="form1">
	<table>
		<tr>
			<td>Course Name</td><td><input type="text" name="CourseName"/></td>
		</tr>
		<tr>
			<td>Course Credits</td><td><input type="text" name="CourseCredits"/></td>
		</tr>
		<tr>
			<td>Course Duration</td><td><input type="text" name="CourseDuration"/></td>
		</tr>
		<tr>
			<td>Course Tutor</td><td><input type="text" name="CourseTutor"/></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="submit"/></td>
		</tr>
		<tr>
		
	</table>
</form>

</body>
</html>
<script type="text/javascript" src="scripts/jquery1.js"></script>
<script type="text/javascript">

var from=$('#fomr1');
from.submit(function() {
	
$.ajax({
	type: from.attr('method'),
	url: "./insertCourse",
	data: from.serialize(),
	success: function (data) {
		var result=data;
		$('#result').attr("value".result);
	}
});
	return false
});
</script>










