package service;

import dto.Student;

public interface IStudentService {

	String save(Student student); //save record
	Student findById(Integer id); //reading record
	String  updateById(Student student); //Update record
	String deleteById(Integer id); //delete record
}
