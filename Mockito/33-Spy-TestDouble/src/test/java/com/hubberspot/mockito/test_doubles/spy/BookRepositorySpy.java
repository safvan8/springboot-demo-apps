package com.hubberspot.mockito.test_doubles.spy;

// For manual Spy creation, without mockito
public class BookRepositorySpy implements IBookRepository {

	// Variables to track the interactions with the repository.
	int saveCalled = 0;
	Book lastAddedBook = null;

	// Implementation of the save method that tracks the interaction.
	@Override
	public void save(Book book) {
		saveCalled++; // Increment the counter for each save call.
		lastAddedBook = book; // Record the book added in the last save call.
	}

	// Method to return the number of times the save method was called.
	public int timesCalled() {
		return saveCalled;
	}

	// Method to check if the save method was called with a specific book.
	public boolean calledWith(Book book) {
		return lastAddedBook.equals(book);
	}
}
