<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<script src="/resources/js/dept.js"></script>

<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<div>
<select id="dept">
<c:forEach items="${listdept }" var="dto">
<option value="${dto.deptno }">${dto.dname }</option>
</c:forEach>
</select>
<br><br>
<table>
<thead>
<tr>
<td><input type="checkbox" /></td>
<td>empno</td>
<td>ename</td>
<td>job</td>
<td>mgr</td>
<td>hiredate</td>
<td>sal</td>
<td>comm</td>
<td>deptno</td>
</tr>
</thead>
<tbody class="table_body">
<c:forEach items="${listemp }" var="dao">
<tr>
<td><input type="checkbox" /></td>
<td>${dao.empno }</td>
<td>${dao.ename }</td>
<td>${dao.job }</td>
<td>${dao.mgr }</td>
<td>${dao.hiredate }</td>
<td>${dao.sal }</td>
<td>${dao.comm }</td>
<td>${dao.deptno }</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
<script type="text/javascript">
 $(function(){
	$("#dept").change(function(){
		var deptno = $("#dept").val()		
	$.ajax({
		url: "/selectemp"  // HomeAjaxController.java
	  , method: "GET"
	  , data: {deptno : deptno}         // js Object
	  , dataType: "json"
	  , success: function(data, callback, xhr){
          console.log("통신성공");
          console.log(data);
          str = '<TR>'; 
              $.each(data , function(i){
            	  str += '<TD>' + '<input type="checkbox"/>' + '</TD><TD>' + data[i].empno + '</TD><TD>' + data[i].ename + '</TD><TD>' + data[i].job + '</TD>'+'<TD>'+data[i].mgr+'</TD>'+'<TD>' + data[i].hiredate + '</TD>' +'<TD>' + data[i].sal + '</TD><TD>' + data[i].comm + '</TD><TD>'+ data[i].deptno + '</TD>';
           str += '</TR>';
              });
          $('.table_body').html(str);
      }
	  , error: function(xhr, errorType){
		  alert(errorType);
	  }
	});	
	});
 });
</script>
</body>
</html>
