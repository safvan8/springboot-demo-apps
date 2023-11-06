package javadevjournal.core.user.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javadevjournal.core.exception.UserAlreadyExistException;
import javadevjournal.core.user.jpa.data.UserEntity;
import javadevjournal.core.user.jpa.repository.UserRepository;
import javadevjournal.web.data.user.UserData;

@Service("userService")
public class DefaultUserService implements UserService {

	@Resource
	private UserRepository userRepository;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public void register(UserData user) throws UserAlreadyExistException {
		if (checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("User already exists for this email");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(user, userEntity);

		userRepository.save(userEntity);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	private void encodePassword(UserData source, UserEntity target) {
		target.setPassword(passwordEncoder.encode(source.getPassword()));
	}

}
