package com.hubberspot.mockito.stubbing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Test
	public void testCalculateTotalCostOfBooks() {
		List<String> bookIds = new ArrayList<>();
		bookIds.add("1234");
		bookIds.add("1234");

		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		/**
		 * when(bookRepository.findBookByBookId("1234")).thenReturn(book1,book1); blow
		 * code also does the same
		 */

		// Stubbing behavior for the findBookByBookId method of the mocked repository
		when(bookRepository.findBookByBookId("1234")).thenReturn(book1) // First call returns book1
				.thenReturn(book1); // Second call also returns book1
		/*
		 * // to save one Book
		 * when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
		 * 
		 * Inside doReturn Object Comparison and Overriding equals:
		 * ============================================================
		 * doReturn(book1).when(bookRepository).findBookByBookId("1234");
		 * doReturn(book2).when(bookRepository).findBookByBookId("1235");
		 * 
		 * The comment highlights an important concept. When using methods like doReturn
		 * or thenReturn to stub, object comparison is performed using the equals()
		 * method from the Object class. If the object references are not the same,
		 * there can be issues during stubbing. To prevent these issues, it is advised
		 * to override the equals method inside the Book class. This ensures that the
		 * comparison considers the content of the objects rather than just their
		 * references.
		 * 
		 * 
		 */
		int actualCost = bookService.calculateTotalCost(bookIds);
		assertEquals(1000, actualCost);
	}

	// saving a book . showing the example when return type is void for when()
	@Test
	public void testSaveBook() {
	    // Creating a new Book instance without an ID
	    Book book1 = new Book(null, "Mockito In Action", 500, LocalDate.now());

	    // Stubbings using doNothing() for the save method
	    // Setting up behavior: When the 'save' method of 'bookRepository' is called
	    // with the 'book1' object, nothing should happen (void method behavior).
	    // This is because the method returns void, meaning it doesn't have a return value.
	    doNothing().when(bookRepository).save(book1); // ==

	    // Explanation of the following line:
	    // We are calling the 'addBook' method of 'bookService' and passing the same
	    // 'book1' instance that we created earlier. Since we're passing the exact same
	    // object reference, there's no need to override the 'equals' method in the 'Book' class
	    // for this case. The reference comparison (book1 == book1) will suffice.
	    // This demonstrates that when dealing with the same object reference,
	    // we don't need to worry about custom object comparison.
	    bookService.addBook(book1); // ( checks book1 == book1 ), so reference is same, no need to override equals for this
	}


	// void method
	@Test
	public void testSaveBookWithBookRequest() {
	    // Creating a BookRequest object for testing
	    BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());

	    // Creating a Book object with the same attributes as the BookRequest
	    // This Book object will be used for comparison in the stubbing
	    Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());

	    // Setting up behavior: When the 'save' method of 'bookRepository' is called
	    // with the 'book' object, nothing should happen (void method behavior).
	    // This is stubbing the 'save' method with the specific 'book' argument.
	    doNothing().when(bookRepository).save(book);

	    // Explanation of the following lines:
	    // When 'bookService.addBook(bookRequest)' is called,
	    // 'bookRequest' is converted into a 'Book' object internally.
	    // Since this internal conversion might create a different object reference,
	    // the default 'equals' method will not compare objects based on content.
	    // To ensure that the content-based comparison works as expected in our test,
	    // we've overridden the 'equals' method in the 'Book' class to consider
	    // the content (attributes) of the objects.

	    // Calling the method to be tested
	    bookService.addBook(bookRequest);
	}


	// Testing the 'addBook' method with a book request having a greater price
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice() {
	    // Creating a BookRequest instance with a title, price, and current date
	    BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());

	    // Creating a Book instance with the same title, price, and current date
	    Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());

	    // Explanation of the following line:
	    // We are calling the 'addBook' method of 'bookService' with the 'bookRequest'
	    // instance. Since the price of 'bookRequest' (500) is not greater than 500,
	    // the condition in the 'addBook' method will evaluate to false, and the method will return early.
	    // This showcases how the condition within 'addBook' prevents saving a book when the price is not greater than 500.
	    bookService.addBook(bookRequest);
	}

}
