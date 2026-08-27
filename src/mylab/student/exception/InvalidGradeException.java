package mylab.student.exception;

public class InvalidGradeException extends Exception {
	
	public InvalidGradeException() {
		super("학년은 1~4 사이의 값이어야 합니다.");
	}
	
	public InvalidGradeException(String message) {
		super(message);
	}
	

}
