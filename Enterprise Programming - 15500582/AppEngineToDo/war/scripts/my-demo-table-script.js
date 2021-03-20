$(document).ready(function() {
	
	$(".jqueryDataTable").dataTable({
		"bProcessing": false,
		"bServerSide": false,
		"sAjaxSource": "./returnAllcourses",
		"bJQueryUI": true,
		"aoColumns": [
		     { "mData": "courseName"},
		     {"mData": "courseCredits"},
		     {"mData": "courseDuration"},
		     {"mData": "courseTutor"}
		     
		     ]
	});
});
