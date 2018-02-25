package com.neuedu.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	String url="jdbc:mysql://192.168.80.131:3306/db2?useUnicod=true&characterEncoding=utf8";
	String user="root";
	String password="123456";
	
	//��ѯ����
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		        Connection con =null;
				PreparedStatement pstmt=null;
						ResultSet rs =null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			 con=DriverManager.getConnection(url, user, password);
			//���������
			 pstmt=con.prepareStatement("select id,name,b_id,gerden from student");
			//ִ��sql���
			 rs=pstmt.executeQuery();
			while(rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setBId(rs.getInt("b_id"));
				student.setGerden(rs.getInt("gerden"));
				students.add(student);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				   rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}

	//���
	public int add(Student student) {
		int result=0;
		 Connection con =null;
			PreparedStatement pstmt=null;
	try {
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		 con=DriverManager.getConnection(url, user, password);
		//���������
		 pstmt=con.prepareStatement("insert into student (name,b_id,gerden) values(?,?,?)");
		 //ע�����
		 pstmt.setString(1, student.getName());
		 pstmt.setInt(2, student.getBId());
		 pstmt.setInt(3, student.getGerden());
		 //ִ�����
		 result=pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return result;
	}
	

	//�޸�
	public int update(Student student) {

		int result=0;
		 Connection con =null;
			PreparedStatement pstmt=null;
	try {
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		 con=DriverManager.getConnection(url, user, password);
		//���������
		 pstmt=con.prepareStatement("update student set name=?,b_id=?,gerden=? where id=?");
		 //ע�����
		 pstmt.setString(1, student.getName());
		 pstmt.setInt(2, student.getBId());
		 pstmt.setInt(3, student.getGerden());
		 pstmt.setInt(4, student.getId());
		 //ִ�����
		 result=pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return result;
	
		
	}

	//ɾ��
	public int del(int id) {
		int result=0;
		Connection con =null;
		PreparedStatement pstmt=null;
	try {
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		 con=DriverManager.getConnection(url, user, password);
		//���������
		 pstmt=con.prepareStatement("delete from student where id=?");
		 //ע�����
		 pstmt.setInt(1, id);
		 //ִ�����
		 result=pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		return id;
		
	}


}
