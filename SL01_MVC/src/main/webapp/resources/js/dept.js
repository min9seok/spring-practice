/**
 * 
 */
 console.log("Dept Module...");

var deptService = (function(){

  function add(dept, callback, error){
    console.log("add dept...");
    $.ajax({
      type:'post',
      url:'/scott/dept/new',
      data:JSON.stringify(dept),
      cache:false,
      contentType:"application/json; charset=utf-8",
      beforeSend:function(xhr){
          //console.log("add dept... beforeSend");
      },
      success:function(result, status, xhr){ 
        //console.log("add dept... success");
        if(callback){
          callback(result);
        }
      },
      error:function(xhr, status, er){ 
        if(error){
          error(er);
        }
      }
    });
  } // add
  
  //      http://localhost/scott/dept/50  + delete
  
  function remove(deptno, callback, error){
    console.log("remove dept...");
    $.ajax({
      type:'delete',
      url:'/scott/dept/'+ deptno,  
      cache:false,
      success:function(deleteResult, status, xhr){ 
        if(callback){
          callback(deleteResult);
        }
      },
      error:function(xhr, status, er){
        if(error){
          error(er);
        }
      }
    });
  } // remove
  
  return {
     add       : add,
     remove : remove
  };

})();