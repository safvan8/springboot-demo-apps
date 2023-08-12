package com.hubberspot.mockito.test_doubles.stub;

import java.util.List;

public interface IBookRepository {
	List<Book> findNewBooks(int days);
}
