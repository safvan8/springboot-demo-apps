package javadevjournal.core.user.service;

import javadevjournal.core.exception.InvalidTokenException;
import javadevjournal.core.exception.UnkownIdentifierException;
import javadevjournal.core.exception.UserAlreadyExistException;
import javadevjournal.core.user.jpa.data.UserEntity;
import javadevjournal.web.data.user.UserData;

public interface UserService {

	void register(final UserData user) throws UserAlreadyExistException;

	boolean checkIfUserExist(final String email);

	void sendRegistrationConfirmationEmail(final UserEntity user);

	boolean verifyUser(final String token) throws InvalidTokenException;
	
	public UserEntity getUserById(String id) throws UnkownIdentifierException;
}
