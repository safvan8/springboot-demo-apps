package com.hubberspot.mockito.annotations.support;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnnotationsTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	// Initializing mock objects before each test method using @Before
	@Before
	public void beforeEachTest() {
		// Initializes mock objects and injects them into the @InjectMocks fields
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void demoCreateMocksUsingAnnotations() {
		// Creating sample Book objects
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		// Creating a list of new books
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);

		// Setting up mock behavior using when
		when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

		// Calling the method to be tested
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		// Asserting the results
		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
}
