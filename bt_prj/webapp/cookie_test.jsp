<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    //$("#btn").click(function(){
    //	 todo		
    //});
});
</script>
</head>
<body>
<%
Cookie[] carr = request.getCookies();
//Cookie cookie;
if (carr != null && carr.length > 0) {
		for (int i = 0; i < carr.length; i++) {
				if(carr[i].getName().equals("COOK_NAME")) 
						System.out.println(carr[i].getValue());
		    out.print("Name : " + carr[i].getName() + ",  ");
		    out.print("Value: " + carr[i].getValue() + " <br/>");
		    //out.println("Value: " +  URLDecoder.decode(carr[i].getValue()) + " <br/>");
		 }
} else {
		out.println("쿠키 널..");
}
%>

</body>
</html>