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
@WebServlet("/Resetpassword")
public class ResetPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		StudentDAO sdao=new StudentDAOImpl(); 
		//PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm")))
			{
				s.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(s);
				if(res) {
					req.setAttribute("success", "Password updated successfully");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
					//out.println("<h1>Password updated successfully");
				}
				else {
					//out.println("<h1> Failed to update password</h1>");
					req.setAttribute("error", "Failed to update password");
					RequestDispatcher rd=req.getRequestDispatcher("Resetpassword.jsp");
					rd.forward(req, resp);
				}
				
			}
			else {
				req.setAttribute("error", "password mismatch");
				RequestDispatcher rd=req.getRequestDispatcher("Resetpassword.jsp");
				rd.forward(req, resp);
				//out.println("<h1>Password mismatch</h1>");
			}
		}
		else {
			//out.println("<h1>Student doesn't exit</h1>");
			req.setAttribute("error", "Student not available");
			RequestDispatcher rd=req.getRequestDispatcher("Resetpassword.jsp");
			rd.forward(req, resp);
	}
}
}
