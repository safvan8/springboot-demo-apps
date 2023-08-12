package com.hubberspot.mockito.test_doubles.mock;

public class BookService {

	private IBookRepository bookRepository;

	public BookService(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		if (book.getPrice() > 400) {
			return;
		}
		bookRepository.save(book);
	}
}
