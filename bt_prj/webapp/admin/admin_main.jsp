<%@ page language="java" contentType="text/html; charset=UTF-8"
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
관리자 페이지...
<hr>

${sessionScope.SESS_NAME} <!-- session.setAttribute("SESS_NAME",...)  -->
${requestScope.REQ_PNT}	  <!-- request.setAttribute("REQ_PNT",...)  -->
${param.msg}							<!-- ?msg=val  -->
<hr>
<%
//String msg = request.getParameter("msg");
//out.println(msg);
//String nm = session.getAttribute("SESS_NAME").toString();
//String gbn = session.getAttribute("SESS_GUBUN").toString();
//String pnt = request.getAttribute("REQ_PNT").toString();
//out.println(nm + "," + gbn );
%>			

<hr>
<%

//Google Geolocation은 https://에서만 지원
//https://developers.google.com/web/fundamentals/native-hardware/user-location/?hl=ko
//Chrome Browser : chrome://settings/content
//                 chrome://settings/siteData

Cookie[] carr = request.getCookies();
//G_ENABLED_IDPS : https://carrymap.com/en/cookie-policy/
if (carr != null && carr.length > 0) {
		for (int i = 0; i < carr.length; i++) {
			  out.print(carr[i].getName() + " : " + carr[i].getValue() + " <br/>");
		    //out.println("Value: " +  URLDecoder.decode(carr[i].getValue()) + " <br/>");
		 }
} else {
		out.println("쿠키 널..");
}
%>
<hr>
${cookie.COOK_NAME.value}<br>
${header.Cookie}<br>
${headerValues.Cookie[0]}<br> 

</body>
</html>