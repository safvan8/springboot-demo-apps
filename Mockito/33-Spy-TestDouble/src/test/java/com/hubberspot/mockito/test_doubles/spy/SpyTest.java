package com.hubberspot.mockito.test_doubles.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpyTest {

	@Test
	public void demoSpy() {
		// Creating an instance of BookRepositorySpy.
		BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();

		// Creating an instance of BookService with the spy repository.
		BookService bookService = new BookService(bookRepositorySpy);

		// Creating two Book objects.
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 300, LocalDate.now());

		// Adding book1 to the service. Since its price is more than 400, it won't be
		// saved.
		bookService.addBook(book1);
		assertEquals(0, bookRepositorySpy.timesCalled());

		// Adding book2 to the service. Its price is 300, so it will be saved.
		bookService.addBook(book2);
		assertEquals(1, bookRepositorySpy.timesCalled());

		// Uncomment this line to assert that bookRepositorySpy.calledWith(book2) is
		// true.
		// assertTrue(bookRepositorySpy.calledWith(book2));
	}

	@Test
	public void demoSpyWithMockito() {
		// Creating a spy of the IBookRepository interface using Mockito.
		IBookRepository bookRepositorySpy = spy(IBookRepository.class);
		// Creating an instance of BookService with the Mockito spy repository.
		BookService bookService = new BookService(bookRepositorySpy);

		// Creating two Book objects.
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 300, LocalDate.now());

		// Adding book1 to the service. It won't be saved as this is a spy.
		bookService.addBook(book1); // return
		
		// Adding book2 to the service. save method will be called as this is a spy.
		bookService.addBook(book2); // save will be called

		// Verifying that the save method was called once with book2.
		verify(bookRepositorySpy, Mockito.times(1)).save(book2);
		
		// Verifying that the save method was not called with book1.
		verify(bookRepositorySpy, Mockito.times(0)).save(book1);
	}
}
