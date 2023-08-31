package javadevjournal.core.user.service;

import javadevjournal.core.exception.UserAlreadyExistException;
import javadevjournal.web.data.user.UserData;

public interface UserService {

	void register(final UserData user) throws UserAlreadyExistException;

	boolean checkIfUserExist(final String email);
}
