package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import controller.IStudentController;
import dto.Student;
import factory.StudentControllerFactory;

public class TestApp {
public  static void main(String[] args) throws SQLException, IOException {
	IStudentController studentController=null;
	Integer id=null;
	String name=null;
	Integer age=null;
	String address=null;
	Student student=null;
	String status=null;
	Integer option=null;
		try {
			do {
				System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.Exit\nEnter your option :: [1,2,3,4,5]\n");
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				option=Integer.parseInt(br.readLine());
				studentController=StudentControllerFactory.getStudentController();
				switch(option) {
					case 1:
							System.out.println("Enter id :: ");
							id=Integer.parseInt(br.readLine());
							System.out.println("Enter name :: ");
							name=br.readLine();
							System.out.println("Enter age :: ");
							age=Integer.parseInt(br.readLine());
							System.out.println("Enter Address :: ");
							address=br.readLine();
							student=new Student();
							student.setSid(id);
							student.setSname(name);
							student.setSage(age);
							student.setSaddress(address);
							status=studentController.save(student);
							if(status.equalsIgnoreCase("success"))
							{
								System.out.println("Successfully Created***********************************");
							}
							else if(status.equalsIgnoreCase("failure"))
							{
								System.out.println("Failed to Create***********************************");
							}
							else {
								System.out.println("Something problem***********************************");
							}
							break;
					case 2:
							studentController=StudentControllerFactory.getStudentController();
							System.out.println("Enter Id number :: ");
							id=Integer.parseInt(br.readLine());
							student=studentController.findById(id);
							if(student!=null)
								System.out.println("Record Find :: "+student);
							else
								System.out.println("Record not found for id :: "+id);
							break;
					case 3:
							Integer opt=null;
							studentController=StudentControllerFactory.getStudentController();
							System.out.println("Enter Id number :: ");
							id=Integer.parseInt(br.readLine());
							student=studentController.findById(id);
							if(student!=null) {
								System.out.print("Student Details  ::  ");
								System.out.println(student);
								do {
								System.out.println("1.Update ID\n2.Update NAME\n3.Update AGE\n4.Update ADDRESS \n5.Exit\nEnter your option :: [1,2,3,4,5]");
								opt=Integer.parseInt(br.readLine());
								switch(opt) {
								case 1:
										System.out.print("EnterID :: ");
										id=Integer.parseInt(br.readLine());
										student.setSid(id);
									
										break;
								case 2:
										System.out.println("Enter name :: ");
										name=br.readLine();
										student.setSname(name);
										break;
								case 3:
										System.out.println("Enter  age :: ");
										age=Integer.parseInt(br.readLine());
										student.setSage(age);
										break;
								case 4:
										System.out.println("Enter Address :: ");
										address=br.readLine();
										student.setSaddress(address);
										break;
								default:
									System.out.println("Something Problem");
								}
								status=studentController.updateById(student);
								if(status.equalsIgnoreCase("success"))
								{
									System.out.println("Successfully Updated***********************************");
								}
								else if(status.equalsIgnoreCase("failure"))
								{
									System.out.println("Failed to Updated***********************************");
								}
							}while(opt!=5);
							}
							else 
							{
								System.out.println("Record not found for id :: "+id);
							}
							break;
					case 4:
							studentController=StudentControllerFactory.getStudentController();
							System.out.println("Enter Id number :: ");
							id=Integer.parseInt(br.readLine());
							status=studentController.deleteById(id);
							if(status.equalsIgnoreCase("success"))
							{
								System.out.println("Successfully Deelted***********************************");
							}
							else if(status.equalsIgnoreCase("failure"))
							{	
								System.out.println("Failed to Create***********************************");
							}
							else if(status.equalsIgnoreCase("NA"))
							{
								System.out.println("Record not found for id :: "+id);
							}
							break;
					case 5:
							System.out.println("Thank You For Using Application");
							break;
					default:
							System.out.println("Enter correct option ");
				}
				
			}while(option!=5);
		}catch(Exception e) {
			
		}
	}
	
}
