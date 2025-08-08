<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="in.pentagon.studentapp.dto.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Update.css">
</head>
<body>
<%if(session.getAttribute("student")!=null){%>
<%Student s= (Student)session.getAttribute("student"); %>
<div class="container">
	     <h1>Update Account</h1>
	     
	     <form action="Update" class="form-container" target="_blank" method="post">
	     	<label for="name">Enter your Name</label>
	     	<input type="text" name="name" id="name" value="<%=s.getName()%>">
	     	<label for="phone">Enter the phone number</label>
 			<input type="tel" name="phone" id="phone" value="<%=s.getPhone()%>">
 			<label for="email">Enter the Mail ID</label>
 			<input type="email" name="email" id="email" value="<%=s.getMail()%>">
 			<label for="branch">Enter the branch</label>
 			<input type="text" name="branch" id="branch" value="<%=s.getBranch()%>">
 			<label for="location">Enter the Location</label>
 			<input type="text" name="location" id="location" value="<%=s.getLoc()%>">
	     	<div class="button">
	     	<input type="submit" value="Update account" class="Update-btn">
	     	<input type="submit" value="Back" onclick="window.location.href='Dashboard.jsp';">
	     	
	     	</div>
	   
	     </form>
	</div>
	<%}else{
		request.setAttribute("error", "Failed to Update");
		RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>