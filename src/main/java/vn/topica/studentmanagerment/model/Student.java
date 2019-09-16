package vn.topica.studentmanagerment.model;

public class Student {
	private int id;
	private String name;
	private int yearOfBirth;
	private String gender;
	private String dateAdmission;
	private static int index = 0;
	
	
	
	public Student(String name, int yearOfBirth, String gender, String dateAdmission) {
		this.id = index;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.dateAdmission = dateAdmission;
		index++;
	}

	public Student(int id, String name, int yearOfBirth, String gender, String dateAdmission) {
		this.id = id;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.dateAdmission = dateAdmission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateAdmission() {
		return dateAdmission;
	}

	public void setDateAdmission(String dateAdmission) {
		this.dateAdmission = dateAdmission;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
