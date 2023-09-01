package javadevjournal.service;

import javadevjournal.data.UserData;
import javadevjournal.exception.UserAlreadyExistException;

public interface UserService {

	void register(final UserData user) throws UserAlreadyExistException;

	boolean checkIfUserExist(final String email);
}
