var container = $('div.container');
	
	$('input#get').click(function(){
			$.ajax({
				type: 'GET',
				url:"${pageContext.request.contextPath}/returnAllcourses'",
				datatype: 'text',
				success: function(data){
					$.each(data, function(index, item){
						$.each(item, function(key, value){
							container.append(key + ': ' + value + '</br>');
			});
			container.append('<br/></br>');
			})
		}
			});
			})
							
	$(function() {
	
	var $orders=$('#orders');
	$.ajax({
	  type: 'GET',
          url: "${pageContext.request.contextPath}/returnAllcourses'",
	  success: function(jsonorsomething){
		$.each(jsonorsomething, function(i, item){
			$orders.append('<li>name: '+ CourseBean.courseName +', credits: '+ CourseBean.courseCredits + '</li>');
	});
}
});
});
	
	$(document).ready(function() {
	    $('#example').DataTable( {
	        "ajax": '../ajax/data/arrays.txt'
	    } );
	} );
			
			
			
