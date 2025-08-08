package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
	public static void update(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		int choice=0;
		do {
			System.out.println("Enter the fields to be updated");
			System.out.println("1.Update Name");
			System.out.println("2.Update phone");
			System.out.println("3.Update Branch");
			System.out.println("4.update Location");
			System.out.println("5.Go to dashboard");
			choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the new name");
			s.setName(sc.next());
			break;
			case 2:System.out.println("Enter the new Phone number");
			s.setPhone(sc.nextLong());
			break;
			case 3:System.out.println("Enter the branch");
			s.setBranch(sc.next());
			break;
			case 4:System.out.println("Enter the location");
			s.setLoc(sc.next());
			break;
			case 5:System.out.println("Dashboard loading....");
			break;
			default:System.out.println("Invalid choice enter the valid choice");
			}
		boolean res=sdao.updateStudent(s);
		if(res) {
			System.out.println("Account updated successfully");
		}
		else {
			System.out.println("Failed to update");
		}
	}while(choice!=5);

}
}
