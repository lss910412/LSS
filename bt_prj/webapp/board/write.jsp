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

write.jsp<hr>


<hr>
<font color ="${KEY_VO.bgcolor}">${KEY_VO.btitle} 게시판 등록 폼</font>
<form action="/writeServlet" method="post"><br>
<input type="hidden" name="code" value="${KEY_VO.code}">
<c:if test="${KEY_VO.attach_yn == 'y'}">
첨부:<input type="file"><br>
</c:if>
제목 : <input type="text" name="btitle"><br>
<input type="submit">
댓글 : <input type="text" name="reply"><br>
</form>

</body>
</html>