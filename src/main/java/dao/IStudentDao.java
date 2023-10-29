package dao;

import dto.Student;

public interface IStudentDao {
	
	String save(Student student); //save record
	Student findById(Integer id); //reading record
	String deleteById(Integer id); //delete record
	String  updateById(Student student); //Update record

}
