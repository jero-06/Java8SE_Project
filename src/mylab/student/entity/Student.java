package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	// 기본 생성자
	public Student() {
		
	}
	
	// 필드 초기화 생성자
	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		setGrade(grade);
	}
	
	// Getter & Setter
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	
	// 학년 검증: 1~4 범위 벗어날 경우, InvalidGradeException 예외 발생
	public void setGrade(int grade) throws InvalidGradeException {
		if (grade < 1 || grade > 4 ) {
			throw new InvalidGradeException();
		}
		this.grade = grade;
	}
	
	// 출력용 메서드
	public void print() {
		System.out.println(name + "/" + major + "/" + grade + "학년");
	}

}
