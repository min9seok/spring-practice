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
<script src="/resources/js/reply.js"></script>
<style>
 span.material-symbols-outlined{
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
     background-color: rgb(0,0,0); /* Fallback color */
     background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
   }
   
   /* Modal Content */
   .modal-content {
     position: relative;
     background-color: #fefefe;
     margin: auto;
     padding: 0;
     border: 1px solid #888;
     width: 55%;
     box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
     -webkit-animation-name: animatetop;
     -webkit-animation-duration: 0.4s;
     animation-name: animatetop;
     animation-duration: 0.4s
   }
   
   /* Add Animation */
   @-webkit-keyframes animatetop {
     from {top:-300px; opacity:0} 
     to {top:0; opacity:1}
   }
   
   @keyframes animatetop {
     from {top:-300px; opacity:0}
     to {top:0; opacity:1}
   }
   
   /* The Close Button */
   .close {
     color: white;
     float: right;
     font-size: 28px;
     font-weight: bold;
   }
   
   .close:hover,
   .close:focus {
     color: #000;
     text-decoration: none;
     cursor: pointer;
   }
   
   .modal-header {
     padding: 2px 16px;
     background-color: white;
     color: black;
   }
   
   .modal-body {padding: 2px 16px;}
   
   .modal-footer {
     padding: 2px 16px;
     background-color: gray;
     color: white;
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
    게시글 상세보기
  </xmp>
     <form action="/board/register" method="post">
     <table>  
       <tbody>
         <tr>
           <th>글번호</th>
           <td><input type="text" name="bno" class="full"  readonly="readonly"  value="${ board.bno }"></td>        
         </tr> 
         <tr>
           <th>제목</th>
           <td><input type="text" name="title" class="full"  readonly="readonly"  value="${ board.title }"></td>        
         </tr> 
         <tr>
           <th>내용</th>
           <td><textarea  name="content" class="full" readonly="readonly"><c:out value="${ board.content }"></c:out></textarea></td>        
         </tr> 
         <tr>
           <th>작성자</th>
           <td><input type="text" name="writer" class="short" readonly="readonly" value="${ board.writer }"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="button"  data-oper="modify" class="edit">Modify</button>
             <button type="button"  data-oper="remove" class="delete">Delete</button>
             <button type="button" data-oper="list"  class="list"> List</button>
           </td>
         </tr>
       </tfoot>
     </table>
<%--      	<input type="hidden" name="pageNum" value="${param.pageNum }" />  --%>
<%-- 		<input type="hidden" name="amount" value="${param.amount }" /> --%>
  </form>  		
  
<form id="operForm" action="/board/modify" method="get">
  <input type="hidden" id="bno" name="bno" value="<c:out value='${ board.bno }' />">
  <input type="hidden" id="pageNum" name="pageNum" value="<c:out value='${ criteria.pageNum }' />">
  <input type="hidden" id="amount" name="amount" value="<c:out value='${ criteria.amount }' />">
  <input type='hidden' id="type" name='type' value='<c:out value="${criteria.type}"/>'>  
  <input type='hidden' id="keyword" name='keyword' value='<c:out value="${criteria.keyword}"/>'>
</form>		
</div>
<!-- REPLY -->
<div class="seperate">
    <div>
        <h3>
          <span class="material-symbols-outlined">quickreply</span> Reply
           <span id="replyCnt" class="badge left red">${ pageMaker.total }</span>
        </h3>
    </div>
    <div><button id='addReplyBtn' class=''>New Reply</button></div>
  </div> 
<div>
  <ul class="chat">
  </ul>
</div>
<div class="panel-footer"></div>

<!-- REPLY Modal -->
  <!-- The Modal -->
<div id="add-modal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header"> 
      <h2>REPLY MODAL</h2>
    </div>
    <div class="modal-body">
      <div class="group">
        <label>Reply</label>
        <input type="text" class="short"  name='reply' value='New Reply!!!!'>
       </div>
       <div class="group">
           <label>Replyer</label>
           <input type="text" class="short" name='replyer' value='replyer'>
       </div>
       <div class="group">
           <label>Reply Date</label>
           <input type="text" class="long" name='replyDate' value='2023-06-27 13:13'>
       </div>
       <div>
           <button id='modalModBtn' type="button">Modify</button>
           <button id='modalRemoveBtn' type="button">Remove</button>
           <button id='modalRegisterBtn' type="button">Register</button>
           <button type="button" id ="modalCloseBtn" class="cancel">Close</button>
       </div>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div> 
</div>


<script type="text/javascript">
$(function(){
	var form = $("form");
	var operForm = $("#operForm");
	$("tfoot button").click(function(event){
		var operation = $(this).data("oper");
		if(operation === 'modify'){
			operForm.attr({
				 "action": "/board/modify"
				,"method": "GET"
			}).submit();
		}else if(operation === 'remove'){
			if(confirm("정말 삭제하슈?")){
				form.attr({
					 "action": "/board/remove"
					,"method": "GET"
				}).submit();
			}
		}else if(operation === 'list'){
			form.find("#bno").remove().end()
			.attr("action","/board/list").submit();
		}
// 		else if(operation === 'list'){
// 			form.attr({
// 				 "action": "/board/list"
// 				,"method": "GET"
// 			}).submit();			
// 		}
	});
});
</script>
<script type="text/javascript">
console.log("=============================");
console.log("REPLY TEST");

 var bnoValue = '<c:out value="${board.bno}"/>';
 
// 	 replyService.getList({bno:bnoValue,page:1},function(replyCnt,list){
// 	 console.log("replyCnt :" + replyCnt);
// 	 for(var i=0;i<list.length;i++){
// 		 console.log(list[i]);
// 	 }
//  });
 var replyUL = $(".chat");
 showList(1);
 function showList(page){
// 	 console.log("list" + page);
	 replyService.getList({bno:bnoValue,page:page||1},function(replyCnt,list){
// 		console.log("replyCnt" + replyCnt);
		$("#replyCnt").text(replyCnt);
		
// 		console.log("list : " + list);
		if(page == -1){
			pageNum = Math.ceil(replyCnt/5.0);
			showList(pageNum);
			return;
		}
		var content = "";
		if(list == null || list.length == 0){
			content += "<li>no reply</li>";
		}else{
// 			<small class='right'>\${list[i].replyDate}</small>			
			for (var i=0; i< list.length; i++){
				content += 
				`<li class='' data-rno='\${list[i].rno}'>
				<div>
				 <div class='seperate'>
				  <strong class='left'>[\${list[i].rno}] \${list[i].replyer}</strong>				  
				  <small class='right'>\${replyService.displayTime(list[i].replyDate)}</small>
				 </div>
				  <p>\${list[i].reply}</p>
				</div> 
				</li>`;	
			}	
		}
		
		replyUL.html(content);
		showReplyPage(replyCnt);
	 });
 }
 var pageNum = 1;
 var replyPageFooter = $(".panel-footer");
 function showReplyPage(replyCnt){
     
     var endNum = Math.ceil(pageNum / 5.0) * 5;  
     var startNum = endNum - 4;   
     var prev = startNum != 1;
     var next = false;
     
     if(endNum * 5 >= replyCnt){
       endNum = Math.ceil(replyCnt/5.0);
     }
     
     if(endNum * 5 < replyCnt){
       next = true;
     }
              
     var str = "<div class='center'>";
     str += "<div class='pagination'>";
     
     if(prev){ 
       str+= `<a href="\${ startNum -1 }">&laquo;</a>`;
     }
     
     for(var i = startNum ; i <= endNum; i++){           
       var active = pageNum == i? "active":"";
       str +=`<a href="\${ i }" class='\${active}'>\${ i }</a>`; 
     }
     
     if(next){
        str+= `<a href="\${ endNum -1 }">&laquo;</a>`; 
     }
     
     str += `</div>
       </div>`;
     
//      console.log(str);     
     replyPageFooter.html(str);
   }
 
 // 댓글의 다른 페이지를 클릭
 replyPageFooter.on("click",".pagination a",function(e){
	 e.preventDefault();	 
	 var targetPageNum = $(this).attr("href");
	 pageNum = targetPageNum;
	 showList(pageNum);
 });
</script>
<script type="text/javascript">
 var addModal = $("#add-modal");
 var modalModBtn = $("#modalModBtn");
 var modalRemoveBtn = $("#modalRemoveBtn");
 var modalRegisterBtn = $("#modalRegisterBtn");
 
 var modal = $(".modal");
 
 var modalInputReply = modal.find("input[name='reply']");
 var modalInputReplyer = modal.find("input[name='replyer']");
 var modalInputReplyDate = modal.find("input[name='replyDate']");
 
 $("#addReplyBtn").click(function(){	 
	modal.find("button").show();
	addModal.find("input").val("");
	addModal.css("display","block"); 
 });
 $(".cancel").click(function(){
	addModal.css("display","none"); 
 });
 $("body").click(function(e){
	if(e.currentTarget== addModal){
		addModal.css("display","none");
	}
 });
 // 댓글 등록
 modalRegisterBtn.click(function(e){
	var reply = {
		reply: modalInputReply.val(),
		replyer: modalInputReplyer.val(),
		bno:bnoValue	
	};
// 	alert(`\$(reply.reply) / \${reply.bno}`);
	replyService.add(reply,function(result){
		alert(result);
		addModal.find("input").val("");
		addModal.hide();
		// 댓글 목록 출력 (ajax처리)
		showList(-1);
	});
 });
 
 // 댓글 조회
//  $(".chat").click(function(){
	$(".chat").on("click","li",function(){
	 var rno = $(this).data("rno");
	 replyService.get(rno,function(reply){
		 modalInputReply.val(reply.reply);
		 modalInputReplyer.val(reply.replyer).attr("readonly","readonly");
		 modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
		 modal.data("rno",reply.rno);
		 
		 modal.find("button[id!='modalCloseBtn']").hide();
		 modalModBtn.show();
		 modalRemoveBtn.show();
// 		$(".modal").modal("show");
		 addModal.css("display","block"); 
	 });
 });
 // 댓글 수정
 modalModBtn.click(function(e){
	 var rno = modal.data("rno");
	 var reply = {
				reply: modalInputReply.val(),				
				rno:rno
			};
	replyService.update(reply,function(result){
		alert(result);	
		addModal.css("display","none");
		showList(1);
	});
 });
 // 댓글 삭제
 modalRemoveBtn.click(function(e){
	var rno = modal.data("rno");
	replyService.remove(rno,function(result){
		alert(result);	
		addModal.css("display","none");
		showList(1);
	});
	
 });
</script>
</body>
</html>