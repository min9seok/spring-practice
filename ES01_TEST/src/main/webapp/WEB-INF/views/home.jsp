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
<h3><a href="/time">/time</a></h3>
<h3><a href="/elasticsearch/list">elasticsearch/list</a></h3>
<div>
<xmp class="code">
 
</xmp>  
</div>
</body>
</html>
