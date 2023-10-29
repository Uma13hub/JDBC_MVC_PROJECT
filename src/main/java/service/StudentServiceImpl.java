package service;

import dao.IStudentDao;
import dto.Student;
import factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao=StudentDaoFactory.getStudentDao();
	@Override
	public String save(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student findById(Integer id) {
		return studentDao.findById(id);
	}

	@Override
	public String updateById(Student student) {
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer id) {
		return studentDao.deleteById(id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
