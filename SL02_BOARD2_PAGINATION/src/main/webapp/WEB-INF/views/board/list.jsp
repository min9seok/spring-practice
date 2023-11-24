<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
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
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<h3>
  <span class="material-symbols-outlined">spring</span> 
</h3>
<div>
  <xmp class="code">
    게시글 목록
  </xmp>
       <table>
      <caption style="text-align: right;">
          <a href="/board/register">글쓰기</a>
      </caption>
      <thead>
         <tr>
           <th>#번호</th>
           <th>제목</th>
           <th>작성자</th>
           <th>작성일</th>
           <th>수정일</th>        
         </tr>
      </thead>
      <tbody>        
        <c:choose>
           <c:when test="${ empty  list }">
              <tr>
                <td colspan="5">............없............</td>
              </tr>
           </c:when>
           <c:otherwise>
              <c:forEach items="${ list }"  var="board">
                 <tr>
           <td><c:out value="${ board.bno }" /></td>
           <td><a href="/board/get?bno=${ board.bno }"><c:out value="${ board.title }" /></a></td>
           <td><c:out value="${ board.writer }" /></td>
           <td><fmt:formatDate value="${ board.regdate }" pattern="yyyy-MM-dd"/> </td>
           <td><fmt:formatDate value="${ board.updatedate }" pattern="yyyy-MM-dd"/> </td> 
                 </tr>
              </c:forEach> 
           </c:otherwise>
        </c:choose>
      </tbody>
      <tfoot>
      </tfoot>
    </table>
</div>
<script>
$(function(){
	var result = '<c:out value="${result}"/>';
	var register = '<c:out value="${register}"/>';
	var modify = '<c:out value="${modify}"/>';
	var remove = '<c:out value="${remove}"/>';
	checkModal(result,register,modify,remove);
	history.replaceState({},null,null);
	if($(location).attr('host') != 'localhost'){
		alert("나가주세요🙏🙏🙏");
	}			
});
function checkModal(result,register,modify,remove){
	if(result === '' || history.state) return false;
	if(parseInt( result ) > 0){
	if(register !== ''){
		alert( `\${result} 번 작성완료.`);
	}
	if(modify !== ''){
		alert( `\${result} 번 수정완료.`);
	}
	if(remove !== ''){
		alert( `\${result} 번 삭제완료.`);
	}
	}	
}

</script>
</body>
</html>