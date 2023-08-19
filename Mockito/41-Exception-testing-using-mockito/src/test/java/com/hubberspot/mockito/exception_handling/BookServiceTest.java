package com.hubberspot.mockito.exception_handling;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDate;

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

    // 1) Testing exception thrown from Method with return values
    @Test
    public void testTotalPriceOfBooks() throws SQLException {
        // Stubbing: When bookRepository.findAllBooks() is called, simulate a SQLException being thrown
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);

        // Verification: Ensure that a DatabaseReadException is thrown when calling bookService.getTotalPriceOfBooks()
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    // 1.1 ) Testing exception thrown from Method with return values using new operator
    @Test
    public void testTotalPriceOfBooks1() throws SQLException {
        // Stubbing: Simulate a SQLException with a custom message using the new operator
        when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));

        // Verification: Ensure that a DatabaseReadException is thrown with the custom message
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    // 1.2 ) Testing exception thrown from Method with return values using given()
    @Test
    public void testTotalPriceOfBooks3() throws SQLException {
        // BDDMockito given(): Simulate a SQLException being thrown when calling bookRepository.findAllBooks()
        given(bookRepository.findAllBooks()).willThrow(SQLException.class);

        // Verification: Ensure that a DatabaseReadException is thrown
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    // 2) Testing exception thrown from Method with return type void
    @Test
    public void testAddBook() throws SQLException {
        // Create a Book object to be used in the test
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());

        // Stubbing: Simulate a SQLException being thrown when calling bookRepository.save(book)
        doThrow(SQLException.class).when(bookRepository).save(book);

        // Verification: Ensure that a DatabaseWriteException is thrown when calling bookService.addBook(book)
        assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
    }

}
