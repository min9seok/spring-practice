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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h3><a href="/deptEmp">http://localhost/deptEmp</a></h3>
<div>
<form action="">
  empno : <input type="text" id="empno" name="empno" value="7369"/>
  <input type="button" id="idCheck" value="ID중복체크"/>
  <br>
  ename : <input type="text" id="ename" name="ename" value="kmys"/>
</form>  
</div>
<script type="text/javascript">
 $(function(){
	$("#idCheck").click(function(){
		var empno = $("#empno").val();
	$.ajax({
		url: "/idCheck"  // HomeAjaxController.java
	  , method: "GET"
	  , data: {empno : empno}         // js Object
	  , dataType: "json"
	  , success: function(data,callback,xhr){
// 		  alert(data.idCheckResult);
// 			alert(data);
		  if(data.idCheckResult==0){
			  alert("사용 가능한 ID입니다.");
		  }else{
			  alert("이미 존재하는 ID입니다.");
		  }		  
	  }
	  , error: function(xhr, errorType){
		  alert(errorType);
	  }
	});	
	});
 });
</script>
<!-- Dept 테이블 부서 추가 모달 -->
<!-- The Modal -->
<div id="add-modal" class="modal">
<!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header"> 
      <h2>Ajax 부서 추가</h2>
    </div>
    <div class="modal-body">
      <div class="group">
        <label>부서번호</label>
        <input type="text" class="short" name="deptno" value="50">
       </div>
       <div class="group">
           <label>부서명</label>
           <input type="text" class="short" name="dname" value="QC">
       </div>
       <div class="group">
           <label>지역명</label>
           <input type="text" class="short" name="loc" value="SEOUL">
       </div>
       <div>
           <button id="add-dept" type="button" class="ok">확인</button>
           <button type="button" class="delete">삭제</button>
       </div>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div> 
</div>
<script type="text/javascript">
$(function(){
	var deptno = $("input[name=deptno]").val();
	var dname  = $("input[name=dname]").val();
	var loc    = $("input[name=loc]").val();
 $("#add-dept").click(function(){
   let dept = {
		deptno: deptno
	  , dname: dname
	  , loc: loc
	};
   deptService.add(dept, function(result){
     if(result == "SUCCESS"){
    	 alert(result);
     } 	
	});
 });
 $(".delete").click(function(){
	 if(confirm("삭제하슈")){
	 deptService.remove(deptno, function(result){		
	     if(result == "SUCCESS"){
	    	 alert(result);
	     } 	
		});
	 }
 });
});
</script>
</body>
</html>
