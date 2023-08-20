package com.hubberspot.mockito.spies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

	@InjectMocks
	private BookManager bookManager;

	@Spy
	private BookService bookService;

	@Test
	public void testMockitoSpy_with_annotation() {

		/*
		 * to create spy manully witout annaoatation BookService spy_bookService =
		 * Mockito.spy(BookService.class);
		 * 
		 */

		// We need to mock findBook because it is communicating to database or not
		// implemented
		// We need to call getAppliedDiscount to calculate the discounted price
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		doReturn(book).when(bookService).findBook("1234"); // -- this will spy object
//		when(bookService.findBook("1234")).thenReturn(book);   --- this will  call real method 
		int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
		assertEquals(450, actualDiscount);
	}

}
