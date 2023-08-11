package com.hubberspot.mockito.test_doubles.dummy;

/**
 * This class defines the behavior of the BookService and its interactions with
 * IBookRepository and IEmailService. It's responsible for adding books and
 * finding the number of books in the repository.
 * 
 * 
 * @author safvan
 *
 */
public class BookService {

	private IBookRepository iBookRepository;
	private IEmailService emailService; // This email service is a dummy, not used for testing purposes

	public BookService(IBookRepository iBookRepository, IEmailService emailService) {
		this.iBookRepository = iBookRepository;
		this.emailService = emailService;
	}

	public void addBook(Book book) {
		iBookRepository.save(book); // Calling the save method of the book repository
	}

	public int findNumberOfBooks() {
		return iBookRepository.findAll().size(); // Calling the findAll method of the book repository
	}

	// Other methods which use IEmailService
}
