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
보드매니저 게시판 만들기<br> 

<form action="/manager" method="post">
code:<input type="text" name="code"><br>
btitle:<input type="text" name="btitle"><br>
attach_yn:<input type="text" name="attach_yn"><br>
list_url:<input type="text" name="board_list_url"><br>
write_url:<input type="text" name="board_insert_url"><br>
bgcolor:<input type="text" name="bgcolor"><br>
<input type="submit" name="게시판만들기">
</form>
</body>
</html>