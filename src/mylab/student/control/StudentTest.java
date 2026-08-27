package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		try {
			// 학생 객체 생성 및 초기 정보 출력 
			Student student1 = new Student("20260001", "김민수", "컴퓨터공학", 3);
			student1.print();
					
			System.out.println("5학년으로 변경 ");
			student1.setGrade(5);
		} catch (InvalidGradeException e) {
			// 예외 발생 시 메시지 출력
			System.out.println(e.getMessage());
		}
	}

}
