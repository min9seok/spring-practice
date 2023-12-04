console.log("reply Module");

var replyService = (function(){

 function add(reply, callback, error){
   console.log("add");
   console.log(reply.bno);
   $.ajax({
   		type: "POST",
   		url: '/replies/new',
   		data: JSON.stringify(reply),
   		contentType: "application/json; charset=utf-8",
   		cache:false,
   		success: function(result,status,xhr){
   			if(callback){
   			 callback(result);
   			}
   		},
   		error: function(xhr,status,er){
   			if(error){
   			 error(er);
   			}
   		}   
   });
 }
 
 function getList(param, callback, error){
 	var bno = param.bno;
 	var page = param.page || 1;
 	$.getJSON("/replies/pages/"+bno+"/"+page+".json",
	 	function(data){
 		 if(callback){
 		  //callback(data); // 댓글목록만 가져오는 경우
 		  callback(data.replyCnt,data.list); // 댓글 숫자와 목록을 가져오는 경우
 		 }
 		}).fail(function(xhr,status,err){
 		 if(errot){
   		  error();
 		 }
 	});
 }
 
 function remove(rno, callback, error){}
 
 function update(reply, callback, error){}
 
 function get(rno, callback, error){}
 
 function displayTime(timeValue){}
 
 return{
   add: add,
   get: get,
   getList: getList,
   remove: remove,
   update: update,
   displayTime: displayTime
 };

})();