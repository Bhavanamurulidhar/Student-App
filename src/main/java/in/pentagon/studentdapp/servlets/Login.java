package in.pentagon.studentdapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet{
		@Override//or doGet below
	 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImpl(); 
		//PrintWriter out=resp.getWriter();
		//creation of session object{new}
		HttpSession session=req.getSession(true);
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		s=sdao.getStudent(email,password);
		
		
		if(s!=null) {
			//out.println("<h1>Login sucessfull welcome "+s.getName()+"</h1>");//+s.getName()+
		
			session.setAttribute("student",s);
			req.setAttribute("success", "Login sucessfull");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Failed to Login </h1>");
			req.setAttribute("error", "Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
