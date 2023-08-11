package com.hubberspot.mockito.test_doubles.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class FakeTest {

	// This test demonstrates manual implementation of a fake repository.
	@Test
	void testFake() {
		// Creating an instance of the FakeBookRepository.
		BookRepository bookRepository = new FakeBookRepository();

		// Injecting the fake repository into the BookService.
		BookService bookService = new BookService(bookRepository);

		// Adding two books to the service.
		bookService.addBook(new Book("1234", "Mockito In Action", 250, LocalDate.now()));
		bookService.addBook(new Book("1235", "JUnit 5 In Action", 200, LocalDate.now()));

		// Asserting that both books were added.
		assertEquals(2, bookService.findNumberOfBooks());
	}

	// This test demonstrates the use of Mockito to mimic the behavior of the
	// FakeBookRepository.
	@Test
	void testFakeWithMockito() {

		// Creating a mock instance of the BookRepository using Mockito.
		BookRepository fakeBookRepository = mock(BookRepository.class);

		// Injecting the mock repository into the BookService.
		BookService bookService = new BookService(fakeBookRepository);

		// Creating two book instances.
		Book book1 = new Book("1234", "Mockito In Action", 250, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 200, LocalDate.now());

		// Adding both books to a list.
		Collection<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);

		// Mimicking the behavior of the fake repository to return the list of books.
		when(fakeBookRepository.findAll()).thenReturn(books);

		// Asserting that both books were found.
		assertEquals(2, bookService.findNumberOfBooks());
	}
}
