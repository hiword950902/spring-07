package Test;

import java.util.List;

import com.neuedu.bean.Student;
import com.neuedu.bean.StudentDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	StudentDao dao=new StudentDao();
		List<Student> students=dao.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
//		Student student=new Student();
//		student.setName("²ñÈ®");
//		student.setBId(3);
//		student.setGerden(0);
//		student.setId(5);
//    	int result= dao.add(student);
//		int result=dao.update(student);
//		int result =dao.del(7);
//		System.out.println(result);
	}

}
