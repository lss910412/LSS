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
<div>
<c:forEach items="${KEY_LIST}" var="vo">
	<tr>
		<td>
		<a href="/manager?code=${vo.code}">${vo.btitle}</a>
		</td>
	</tr>
</c:forEach>
</div>

<div id="content" name="content">
<table border="1">
<tr>
<td>seq</td>
<td>title</td>
<td>regid</td>
</tr>
<tr>
<td>1</td>
<td>title111</td>
<td>kim</td>
</tr>
<tr>
<td>2</td>
<td>title222</td>
<td>ki22m</td>
</tr>
</table>
</div>


</body>
</html>