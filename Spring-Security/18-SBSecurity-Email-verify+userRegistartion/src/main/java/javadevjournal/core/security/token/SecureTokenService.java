package javadevjournal.core.security.token;

import javadevjournal.core.security.jpa.SecureToken;

public interface SecureTokenService {

	// when cutomer clicked in link for verification, we need to find user from
	// token. to know which user we need to enable
	SecureToken findByToken(final String token);

	void removeToken(final SecureToken token);
    SecureToken createSecureToken();
    void saveSecureToken(final SecureToken token);

	void removeTokenByToken(final String token);
}
