package vn.topica.studentmanagerment.service;

import java.util.HashMap;
import java.util.Map;

import vn.topica.studentmanagerment.constant.Constant;
import vn.topica.studentmanagerment.model.Student;

public class StudentService {
	
	public static Map<Integer, Student> studentMap = initStudentMap();

	public void add(Student student) {

		studentMap.put(student.getId(), student);
	}

	public void deleteStudent(int id) {
		studentMap.remove(id);
	}

	public void updateStudent(Student student) {
		
		if(studentMap.containsKey(student.getId())) {
			studentMap.put(student.getId(), student);
		}
	}

	public Map<Integer, Student> searchByName (String name){
		Map<Integer, Student> resultMap = new HashMap<Integer, Student>();
		
		for (Student student : studentMap.values()) {
			if(student.getName().toLowerCase().contains(name.toLowerCase())) {
				resultMap.put(student.getId(), student);
			}
		}
		
		return resultMap;
		
	}
	
	public static Map<Integer, Student> initStudentMap() {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		Student student1 = new Student("Nguyễn Bá Khánh", 1997, Constant.GENDER_MALE, "15-10-2015");
		Student student2 = new Student("Nguyễn Văn A", 1997, Constant.GENDER_MALE, "15-10-2015");
		Student student3 = new Student("Đỗ Hùng Dũng", 1997, Constant.GENDER_MALE, "15-10-2015");
		Student student4 = new Student("Nguyễn Quang Hải", 1997, Constant.GENDER_MALE, "26-01-2015");
		
		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);
		map.put(student4.getId(), student4);
		
		return map;
	}

}
