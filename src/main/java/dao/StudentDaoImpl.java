package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Student;
import util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	Connection connection=null;
	@Override
	public String save(Student student) {
		String insertQuery="insert into student(`sid`,`sname`,`sage`,`saddress`) values(?,?,?,?)";
		PreparedStatement pstmt=null;
		String status=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			pstmt=connection.prepareStatement(insertQuery);
			if(pstmt!=null) {
				pstmt.setInt(1,	   student.getSid());	
				pstmt.setString(2, student.getSname());
				pstmt.setInt(3,    student.getSage());
				pstmt.setString(4, student.getSaddress());
				
				int rowsAffected=pstmt.executeUpdate();
				if(rowsAffected==1) {
					status="success";
				}
				else {
					status="failure";
				}
			}
			
			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student findById(Integer id) {
		String findQuery="select sid,sname,sage,saddress from student where sid=?";
		PreparedStatement pstmt=null;
		Student student=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			pstmt=connection.prepareStatement(findQuery);
			if(pstmt!=null) {
				pstmt.setInt(1,id);
				ResultSet result=pstmt.executeQuery();
				if(result.next()) {
					//copy the result in Student DTO and transfer
					student=new Student();
					student.setSid(result.getInt(1));
					student.setSname(result.getString(2));
					student.setSage(result.getInt(3));
					student.setSaddress(result.getString(4));
				}
			}			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
		return student ;
	}

	@Override
	public String updateById(Student student) {
		String insertQuery="update student set sid=?,sname=?,sage=?,saddress=? where sid=?";
		PreparedStatement pstmt=null;
		String status=null;
		try {
			connection=JdbcUtil.getJdbcConnection();
			pstmt=connection.prepareStatement(insertQuery);
			if(pstmt!=null) {
				pstmt.setInt(1,	   student.getSid());	
				pstmt.setString(2, student.getSname());
				pstmt.setInt(3,    student.getSage());
				pstmt.setString(4, student.getSaddress());
				pstmt.setInt(5,	   student.getSid());
				
				int rowsAffected=pstmt.executeUpdate();
				if(rowsAffected==1) {
					status="success";
				}
				else {
					status="failure";
				}
			}
			
			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteById(Integer id) {
		String deleteQuery="delete from  student where sid=?";
		PreparedStatement pstmt=null;
		Student student=null;
		String status=null;
		try {
			 student=findById(id);
			if(student!=null) {
			connection=JdbcUtil.getJdbcConnection();
			pstmt=connection.prepareStatement(deleteQuery);
			if(pstmt!=null) {
				pstmt.setInt(1,id);	
				int rowsAffected=pstmt.executeUpdate();
				if(rowsAffected==1) {
					status="success";
				}
				else {
					status="failure";
				}
			}
			}
			else {
				status="NA";
			}
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
