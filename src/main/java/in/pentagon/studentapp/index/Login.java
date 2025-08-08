package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("<----Login Page---->");
		System.out.println("Enter the mail id");
		String mail=sc.next();
		System.out.println("Enter the password");
		String pass=sc.next();
		Student a=sdao.getStudent(mail,pass);
		int choice=0;
		if(a!=null) {
			System.out.println("Login Successful Welcome"+a.getName());
			do {
				System.out.println("1.View data");
				System.out.println("2.Search Users");
				System.out.println("3.Update account");
				System.out.println("4.Reset password");
				System.out.println("5.Back to main menu");
				if(a.getId()==2) {
					System.out.println("6.view all users");
					System.out.println("7.Delete the user");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1:System.out.println(a);
				break;
				case 2://search user logic;
					System.out.println("Enter the name");
					String name=sc.next();
					ArrayList<Student> sL=sdao.getStudent(name);
					for(Student s:sL) {
						System.out.println(s.getId());
						System.out.println(s.getName());
						System.out.println(s.getBranch());
						System.out.println(s.getLoc());
					}
					
					break;
				case 3:Update.update(a);
				break;
				case 4:Password.reset(a);
					break;
				case 5:System.out.println("Going back to main menu");
				break;
				case 6:
					ArrayList<Student> sl=sdao.getStudent();
					for(Student s:sl) {
						System.out.println(s);
					}
				break;
				case 7://delete user logic
					System.out.println("Enter th Id");
					int id=sc.nextInt();
					boolean res=sdao.deleteStudent(id);
					if(res=true) {
						System.out.println("Data deleted successfully");
					}
					else {
						System.out.println("failed to delete the data");
					}
					break;
				default:System.out.println("Invalid choice! try again");
				}
			}while(choice!=5);
		}
		else {
			System.out.println("Failed to login");
		}
		
		
	}
}
