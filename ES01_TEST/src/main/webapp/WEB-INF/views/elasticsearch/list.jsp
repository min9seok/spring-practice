<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
#list th:nth-child(1) {
	width: 100px;
}

#list th:nth-child(2) {
	width: auto;
}

#list th:nth-child(3) {
	width: 110px;
}

#list td:nth-child(1) {
	text-align: center;
}

#list td:nth-child(3) {
	text-align: center;
}

form {
	border: 1px solid #CCC;
	margin: 1rem;
	padding-bottom: .5rem;
	display: none;
}

form div {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>
		Elasticsearch <small>List</small>
	</h1>

	<div class="seperate">
		<span></span>
		<button type="button" class="add" onclick="location.href='/elasticsearch/add';">문서추가하기</button>
		<button type="button" class="add" onclick="location.href='/elasticsearch/list';">결과 초기화</button>
	</div>

	<table id="list">
		<tr>
			<th>(문서)아이디</th>
			<th>메시지</th>
		</tr>
		<c:forEach items="${list}" var="map">
			<tr>
				<td>${map.id}</td>
				<td>${map.message}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<form method="GET" action="/elasticsearch/list">
		<div class="match_or">
			<h4>검색하기 :: match(or)</h4>
			<div>
				<input type="text" name="word"> <input type="submit" value="검색하기">
			</div>
		</div>
		<input type="hidden" name="type" value="match_or">
	</form>

	<form method="GET" action="/elasticsearch/list">
		<div class="match_and">
			<h4>검색하기 :: match(and)</h4>
			<div>
				<input type="text" name="word"> <input type="submit" value="검색하기">
			</div>
		</div>
		<input type="hidden" name="type" value="match_and">
	</form>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

   <c:if test="${type == 'match_all'}">
      $('form').show();
   </c:if>

   <c:if test="${type != 'match_all'}">
      $('.${type}').parent().show();
      $('.${type} input[name=word]').val('${word}');
      
   </c:if>
      
</script>
</body>
</html>