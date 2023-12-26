<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- add.jsp -->
	<h1 class="main">Book Project <small>Add</small></h1>
	
	<form method="POST" action="/book/add">
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="long" value="자바로 배우는 쉬운 자료구조"></td>
		</tr>
		<tr>
			<th>링크</th>
			<td><input type="text" name="link" class="full" placeholder="http://url" value="https://search.shopping.naver.com/book/catalog/32493312281?query=%EC%9E%90%EB%B0%94&NaPm=ct%3Dlpxxoldk%7Cci%3D58363bda8a8059524a144e953b8631444223ac16%7Ctr%3Dboksl%7Csn%3D95694%7Chk%3D623186dc20ad078827050e3a1e5487fa9ded76b0"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><textarea name="description" class="full">『자바로 배우는 쉬운 자료구조』은 알고리즘에 대해 C와 자바 프로그래밍으로 구체화 시키는 방법을 다룬다. 자료구조와 알고리즘을 어렵고 추상적인 이론으로만 다루지 않고 쉽게 이해할 수 있도록 다양한 그림을 통해 풀어 설명하고 자바 프로그래밍을 통하여 실제적으로 사용할 수 있도록 하였다.</textarea></td>
		</tr>
		<tr>
			<th>표지</th>
			<td><input type="text" name="image" class="full" placeholder="http://url" value="https://shopping-phinf.pstatic.net/main_3249331/32493312281.20230926084641.jpg?type=w300"></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="author" class="short" value="이지영"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" name="discount" min="0" max="100000" value="23560"></td>
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="publisher" class="short" value="한빛아카데미"></td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td><input type="text" name="isbn" class="short" value="9788998756420"></td>
		</tr>
		<tr>
			<th>출판일</th>
			<td><input type="text" name="pubdate" class="short" placeholder="20230101" value="20130730"></td>
		</tr>
	</table>
	
	<div>
		<button type="button" class="list" onclick="location.href='/book/list';">돌아가기</button>
		<button type="submit" class="add">도서추가하기</button>
	</div>
	
	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	
	</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>