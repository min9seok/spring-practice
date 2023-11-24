<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<div>
<a href="/scott/dept">dept</a>
 <xmp class="code">
  1. org.doit.ky.domain 패키지 추가 
   DeptDTO.java
   EmpDTO.java
  2. <a href="/scott/dept">dept</a> 추가 
  3. /scott/dept 요청 url -> ScottController.java 생성      
  4. views > scott > dept.jsp 추가
  5. org.doit.ky.mapper.scott 패키지 > ScottMapper 인터페이스
  6. org.doit.ky.mapper.scott 폴더 > DeptMapper   xml
ScottController.java 스프링 빈 객체 생성 : s-c.xml <context:component-scan base-package="org.doit.ky" />  
org.dept.ky.mapper.scott.DeptMapper.java 스프링 빈 객체 생성 : base-package 하위 패키지는 전체 다 포함 
 <mybatis-spring:scan base-package="org.doit.ky.mapper"/>
 </xmp>  
</div>
</body>
</html>
