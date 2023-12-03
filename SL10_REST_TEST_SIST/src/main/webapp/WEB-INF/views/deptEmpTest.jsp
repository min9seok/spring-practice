<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
</head>
<body>
<div>
<select id="selDept" name="deptno"> 
   <c:forEach items="${ deptList }"  var="dto">
       <option value= "${ dto.deptno }">${ dto.dname }</option>
   </c:forEach>
</select>
<br>
<br>
<table>
  <thead>
    <tr>
     <th><input type="checkbox" id="ckbAll" name="ckbAll"></th>
     <th>empno</th>
     <th>ename</th>
     <th>job</th>
     <th>hiredate</th>
     <th>mgr</th>
     <th>sal</th>
     <th>comm</th>
     <th>deptno</th>
    </tr>
  </thead>
  <tbody>
  
  <c:choose>
     <c:when test="${  not empty empList }">
        <c:forEach items="${ empList }" var="dto">        
	        <tr>
	           <td><input type="checkbox" name="ckbEmp" data-empno="${ dto.empno }"></td>
	           <td>${ dto.empno }</td>
	           <td>${ dto.ename }</td>
	           <td>${ dto.job }</td>
	           <td>${ dto.hiredate }</td>
	           <td>${ dto.mgr }</td>
	           <td>${ dto.sal }</td>
	           <td>${ dto.comm }</td>
	           <td>${ dto.deptno }</td>
	        </tr>        
        </c:forEach>
     </c:when>     
     <c:otherwise>
        <tr>
           <td colspan="9"  style="text-align: center">employee does not exist.</td>
        </tr>
     </c:otherwise>
  </c:choose> 
 
  </tbody>
  <tfoot>
    <tr>
       <td colspan="9"  style="text-align: center">
          <button id="checkedEmpno">선택한 empno 확인</button>
       </td>
    </tr>
  </tfoot>
</table>
</div>


<script>
  $("#selDept").change(function (){ 
	  let deptno = $(this).val();
	  
	  // var params = "deptno="+deptno;	 
	  $.ajax({
		  //        /deptEmp/20
		  url:`/deptEmp/\${deptno}`,
		  dataType:"json",
		  type:"GET", 
		  //data:params, 
		  cache:false,
		  success:function (data, textStatus, jqXHR){  
			  
			  console.log( data );
			  
			  $("table tbody").empty();
			  
			  if( data.length == 0 ){
				  let tr = `<tr>                                                                     
					  				<td colspan="9"  style="text-align: center">employee does not exist.</td>                                                
		           				</tr>`;
    $( tr ).appendTo("table tbody"); 
                return ;
			  } 
			  
			  $(  data ).each( function (i, elem){
					 let tr = `<tr>                                                                     
			                       <td><input type='checkbox' name='ckbEmp' data-empno='\${elem.empnp}'></td> 			     
					               <td>\${elem.empno}</td>                                                     
					               <td>\${elem.ename}</td>                                                    
					               <td>\${elem.job}</td>                                                     
					               <td>\${elem.hiredate}</td>                                               
					               <td>\${elem.mgr}</td>                                                   
					               <td>\${elem.sal}</td>                                                  
					               <td>\${elem.comm}</td>                                                    
					               <td>\${elem.deptno}</td>                                                      
					           </tr>`
			     $( tr ).appendTo("table tbody"); 
			  } );
			  
			  
		  }, 
		  error:function (){
			  alert('에러발생~~~');
		  }
	  });
  });
</script>


</body>
</html>


