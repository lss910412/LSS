<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
//https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete

$(document).ready(function(){
    $("#googleAuthButton").click(function(){
    	
	    	$.ajax({
						url:"/google_auth_init",
						type:"get",  
						contentType:"application/x-www-form-urlencoded; charset=utf-8", 
						dataType: "text",  //optional
						success:function(loginURL){
							console.log(loginURL);
							window.open(loginURL, "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=200,left=300,width=900,height=500");
						}
				});		
    });
});
</script>

${authURL}<hr>
<input type="button" id="googleAuthButton" value="gogle oauth">
<br>

<form id="authForm" method="post" action='${authURL}'>
<input type="submit" value="submit login">
</form> 

</body>
</html>