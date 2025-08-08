<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentApp-Login</title>
<link rel="stylesheet" href="Login.css">
</head>
<body>
	<div class="container">
	     <h1>Login</h1>
	     <%if(request.getAttribute("success")!=null){%>
	     <h4 class="success"><%=request.getAttribute("success") %></h4>
	     <%}%>
	     <%if(request.getAttribute("error")!=null){%>
	     <h4 class="error"><%=request.getAttribute("error") %></h4>
	     <%}%>
	     <form action="login" class="form-container" target="_blank" method="post">
	     	<label for="mail">Enter your Mail ID</label>
	     	<input type="email" name="email" id="mail">
	     	<label for="password">Enter the Password</label>
	     	<input type="password" name="password" id="password">
	     	<div class="button">
	     		<input type="submit" value="Login" class="login-btn">
	     		<a href="ResetPassword.html">Forgot Password?</a>
	     	</div>
	     	<p>Don't have a account?&nbsp;<a href="Signup.jsp">Signup</a> </p>
	     	
	     </form>
	</div>
</body>
</html>