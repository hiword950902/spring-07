package com.neuedu.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.util.JdbcUtil;

public class StudentDao {
	
	//查询所有
	
	public List<Student> getStudents(){
		return JdbcUtil.executeQuery("select id,name,b_id,gerden from student", new RowMap<Student>() {

			@Override
			public Student rowMapping(ResultSet rs) {
				// TODO Auto-generated method stub
				Student student=new Student();
				try {
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setBId(rs.getInt("b_id"));
					student.setGerden(rs.getInt("gerden"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return student;
			}
		}, null);
	}

	//添加
	public int add(Student student) {
		return JdbcUtil.executeUpdate("insert into student(name,b_id,gerden) values(?,?,?)",student.getName(),student.getBId(),student.getGerden());
	}
	

	//修改
	public int update(Student student) {
		return JdbcUtil.executeUpdate("update student set name=?,b_id=?,gerden=? where id=?",student.getName(),student.getBId(),student.getGerden(),student.getId());
	}

	//删除
	public int del(int id) {
		return JdbcUtil.executeUpdate("delete from student where id=?",id);
	}


}
