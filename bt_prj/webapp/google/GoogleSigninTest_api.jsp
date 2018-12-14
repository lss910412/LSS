<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#googleAuthBtn").click(function(){
    	 	//로그인처리
    	//------------------------- signIn() ------------------------------------
   	 var varGoogleAuth = gapi.auth2.getAuthInstance();
   		//로드된  lib를 사용해 로그인 
   	 if(!varGoogleAuth.isSignedIn.get()) { 
				   	 varGoogleAuth.signIn().then(
				   				function(){
				   						console.log("1.signIn() ok");
				   					  $("#googleAuthBtn").val("LOGOUT"); //	http://localhost:8088/google_redirect
				   					 
				   						//로드된  lib를 사용해 로그인한 사용자 정보 가져오기
				   						var varGoogleUser = varGoogleAuth.currentUser.get()
				   						console.log("user uniq.ID:" + varGoogleUser.getId());
				   						//varGoogleUser.getHostedDomain()
				   						//varGoogleUser.getGrantedScopes()
				   						
				   						var varBasicProfile = varGoogleUser.getBasicProfile()
				   						console.log("profil uniq.ID:"+varBasicProfile.getId());
				   						console.log("profil name:"+varBasicProfile.getName());
				   						console.log("profil img:"+varBasicProfile.getImageUrl());
				   						console.log("profil email:"+varBasicProfile.getEmail());
				   						
				   						var authResponse = varGoogleUser.getAuthResponse();
				   						console.log("ID_TOKEN:" + authResponse.id_token);
				   						console.log("ACCESS_TOKEN:" + authResponse.access_token);
				   						//response_type: 'id_token permission'
				   						
				   				},
				   				function(){
				   						console.log("1.signIn() faild");
				   				}
				   		); 
   	 		} else {
   	 		 		varGoogleAuth.signOut().then(
   	 		 			function() {
   	 		 					console.log("2.signOut()");
   	 		 				  $("#googleAuthBtn").val("LOGIN");
   	 		 			},
   	 		 			function() {
   	 		 					console.log("2.signOut() faild");
   	 		 			}
   	 		 		);
   	 		}			
    });
});
</script>
<script>
function googleLibLoad() {
	//------------------------- load() ------------------------------------
	  gapi.load('auth2', googleAuth);
}			  
			  
function googleAuth() {
		//------------------------- init() ------------------------------------
		//var varGoogleAuth = 
		gapi.auth2.init(
				{client_id:'132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com'}
				,{scope: "https://www.googleapis.com/auth/devstorage.read_write"}
		).then(
				function(){
					console.log("00.google lib load")
				},
				function(){
					console.log("00.google lib load faild")
				}
	  );
	 
	 //동의화면.............................
		
	 
		//googleAuth.signIn();
		
		
		
		//googleUser.isSignedIn()
		//googleAuth.isSignedIn.get()//true/false
		

		//로드된  lib를 사용해 로그아웃
		//googleAuth.signOut()
		
		
		
		//googleAuth.disconnect()
		//googleAuth.grantOfflineAccess()
}
</script>
</head>
<body>
Google singin Test <hr>
<input type="button" id="googleAuthBtn" value="로그인"><br>
<div id="resdiv"></div>



<script src="https://apis.google.com/js/platform.js?onload=googleLibLoad" async defer></script>
</body>
</html>