package com.hubberspot.mockito.test_doubles.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StubTest {

	@Test
	public void demoStub() {
		// Creating a stub with hard-coded values for method responses
		IBookRepository bookRepositoryStub = new BookRepositoryStub();

		// Injecting the stub as a dependency
		BookService bookService = new BookService(bookRepositoryStub);

		// Getting new books with applied discount using the stub
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		// Asserting the number of new books
		assertEquals(2, newBooksWithAppliedDiscount.size());

		// Calculating and asserting the prices of two books after discount
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}

	@Test
	public void demoStubWithMockito() {
		// Creating a mock for the book repository interface
		IBookRepository bookRepositoryStub = mock(IBookRepository.class);

		// Creating a book service with the mock repository
		BookService bookService = new BookService(bookRepositoryStub);

		// Creating two sample books
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		// Creating a list of new books
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);

		// Stubbing the repository's method to return the list of new books
		when(bookRepositoryStub.findNewBooks(7)).thenReturn(newBooks);

		// Getting new books with applied discount using the stubbed repository
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		// Asserting the number of new books
		assertEquals(2, newBooksWithAppliedDiscount.size());

		// Calculating and asserting the prices of two books after discount
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
}
