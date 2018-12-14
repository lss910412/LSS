<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com">
     
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){    
});
</script>
<script>
function googleLibLoad(googleUser) { 
		var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail());
    console.log('id_token: ' + googleUser.getAuthResponse().id_token);
    
  	$.ajax({ 
				url:"/google_auth",
				type:"get",
				//contentType: "application/json; charset=UTF-8", 
				data:"id_token="+googleUser.getAuthResponse().id_token,  
				success:function(){
					console.log("ajax post");
				}
		});
	
}
</script>
</head>
<body>
Google OAuth login Test<hr>
<div class="g-signin2" data-onsuccess="googleLibLoad"></div>

<form>
	<input type="button" id="goGoogleSigninServlet" value="Google OAuth login">
</form>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</body>
</html>