package com.hubberspot.mockito.behavior.verfication;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hubberspot.mockito.behavior.verification.Book;
import com.hubberspot.mockito.behavior.verification.BookRepository;
import com.hubberspot.mockito.behavior.verification.BookRequest;
import com.hubberspot.mockito.behavior.verification.BookService;

//Use the MockitoExtension to enable Mockito annotations
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	// Inject the BookService with the mocked BookRepository
	@InjectMocks
	private BookService bookService;

	// Create a mock for BookRepository
	@Mock
	private BookRepository bookRepository;

	// Test case: Add a book using Book object
	@Test
	public void testAddBook() {
		// Create a Book object with a price above $500
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());

		// Call the addBook method on the BookService
		bookService.addBook(book);

		// Verify that the save method of the mocked BookRepository is called with the book
		verify(bookRepository).save(book); // Book is saved because its price is above $500
	}

	// Test case: Attempt to save a book with a low price using BookRequest
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice() {
		// Create a BookRequest object with a price <= $500
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());

		// Create a Book object with the same attributes
		Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());

		// Call the addBook method on the BookService with the BookRequest
		bookService.addBook(bookRequest);

		// Verify that the save method of the mocked BookRepository is never called for this book
		verify(bookRepository, times(0)).save(book); // Book is not saved due to low price
	}

	// Test case: Save a book with a proper price using BookRequest
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice1() {
		// Create a BookRequest object with a price above $500
		BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());

		// Create a Book object with the same attributes
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());

		// Call the addBook method on the BookService twice with the same BookRequest
		bookService.addBook(bookRequest);
		bookService.addBook(bookRequest);

		// Verify that the save method of the mocked BookRepository is called twice for this book
		verify(bookRepository, times(2)).save(book); // Book is saved twice with proper price
	}

	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice2() {
		// Create a BookRequest object with a price <= $500
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());

		// Create a Book object with the same attributes
		Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());

		// Call the addBook method on the BookService with the BookRequest
		bookService.addBook(bookRequest);

		// Verify that the save method of the mocked BookRepository is never called for this book
		verify(bookRepository, never()).save(book); // Book is not saved due to low price
	}

	@Test
	public void testUpdatePrice() {
		// Call the updatePrice method with a null bookId and an updated price
		bookService.updatePrice(null, 600);

		// Verify that there are no interactions with the mocked BookRepository
		verifyNoInteractions(bookRepository); // No interactions should have occurred
	}

	@Test
	public void testUpdatePrice2() {
		// Create a Book object with specific attributes
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());

		// Stub the behavior of the mocked BookRepository's findBookById method
		when(bookRepository.findBookById("1234")).thenReturn(book);

		// Call the updatePrice method with a bookId and updated price
		bookService.updatePrice("1234", 500);

		// Verify that the findBookById method and the save method were called for the
		// provided book
		verify(bookRepository).findBookById("1234"); // Verify finding the book
		verify(bookRepository).save(book); // Verify saving the updated book

		// Verify that there are no more interactions with the mocked BookRepository
		verifyNoMoreInteractions(bookRepository); // No more interactions should have occurred
	}

	@Test
	public void testUpdatePrice3() {
		Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());

		when(bookRepository.findBookById("1234")).thenReturn(book);

		// Call the updatePrice method with a bookId and updated price
		bookService.updatePrice("1234", 500);

		// Create an InOrder instance to verify the order of method calls
		InOrder inOrder = Mockito.inOrder(bookRepository);

		// Verify that the findBookById method was called before the save method
		inOrder.verify(bookRepository).findBookById("1234"); // Verify finding the book
		inOrder.verify(bookRepository).save(book); // Verify saving the updated book
	}

	
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice3() {
	    // Create a BookRequest object with a price above $500
	    BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());

	    // Create a Book object with the same attributes
	    Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());

	    // Call the addBook method on the BookService multiple times with the same BookRequest
	    bookService.addBook(bookRequest);
	    bookService.addBook(bookRequest);
	    bookService.addBook(bookRequest);
	    
//		verify(bookRepository, times(2)).save(book);
//		verify(bookRepository, atLeast(4)).save(book);
//		verify(bookRepository, atMost(2)).save(book);
//		verify(bookRepository, atMostOnce()).save(book);

	    
	    // Verify that the save method of the mocked BookRepository is called at least once for this book
	    verify(bookRepository, atLeastOnce()).save(book); // Book is saved at least once
	}
}
