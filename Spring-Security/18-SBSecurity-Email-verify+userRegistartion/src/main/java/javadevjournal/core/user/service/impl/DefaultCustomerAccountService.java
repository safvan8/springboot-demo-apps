package javadevjournal.core.user.service.impl;

import java.util.Objects;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javadevjournal.core.email.context.ForgotPasswordEmailContext;
import javadevjournal.core.email.service.EmailService;
import javadevjournal.core.exception.InvalidTokenException;
import javadevjournal.core.exception.UnkownIdentifierException;
import javadevjournal.core.security.jpa.SecureToken;
import javadevjournal.core.security.token.SecureTokenService;
import javadevjournal.core.security.token.repository.SecureTokenRepository;
import javadevjournal.core.user.jpa.data.UserEntity;
import javadevjournal.core.user.jpa.repository.UserRepository;
import javadevjournal.core.user.service.CustomerAccountService;
import javadevjournal.core.user.service.UserService;

@Service("customerAccountService")
public class DefaultCustomerAccountService implements CustomerAccountService {

	@Resource
	UserService userService;

	@Resource
	private SecureTokenService secureTokenService;

	@Resource
	SecureTokenRepository secureTokenRepository;

	@Value("${site.base.url.https}")
	private String baseURL;

	@Resource
	private EmailService emailService;

	@Resource
	private UserRepository userRepository;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public void forgottenPassword(String userName) throws UnkownIdentifierException {
		UserEntity user = userService.getUserById(userName);
		sendResetPasswordEmail(user);
	}

	@Override
	public void updatePassword(String password, String token) throws InvalidTokenException, UnkownIdentifierException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}
		UserEntity user = userRepository.getOne(secureToken.getUser().getId());
		if (Objects.isNull(user)) {
			throw new UnkownIdentifierException("unable to find user for the token");
		}
		secureTokenService.removeToken(secureToken);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	protected void sendResetPasswordEmail(UserEntity user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken);
		ForgotPasswordEmailContext emailContext = new ForgotPasswordEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean loginDisabled(String username) {
		UserEntity user = userRepository.findByEmail(username);
		return user != null ? user.isLoginDisabled() : false;
	}
}
