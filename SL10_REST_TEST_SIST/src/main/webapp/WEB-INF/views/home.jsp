<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
	<link rel="stylesheet" href="/resources/cdn-main/example.css">
	<script src="/resources/cdn-main/example.js"></script>
	<script src="/resources/js/dept.js"></script>
	
</head>
<body>
<h1>
	Hello world! - ${ name }  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h3><a href="/deptEmp">http://localhost/deptEmp</a></h3>

<div>

	<form action="" method="get">
	   empno : <input type="text" id="empno" name="empno" value="7369">
	   <input type="button" id="idCheck" value="ID중복체크">
	   <br>
	   ename : <input type="text" id="ename" name="ename"  value="hong">  
	</form>

</div>

<script>
  $(function (){
	 $("#idCheck").on("click", function (){
		 var empno = $("#empno").val();
		 console.log( `> empno = \${empno}` );
		 $.ajax({
			 url:"/idCheck"   // HomeAjaxController.java
			 , method: "GET"
			 , data: { empno : empno }     // js Object
			 , dataType: "json"
			 , success: function ( data, callback, xhr ){
  	        	  // alert( data ); // 1  0
  	        	  // alert( data ); object Object 
  	        	  
  	        	  // {"empno":"7369","ename":"홍길동","idCheckResult":1}  	        	 
  	        	  alert( data.idCheckResult ); // 1  0
  	          } 
			 , error: function ( xhr, errorType){
  	        	  alert( errorType );
  	          } 
		 });
	 }); 
  });
</script>

<!-- Dept 테이블에 부서를 추가 모달창 -->
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

<script>
// 부서 추가 버튼 클릭.
$("#add-modal #add-dept").on("click", function (){
	let deptno = $("#add-modal :text[name=deptno]").val();
	let dname = $("#add-modal :text[name=dname]").val();
	let loc = $("#add-modal :text[name=loc]").val();	
	console.log(`>> deptno=\${ deptno}`);
	
	// js Object
	let dept = {
			deptno: deptno
			, dname: dname
			, loc: loc
	};
	
	// [dept.js]
	deptService.add(dept, function (result){
		if(result === 'SUCCESS'){
			alert( result );
		} // 
	} );
	
});

// 4:03 수업 시작 ~
// 부서 삭제 버클릭.
$("#add-modal  button.delete").on("click", function (){
	if (   confirm("정말 삭제할까요?")  ) {
		let deptno = $("#add-modal :text[name=deptno]").val();
		console.log(`>> 삭제할 deptno=\${ deptno}`);
		deptService.remove(deptno, function (result){
			if(result === 'SUCCESS'){
				alert( result );
			} // 
		} );
	} // if
});
</script>
</body>
</html>
 
 
 
 
 
 
 
 
 
 
 




