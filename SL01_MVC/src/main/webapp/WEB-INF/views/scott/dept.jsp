<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<script src="/resources/js/dept.js"></script>
<style>
span.material-symbols-outlined {
	vertical-align: text-bottom;
}
</style>
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 40%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

/* Add Animation */
@
-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: white;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: white;
	color: black;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: gray;
	color: white;
}

.material-symbols-outlined.delete {
	cursor: pointer;
}
</style>
</head>
<body>
	<header>
		<h1 class="main">
			<a href="#" style="position: absolute; top: 30px;">Ky Spring Home</a>
		</h1>
		<ul>
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</header>
	<h3>
		<span class="material-symbols-outlined">spring</span>
	</h3>
	<div>
		<xmp class="code"> /scott/dept.jsp </xmp>
		<form action="/scott/emp" method="POST">
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Deptno</th>
						<th>Dname</th>
						<th>Loc</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="dto">
						<tr>
							<td><input type="checkbox" data-deptno="${ dto.deptno }"
								value="${ dto.deptno }" name="deptno"></td>
							<td>${ dto.deptno }</td>
							<td>${ dto.dname }<span class="badge right red">${ dto.numberOfEmps }</span></td>
							<td>${ dto.loc }</td>
							<td align="center"><span
								class="material-symbols-outlined delete"
								data-deptno="${ dto.deptno }">close</span></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<button id="search" class="search" type="button">search</button>
							<button id="add" type="button" class="add">부서추가</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<!-- 부서 추가 모달창 -->
		<!-- The Modal -->
		<div id="add-modal" class="modal">

			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<h2>Ajax 부서 추가</h2>
				</div>
				<div class="modal-body">
					<div class="group">
						<label>부서번호</label> <input type="text" class="short" name="deptno"
							value="50">
					</div>
					<div class="group">
						<label>부서명</label> <input type="text" class="short" name="dname"
							value="QC">
					</div>
					<div class="group">
						<label>지역명</label> <input type="text" class="short" name="loc"
							value="SEOUL">
					</div>
					<div>
						<button id="add-dept" type="button" class="ok">확인</button>
						<button type="button" class="cancel">닫기</button>
					</div>
				</div>
				<div class="modal-footer">
					<h3>Modal Footer</h3>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(function(){		
		var addModal = $("#add-modal");		
		$("#add").click(function(){
			addModal.css("display","block");
		});
		$(".cancel").click(function(){
			addModal.css("display","none");
		});
		$("body").click(function(e){						
			if(e.currentTarget == addModal) addModal.css("display","none");
		});
		$("#add-dept").click(function(){
			let deptno = $("#add-modal :text[name=deptno]").val();
			let dname = $("#add-modal :text[name=dname]").val();
			let loc = $("#add-modal :text[name=loc]").val();
			let dept = {
					deptno: deptno,
					dname : dname,
					loc   : loc
			};
			deptService.add(dept, function (result){
		          // 모달창 닫기
		          addModal.css("display", "none"); 
		          // 코딩 추가...
		          if ( result === 'SUCCESS' ) {
		             let tr = $(`
		                   <tr>
		                     <td><input type="checkbox" data-deptno="\${ deptno }" value="\${ deptno }" name="deptno"></td>
		                    <td>\${ deptno }</td>
		                    <td>\${ dname }<span class="badge right red">0</span></td>
		                    <td>\${ loc }</td>
		                    <td align="center"><span class="material-symbols-outlined delete" data-deptno="\${ deptno }">close</span></td>
		                  </tr>
		                   `);   		             
		             $(tr)
		                  .appendTo(  $("table tbody") )   
		                  .find("span.delete")   
		                          .on("click", function (){
		                             if (   confirm("정말 삭제할까요?")  ) {
		                               let deptno = $(this).data("deptno");  // data-deptno=50
		                               var spanDelete = $(this);
		                               deptService.remove( deptno, function (result){
		                                  if( result  === 'SUCCESS' ) 
		                                     spanDelete.parents("tr").remove();
		                               } ); // remove   
		                             } // if
		                          });
		             // $("table tbody").append($(tr));
		          } // if		          
		          alert( result );		          
		      }); // add 
		});
		$(".material-symbols-outlined.delete").click(function(){
			if(confirm("정말 삭제함유?")){
				let deptno = $(this).data("deptno");
				deptService.remove(deptno, function(result){
					if(result == "SUCCESS"){
						$(event.currentTarget).parents("tr").remove();
					}
				});
			}
		});
	$("#search").click(function(){
		if(!$("tbody :checkbox:checked").length){
			alert("부서 체크하쉥");
			return;
		}
		$("form").submit();
	});
		
	});
	</script>
</body>
</html>