package factory;

import controller.IStudentController;
import controller.StudentControllerImpl;

public class StudentControllerFactory {
	private static IStudentController studentController =null;
	private StudentControllerFactory() {
		
	}
	 public static IStudentController getStudentController() {
		 if(studentController == null)
			 return studentController=new StudentControllerImpl();
	return studentController;
		 
	 }

}
