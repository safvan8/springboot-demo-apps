package com.hubberspot.mockito.annotations.support;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class AnnotationsTest {

	// Third way to initialize mock objects using the MockitoRule
	/**
	 * The @Rule 'mockitoRule' must be public.
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

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
