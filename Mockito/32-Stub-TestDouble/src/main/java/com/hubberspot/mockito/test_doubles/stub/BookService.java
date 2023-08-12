package com.hubberspot.mockito.test_doubles.stub;

import java.util.List;

public class BookService {

	private IBookRepository bookRepository;

	// Constructor to initialize with a book repository
	public BookService(IBookRepository iBookRepository) {
		this.bookRepository = iBookRepository;
	}

	// Method to get new books with applied discount
	public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
		// Fetch new books from the book repository based on the given days
		List<Book> newBooks = bookRepository.findNewBooks(days);

		// Apply discount to each new book
		for (Book book : newBooks) {
			int price = book.getPrice();
			int newPrice = price - (discountRate * price / 100);
			book.setPrice(newPrice);
		}
		return newBooks; // Return the list of new books with applied discount
	}
}
