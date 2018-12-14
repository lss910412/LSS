<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/modules/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/list",
            "type": "POST"
        },
        "dataSrc": function (d) {
        		console.log(d);
            return d
         },
         //{"data":[{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},{"empno":7521,"ename":"WARD","mgr":0,"hiredate":"1981-02-22","sal":0,"comm":0,"deptno":0},{"empno":7566,"ename":"JONES","mgr":0,"hiredate":"1981-04-02","sal":0,"comm":0,"deptno":0},{"empno":7654,"ename":"MARTIN","mgr":0,"hiredate":"1981-09-28","sal":0,"comm":0,"deptno":0},{"empno":7698,"ename":"BLAKE","mgr":0,"hiredate":"1981-05-01","sal":0,"comm":0,"deptno":0},{"empno":7782,"ename":"CLARK","mgr":0,"hiredate":"1981-06-09","sal":0,"comm":0,"deptno":0},{"empno":8001,"ename":"아무개","mgr":0,"sal":0,"comm":0,"deptno":0},{"empno":7844,"ename":"TURNER1111","mgr":0,"hiredate":"1981-09-08","sal":0,"comm":0,"deptno":0},{"empno":7876,"ename":"ADAMS","mgr":0,"hiredate":"1987-07-13","sal":0,"comm":0,"deptno":0},{"empno":7900,"ename":"JAMES","mgr":0,"hiredate":"1981-12-03","sal":0,"comm":0,"deptno":0}]}
        "columns": [
            { "data": "empno" },
            { "data": "ename" },
            { "data": "mgr" },
            { "data": "sal" },
            { "data": "comm" },
            { "data": "deptno" }
        ]
    } );
} );
</script>
<!-- 
<script>
$(document).ready(function() {
		$('#example').dataTable( {
			"bProcessing": true,
			"bServerSide": true,
			"sAjaxSource": "../examples_support/server_processing.php"
		});
});
</script> -->

</head>
<body>

<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>empno</th>
                <th>ename</th>
                <th>mgr</th>
                <th>sal</th>
                <th>comm</th>
                <th>deptno</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
        </tbody>
    </table>
    
</body>
</html>