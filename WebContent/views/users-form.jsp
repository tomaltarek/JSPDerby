<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Page</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body>
<div class="container">


<form action="${pageContext.request.contextPath}/UsersController" method="POST">
Name <input type="text" name="uname"/><br>
Password <input type="text" name="password"/><br>
<button class = "btn btn-primary" type="submit">Save</button>
</form>

</div>

</body>
</html>