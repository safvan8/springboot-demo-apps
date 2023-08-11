package com.hubberspot.mockito.test_doubles.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class DummyTest {

	@Test
	void demoDummy() {
		// Creating a FakeBookRepository and DummyEmailService as dummy test doubles
		IBookRepository iBookRepository = new FakeBookRepository(); // Creating a fake book repository as a dummy
		IEmailService emailService = new DummyEmailService(); // Creating a dummy email service
		BookService bookService = new BookService(iBookRepository, emailService);

		// Adding books using the BookService
		bookService.addBook(new Book("1234", "Mockito In Action", 250, LocalDate.now()));
		bookService.addBook(new Book("1235", "JUnit 5 In Action", 200, LocalDate.now()));

		// Verifying the number of books using assertions
		assertEquals(2, bookService.findNumberOfBooks());
	}

	@Test
	void demoDummyWithMockito() {
		// Creating mock objects using Mockito as dummy test doubles
		IBookRepository bookRepository = mock(IBookRepository.class);
		IEmailService emailService = mock(IEmailService.class); // Creating a Dummy test double email service
		BookService bookService = new BookService(bookRepository, emailService);

		// Creating sample books
		Book book1 = new Book("1234", "Mockito In Action", 250, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 200, LocalDate.now());

		// Creating a collection of books and defining behavior for the mock repository
		Collection<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		when(bookRepository.findAll()).thenReturn(books); // Stubbing the findAll() method

		// Verifying the number of books using assertions
		assertEquals(2, bookService.findNumberOfBooks());
	}
}
