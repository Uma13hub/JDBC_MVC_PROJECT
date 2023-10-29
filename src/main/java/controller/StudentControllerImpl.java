package controller;

import dto.Student;
import factory.StudentControllerFactory;
import factory.StudentServiceFactory;
import service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService studentService=StudentServiceFactory.getStudentService();;
	@Override
	public String save(Student student) {
		return studentService.save(student);
	}

	@Override
	public Student findById(Integer id) {
		return studentService.findById(id);
	}

	@Override
	public String updateById(Student student) {
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer id) {
		return studentService.deleteById(id);
	}

}
