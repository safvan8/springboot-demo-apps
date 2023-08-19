package com.hubberspot.mockito.argument_captor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Captor
	private ArgumentCaptor<Book> bookArgumentCaptorAnnotated;

	// Test using ArgumentCaptor without annotation
	@Test
	public void testSaveBook_ArgumentCaptor() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
		bookService.addBook(bookRequest);
		verify(bookRepository).save(argumentCaptor.capture());
		Book book = argumentCaptor.getValue();
		assertEquals("Mockito In Action", book.getTitle());
	}

	// Test using ArgumentCaptor with annotation
	@Test
	public void testSaveBook_ArgumentCaptor_Annotation() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());

		bookService.addBook(bookRequest);
		verify(bookRepository).save(bookArgumentCaptorAnnotated.capture());
		Book book = bookArgumentCaptorAnnotated.getValue();
		assertEquals("Mockito In Action", book.getTitle());
	}
}
