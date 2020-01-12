<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Student</h1>  
       <form:form method="POST" action="/demo1/editSave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="stdId" /></td>  
         </tr>   
         <tr>    
          <td>Student Name : </td>   
          <td><form:input path="stdName"  /></td>  
         </tr>    
         <tr>    
          <td>Age :</td>    
          <td><form:input path="age" /></td>  
         </tr>   
         <tr>    
          <td>Gender :</td>    
          <td><form:input path="gender" /></td>  
         </tr> 
         <tr>    
          <td>Birth Day :</td>    
          <td><form:input path="dob" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
