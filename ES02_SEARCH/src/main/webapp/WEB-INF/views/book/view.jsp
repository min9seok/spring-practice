<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	table td img { height: 200px; object-fit: cover; }
</style>
</head>
<body>
	<!-- view.jsp -->
	<h1 class="main">Book Project <small>View</small></h1>
	<div>
		<button type="button" class="list" onclick="history.back();">돌아가기</button>
	</div>
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>링크</th>
			<td><a href="${dto.link}" target="_blank">네이버 서점으로 이동하기</a></td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${dto.description}</td>
		</tr>
		<tr>
			<th>표지</th>
			<td><img src="${dto.image}"></td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${dto.author}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${dto.discount}</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>${dto.publisher}</td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${dto.isbn}</td>
		</tr>
		<tr>
			<th>출판일</th>
			<td>${dto.pubdate}</td>
		</tr>
	</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>