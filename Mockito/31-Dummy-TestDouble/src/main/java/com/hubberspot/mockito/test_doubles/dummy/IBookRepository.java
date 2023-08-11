package com.hubberspot.mockito.test_doubles.dummy;

import java.util.Collection;

public interface IBookRepository {
	void save(Book book);
	Collection<Book> findAll();
}
