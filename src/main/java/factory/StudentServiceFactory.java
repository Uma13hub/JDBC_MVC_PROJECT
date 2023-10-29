package factory;

import service.StudentServiceImpl;
import service.IStudentService;

public class StudentServiceFactory {
	private static IStudentService studentService =null;
	private StudentServiceFactory() {
		
	}
	 public static IStudentService getStudentService() {
		 if(studentService == null)
			 return studentService=new StudentServiceImpl();
	return studentService;
		 
	 }

}
