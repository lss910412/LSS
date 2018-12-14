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
${param.code}<br>
<c:forEach items="${KEY_LIST}" var="vo">
	<tr>
		<td>
		${vo.title}
		</td>
	</tr>
</c:forEach>

<a href="/board/${KEY_VO.board_insert_url}?code=${KEY_VO.code}">글쓰기</a>



</body>
</html>