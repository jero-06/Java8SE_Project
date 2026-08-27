package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvaliable;
	
	// 기본 생성자: 대출 가능 상태  true
	public Book() {
		this.isAvaliable = true;
			
	}
		
	// 초기화 생성자: 대출 가능 상태  true
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvaliable = true;
			
	}
	
	// Getter & Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public boolean isAvailable() {
		return isAvaliable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvaliable = isAvailable;
	}
	
	// 대출 처리 메서드 isAvailable을 false로 변경
	public boolean checkOut() {
		if (this.isAvaliable) {
			this.isAvaliable = false;
			return true;
		}
		return false;
		
	}
	
	// 반납 처리 메서드 isAvailable을 true로 변경
	public void returnBook() {
		this.isAvaliable = true;
		
	}
	
	// 정보 문자열 표현 반환
	@Override
	public String toString() {
		String status = isAvaliable ? "가능" : "대출 중";
		return "책 제목: " + title + "\t저자: " + author + "\tISBN: " + isbn + "\t출판년도: " + publishYear + "\t대출 가능 여부: " + status;
	}

}
