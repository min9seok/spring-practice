<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">Ky Spring Home</a></h1>
  <ul>
    <sec:authorize access="isAnonymous()">
       <li><a href="#">로그인</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
       <li><a href="#">로그아웃</a></li>
    </sec:authorize>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<div>
 <xmp class="code">
 /board/list?현재페이지=2&한페이지출력게시글수=10&검색조건=1&검색어=1
 1. Criteria.java
    PageDTO.java
 2. BoardMapper.xml 수정
    2개 추가
 3. BoardMapper.java 
    2개 추가
 4. BoardSerivce.java
    BoardSerivceImpl.java
 5. BoardController.java
   /board/list 페이칭 처리 응답
 6. list.jsp 수정                 
  </xmp>  
</div>
</body>
</html>
