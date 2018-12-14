<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
<meta name="google-signin-client_id" content="132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  
	  var id_token = googleUser.getAuthResponse().id_token;
	  console.log(id_token);
	  
	  googleUser.grantOfflineAccess({scope: 'profile'}).then(function(res) {
		  	var code = res.code;
 	  		console.log(code);
		  	//$.ajax({});
	  });
	} 
</script>
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
</body>
 -->
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
function googleLibLoad() {
	  gapi.load('auth2', function() {
		  varGoogleAuth = gapi.auth2.init({
	        	client_id: '132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com'
	          //,Scopes to request in addition to 'profile' and 'email'
	      });
    });
}
$(document).ready(function() {
	
	
	$('#signinButton').click(function(){
		varGoogleAuth.signIn({
			scope:'https://www.googleapis.com/auth/calendar'
		}).then(function(){ 
				var varGoogleUser = varGoogleAuth.currentUser.get();			
				//console.log(varGoogleUser.getBasicProfile().getName());
				var id_token = varGoogleUser.getAuthResponse().id_token;
				console.log(id_token);
				
				$("#id_token").val(id_token);
				//$("#authForm").submit();
				/* $.ajax({
					url:"/google_auth",
					type:"get",  
					contentType:"application/x-www-form-urlencoded; charset=utf-8", 
					data:"id_token=" + id_token,
					dataType: "text",  //optional
					success:function(resString){
						console.log(resString);
					}
				}); */
				
				/* varGoogleAuth.grantOfflineAccess().then(function(resJson){
						var code = resJson.code;
					  	console.log(code + "---------" + id_token);
						$.ajax({
							url:"/google_auth",
							type:"get",  
							contentType:"application/x-www-form-urlencoded; charset=utf-8", 
							data:"id_token=" + id_token+"&code="+code ,
							dataType: "text",  //optional
							success:function(resString){
								console.log(resString);
							}
						});
				});   */
		});
    });
});  

</script>
</head>
<body>
<form id="authForm" method="get" action='/google_auth'>
<input type="submit" value="google_auth">
</form> 

<button id="signinButton">Sign in with Googleddd</button>
<script src="https://apis.google.com/js/platform.js?onload=googleLibLoad" async defer></script>
</body>
</html>