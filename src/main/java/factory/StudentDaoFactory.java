package factory;

import dao.StudentDaoImpl;
import dao.IStudentDao;

public class StudentDaoFactory {
	private static IStudentDao studentDao =null;
	private StudentDaoFactory() {
		
	}
	 public static IStudentDao getStudentDao() {
		 if(studentDao == null)
			 return studentDao=new StudentDaoImpl();
	return studentDao;
		 
	 }

}
