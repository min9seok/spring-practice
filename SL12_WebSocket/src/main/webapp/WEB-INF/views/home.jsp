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
<script type="text/javascript">
$(function(){
	$("#sendBtn").click(function(){
		sendMessage();
	});
});
var wsocket;
function sendMessage(){
	wsocket = new WebSocket("http://localhost/echo-ws");
	wsocket.onmessage = onMessage;
	wsocket.onclose = onClose;
	wsocket.onopen = function(){
		wsocket.send($("#message").val());
	}
}
function onMessage(evt){
	var data = evt.data;
	alert("서버에서 데이터 받음 : "+data);
	wsocket.close();
}
function onClose(evt){
	alert("연결 끊김");
}
</script>
<input type="text" id="message" />
<input type="button" id="sendBtn" value="전송" />
</body>
</html>
