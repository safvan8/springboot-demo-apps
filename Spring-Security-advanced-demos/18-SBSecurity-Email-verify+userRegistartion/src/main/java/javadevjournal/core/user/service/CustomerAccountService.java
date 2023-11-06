package javadevjournal.core.user.service;

import javadevjournal.core.exception.InvalidTokenException;
import javadevjournal.core.exception.UnkownIdentifierException;

public interface CustomerAccountService {

	void forgottenPassword(final String userName) throws UnkownIdentifierException;

	void updatePassword(final String password, final String token)
			throws InvalidTokenException, UnkownIdentifierException;

	boolean loginDisabled(final String username);
}
