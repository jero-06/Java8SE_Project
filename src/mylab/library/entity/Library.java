package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	// 초기화 생성자:
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
		
	}
	
	public String getName() {
		return name;
	}
	
	// 도서 추가
	public void addBook(Book book) {
		book.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle()); 
		
	}
	
	// 제목 검색
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equls(title)) {
				reture book;
			}
		}
		return null;
		
	}
	
	// 저자 검색
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equls(author)) {
				reture add(book);
			}
		}
		return result;
		
	}
	
	// ISBN 검색
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equls(isbn)) {
				reture book;
			}
		}
		return null;
		
	}
	
	// ISBN 도서 대출
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book ! = null && book.isAvailable()) {
			return book.checkOut();
		}
		return false;
		
	}
	
	// ISBN 도서 대출
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book ! = null && book.isAvailable()) {
			book.returnBook();
			return true;
		}
		return false;
		
	}
	
	// 대출 가능 도서 목록
	public List<Book> getAvailableBooks() {
		List<Book> availableBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.isAvailable()) {
				availableBooks.add(book);
			}	
		}
		return availableBooks;		
	}
	
	// 전체 도서 목록 반환
	public List<Book> getAllBooks() {
		return books;
	}
	
	// 모든 도서 수
	public int getTotalBooks() {
		return books.size();
	}
	
	// 대출 가능 도서 수
	public int getAvailableBooksCount() {
		int count = 0;
		for (Book book : books) {
			if (book.isAvailable()) {
				count++;
			}
		}
		return count;
		
	}
	
	// 대출 중 도서 수
	public int getBorroweBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}

	
	
}
