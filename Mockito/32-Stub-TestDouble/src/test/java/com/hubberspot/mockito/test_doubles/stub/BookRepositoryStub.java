package com.hubberspot.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements IBookRepository {

	//Hard coded reponse
	@Override
	public List<Book> findNewBooks(int days) {
		// Creating a list of sample new books
		List<Book> newBooks = new ArrayList<>();
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		// Adding the sample books to the list
		newBooks.add(book1);
		newBooks.add(book2);

		// Returning the list of new books
		return newBooks;
	}
}
