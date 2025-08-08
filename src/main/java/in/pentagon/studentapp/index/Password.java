package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
	public static void reset(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("Enter the phone number");
		long phone=sc.nextLong();
		System.out.println("Enter the mail id");
		String mail=sc.next();
		
		if(s.getPhone()==phone && s.getMail().equals(mail)) {
			System.out.println("Set a new password");
			String pass=sc.next();
			System.out.println("Confirm password");
			String confirm=sc.next();
			if(pass.equals(confirm)) {
				s.setPassword(pass);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("Password updated successfully");
				}
				else {
					System.out.println("Failed to update password");
				}
			}
			else {
				System.out.println("Pasword mismatch");
			}
		}
		else {
			System.out.println("incorrect password or mail id");
		}
		
	}
	public static void forgot() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("Enter the phone number");
		long phone=sc.nextLong();
		System.out.println("Enter the mail");
		String mail=sc.next();
		Student a=sdao.getStudent(phone, mail);
		if(a.getPhone()==phone && a.getMail().equals(mail)) {
			System.out.println("Set a new password");
			String pass=sc.next();
			System.out.println("Confirm password");
			String confirm=sc.next();
			if(pass.equals(confirm)) {
				a.setPassword(pass);
				boolean res=sdao.updateStudent(a);
				if(res) {
					System.out.println("Password updated successfully");
				}
				else {
					System.out.println("Failed to update password");
				}
			}
			else {
				System.out.println("Pasword mismatch");
			}
		}
		else {
			System.out.println("incorrect password or mail id");
		}
	}
				
}

