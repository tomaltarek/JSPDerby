<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Management</title>
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class = "container">
<h1>Password Management System</h1>
<p> ${message} </p>
<p>
<button class = "btn btn-primary"  onclick="window.location.href = 'views/users-form.jsp'" >Add User</button>
</p>
<table id="dtable" class = "table table-striped table-bordered" >
  <tr class = "thead-dark">
    <th>User Name </th>
    <th>Password </th>
    <th>Action </th>
  </tr>
  <c:forEach items="${list}" var="usr">
   <tr class="thead-dark"> 
   <td>${usr.name}</td>
   <td>${usr.pass}</td>
    <td>
    <a href="${pageContext.request.contextPath}/UsersController?action=EDIT&id=${usr.name}">Edit</a>
    |
     <a href="${pageContext.request.contextPath}/UsersController?action=DELETES&id=${usr.name}">Delete</a>
    </td>
   </tr>
  
  </c:forEach>

</table>
</div>

 
</body>
</html>