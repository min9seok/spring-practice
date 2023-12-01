console.log("Dept Module");

var deptService = (function(){
	
	// add() ajax 부서 추가
 function add(dept,callback,error){
   console.log("add");
   $.ajax({
		url: "/scott/dept/new"  // HomeAjaxController.java
	  , method: "POST"
	  , data: JSON.stringify(dept)         // js Object
	  , contentType: "application/json; charset=utf-8"
	  //, dataType: "json"
	  , cache:false
	  , success: function(result,status,xhr){
			if(callback){
		   	  callback(result);
			}  		  
	  }
	  , error: function(xhr, errorType){
		  	if(error){
			  error(er);
			}
	  }
	});	
 }
	
	
	// remove() ajax 부서 삭제
 function remove(deptno,callback,error){
 console.log("remove" + deptno);
    	$.ajax({
		url: "/scott/dept/"+deptno  // HomeAjaxController.java
	  , method: "DELETE"	          
	  , cache:false
	  , success: function(result,status,xhr){
			if(callback){
		   	  callback(result);
			}  		  
	  }
	  , error: function(xhr, errorType){
		  	if(error){
			  error(er);
			}
	  }
	});	 
 }
 return {
   add: add
 , remove: remove
 };
})();