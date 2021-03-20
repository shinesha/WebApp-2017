<%--
	Document: ajxDataTable
	Author	: Viran Gohil 

 --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css" title="currentStyle">
	@import "//cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css";
</style>
</head>
<body>
	<div class="table-container">
		<table cellpadding="0" cellspacing="0" border="0" class="display jqueryDataTable">
			<thead>
			<tr>
				<th>courseName</th>
				<th>courseCredits</th>
				<th>courseDuration</th>
				<th>courseTutor</th>
			</tr>
			</thead>
		</table>
		</div>
		<script src="scripts/jquery1.js"></script>
		<script src="scripts/jquery.dataTables.min.js"></script>
		<script src="scripts/jquery-ui.js"></script>
		<script src="scripts/my-demo-table-script.js"></script>
</body>
</html>