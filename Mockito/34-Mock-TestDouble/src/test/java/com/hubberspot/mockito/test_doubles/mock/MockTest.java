package com.hubberspot.mockito.test_doubles.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockTest {
	
	@Test
	public void demoMock(){
		// Create a mock of BookRepositoryMock
		BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
		
		// Create a BookService using the mock repository
		BookService bookService = new BookService(bookRepositoryMock);
		
		// Create book objects
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		// Add book1 (returns without action) and add book2 (calls save method)
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		// Verify that save method was called once for book2
		bookRepositoryMock.verify(book2, 1);
	}
	
	@Test
	public void demoMockWithMockito(){
		// Create a mock of IBookRepository using Mockito
		IBookRepository bookRepositoryMock = Mockito.mock(IBookRepository.class);
		
		// Create a BookService using the mock repository
		BookService bookService = new BookService(bookRepositoryMock);
		
		// Create book objects
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		// Add book1 (returns without action) and add book2 (calls save method)
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		// Verify save method called once for book2 and not called for book1
		Mockito.verify(bookRepositoryMock, Mockito.times(1)).save(book2);
		Mockito.verify(bookRepositoryMock, Mockito.times(0)).save(book1);	
	}
}
