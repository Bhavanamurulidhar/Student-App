<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		background-image: url("images/background.jpg");
		background-position: cover;
	}
</style>
</head>
<body>
	<%Random r=new Random(); %>
	<h1><%=r.nextLong() %></h1>
	
	<% Date d=new Date(); %>
	<h2><%=d %></h2>
</body>
</html>