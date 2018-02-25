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
	
	//查询所有
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		        Connection con =null;
				PreparedStatement pstmt=null;
						ResultSet rs =null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			 con=DriverManager.getConnection(url, user, password);
			//创建命令窗口
			 pstmt=con.prepareStatement("select id,name,b_id,gerden from student");
			//执行sql语句
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

	//添加
	public int add(Student student) {
		int result=0;
		 Connection con =null;
			PreparedStatement pstmt=null;
	try {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接
		 con=DriverManager.getConnection(url, user, password);
		//创建命令窗口
		 pstmt=con.prepareStatement("insert into student (name,b_id,gerden) values(?,?,?)");
		 //注入参数
		 pstmt.setString(1, student.getName());
		 pstmt.setInt(2, student.getBId());
		 pstmt.setInt(3, student.getGerden());
		 //执行语句
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
	

	//修改
	public int update(Student student) {

		int result=0;
		 Connection con =null;
			PreparedStatement pstmt=null;
	try {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接
		 con=DriverManager.getConnection(url, user, password);
		//创建命令窗口
		 pstmt=con.prepareStatement("update student set name=?,b_id=?,gerden=? where id=?");
		 //注入参数
		 pstmt.setString(1, student.getName());
		 pstmt.setInt(2, student.getBId());
		 pstmt.setInt(3, student.getGerden());
		 pstmt.setInt(4, student.getId());
		 //执行语句
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

	//删除
	public int del(int id) {
		int result=0;
		Connection con =null;
		PreparedStatement pstmt=null;
	try {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接
		 con=DriverManager.getConnection(url, user, password);
		//创建命令窗口
		 pstmt=con.prepareStatement("delete from student where id=?");
		 //注入参数
		 pstmt.setInt(1, id);
		 //执行语句
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
