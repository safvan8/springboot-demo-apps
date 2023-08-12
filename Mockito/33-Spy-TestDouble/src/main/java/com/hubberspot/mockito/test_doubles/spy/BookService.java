package com.hubberspot.mockito.test_doubles.spy;

public class BookService {

	private IBookRepository bookRepository;

	public BookService(IBookRepository iBookRepository) {
		this.bookRepository = iBookRepository;
	}

	// The addBook method adds a book to the repository, but only if its price is not higher than 400.
	public void addBook(Book book) {
		if (book.getPrice() > 400) {
			return; // If the book price is too high, don't add it.
		}
		bookRepository.save(book); // Otherwise, save the book to the repository.
	}
}
