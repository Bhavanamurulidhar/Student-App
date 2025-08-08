package in.pentagon.studentapp.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//factory class which delivers con ref object
public class Connector {
	public static Connection requestConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
