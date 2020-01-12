<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Student List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Student ID/th><th>Student Name</th><th>Age</th><th>Gender</th><th>Birth Day</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="std" items="${list}">   
   <tr>  
   <td>${std.stdId}</td>  
   <td>${std.stdName}</td>  
   <td>${std.age}</td>  
   <td>${std.gender}</td>  
   <td>${std.dob}</td>  
   <td><a href="editStd/${std.stdId}">Edit</a></td>  
   <td><a href="deleteStd/${std.stdId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="stdForm">Add New Employee</a>