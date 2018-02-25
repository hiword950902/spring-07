package Test;

import java.util.List;

import com.neuedu.bean.Student;
import com.neuedu.bean.StudentDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	StudentDao dao=new StudentDao();
//		List<Student> students=dao.getStudents();
//		for (Student student : students) {
//			System.out.println(student);
//		}
		Student student=new Student();
		student.setName("°¢À­Ë¹¼Ó");
		student.setBId(4);
		student.setGerden(1);
		student.setId(6);
//		int result= dao.add(student);
//		int result=dao.update(student);
		int result =dao.del(7);
		System.out.println(result);
	}

}
