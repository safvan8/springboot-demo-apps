package com.hubberspot.mockito.annotations.support;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This test class uses the @RunWith(MockitoJUnitRunner.class) annotation to run
 * tests. The MockitoJUnitRunner handles mock objects and annotations for easier
 * testing.
 * 
 * However, when working with other frameworks like Spring, conflicts might
 * arise. To ensure compatibility, consider alternative methods for using
 * Mockito annotations. For this example, we're using MockitoJUnitRunner to
 * showcase annotations in testing. Keep in mind that different frameworks might
 * require different approaches.
 * 
 * 
 * @author safvan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnotationsTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Test  // from JUNIT 4 package
	public void demoCreateMocksUsingAnnotations() {
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);

		when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
}
