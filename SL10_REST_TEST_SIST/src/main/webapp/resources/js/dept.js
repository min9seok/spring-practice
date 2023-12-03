console.log("Dept Module...");

var deptService = (function(){

   // js 함수 선언 : add()    ajax + 부서 추가
   function add(dept, callback, error){
     console.log("add dept...");
     
     // URL    http://localhost/dept/30       + GET
     // URL    http://localhost/dept/30       + DELETE
     // URL    http://localhost/dept/30       + POST
     
     $.ajax({
			   url:"/scott/dept/new"          // HomeAjaxController.java
			 , method: "POST"                 // get(S),post(U),put(I),delete(D) 등등
			 , data: JSON.stringify(dept)     // js Object -> JSON 변환
			 , contentType:"application/json; charset=utf-8"
			 //, dataType: "json"
			 , cache:false
			 , success: function ( result, status, xhr ){
  	        	   if(callback){
			          callback(result);
			       }
  	          } 
			 , error: function ( xhr, status, er){
  	        	   if(error){
			          error(er);
			       }
  	          } 
  	         //,beforeSend : function(xhr) {
		     //   xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	         //}  
		 });
     
   } // add
   
   // js 함수 선언 : remove() ajax + 부서 삭제
   //  "/scott/dept/50"
   function remove(deptno, callback, error){
     console.log("remove dept... " + deptno);
     $.ajax({
			   url:"/scott/dept/"+deptno          // HomeAjaxController.java
			 , method: "DELETE"                 // get(S),post(U),put(I),delete(D) 등등
			 , cache:false
			 , success: function ( result, status, xhr ){
  	        	   if(callback){
			          callback(result);
			       }
  	          } 
			 , error: function ( xhr, status, er){
  	        	   if(error){
			          error(er);
			       }
  	          } 
  	         //,beforeSend : function(xhr) {
		     //   xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	         //}  
		 });
   } // remove
   
   return {
        add:add
      , remove:remove
   };

})();