package com.hubberspot.mockito.bdd.stubbing;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StubTest {
	
	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;
	
	// Traditional Mockito-style stubbing example
	@Test
	public void test_StubbingInTraditionalMockitoStyle(){
		// Arrange - Given
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);
		
		// Stubbing the behavior of the mock
		when(bookRepository.findNewBooks(7)).thenReturn(newBooks);
		
		// Act - When
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
		
		// Assert - Then
		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
	
	// BDD-style test using Given-When-Then approach
	@Test
	@DisplayName("Given - New books, When - Get new books with applied discount method is called, Then - New books with applied discount is returned")
	public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned() {
		// Arrange - Given
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);
		
		// Stubbing the behavior of the mock using BDDMockito
		given(bookRepository.findNewBooks(7)).willReturn(newBooks);
		
		// Act - When
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
		
		// Assert - Then
		// Using AssertJ BDDAssertions to express assertions
		then(newBooksWithAppliedDiscount).isNotNull();
		then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
		then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
	}
}
