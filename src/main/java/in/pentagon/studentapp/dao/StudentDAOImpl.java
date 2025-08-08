package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.conection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection con;
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
	}
	
	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="insert into student values(0,?,?,?,?,?,?,sysdate())";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
		return false;
	}
}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="update student set name=?,phone=?,mail=?,branch=?,loc=?,password=?,date=sysdate() where id=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="delete from student where id=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Student s=null;
		String query="select * from student where mail=? and password=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Student s=null;
		String query="Select * from student where phone=? and mail=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2,mail);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public ArrayList<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList=new ArrayList();
		Student s=null;
		String query="Select * from student where name=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				studentList.add(s);
			  }
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return studentList;
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList=new ArrayList();
		Student s=null;
		String query="select * from student";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	

}
