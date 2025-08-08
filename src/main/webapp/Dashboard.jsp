<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        .header {
            background-color: black;
            color:white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size:19px;
        }
        .header .user-info {
            font-size: 15px;
            color: white;
        }
        .main{
        	text-align:center;
        	font-size:20px
        }
        .main-content {
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .data-table, .search-results {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .data-table th, .data-table td,
        .search-results th, .search-results td {
            border: 1px solid #ddd;
            padding: 8px;
        }
         .data-table th, .search-results th {
            background-color: #f2f2f2;
        }
        .btn{
        	margin-top: 20px;
        	padding: 8px 15px;
            background-color: green;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="welcome">
        	
        	<%if(session.getAttribute("student")!=null){ %>
        	<%Student s=(Student)session.getAttribute("student"); %>
        	<h4 class="success">welcome <%=s.getName()%></h4></b>
        	
        </div>
        <div class="user-info">
        	<a>View User</a>
        	<a>ResetPassword</a>
        	<a href="Update.jsp">Update Data </a>
        	<a href="Forgot.html">Logout</a></div>
        </div>
    </div>
    <div class="main">
    	<h2>Dashboard</h2>
    </div>
    <div class="main-content">
        <div class="search-section">
        	<h3>Search User</h3>
            <label>Enter the name of the student here</label>
            <input type="text" id="studentName" placeholder="Search by name">
        </div>
        <div>
        	<input class="btn" type="submit" value="Search">
        </div>
        <table class="search-results">
        	<tr>
            	<th>Id</th>
               	<th>Name</th>
               	<th>Phone</th>
                <th>Branch</th>
                <th>Location</th>
                <th>Mail</th>
            </tr>
        	<tr>
            	<td><%=s.getId() %></td>
            	<td><%=s.getName()%></td>
            	<td><%=s.getPhone() %></td>
            	<td><%=s.getBranch() %></td>
            	<td><%=s.getLoc()%></td>
            	<td><%=s.getMail() %></td>
            </tr>
        </table>
        <h3>View Your Data</h3>
        <table class="data-table">
        	<tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Mail ID</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
        </table>
    </div>
    <%}else{
    request.setAttribute("error", "Failed to login");
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	rd.forward(request, response);
	}%>
       
    
</body>
</html>