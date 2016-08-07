package uk.gomedia.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import uk.gomedia.dto.UserDto;
import uk.gomedia.entity.User;
import uk.gomedia.exceptions.UserException;
import uk.gomedia.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(UserDto u) throws UserException{
		if(userExists(u.getEmail()))
			throw new UserException("User exsist in database");
		userRepository.addUser(translateUserDTO(u));
	}
	
	private User translateUserDTO(UserDto u){
		User user = new User();
		ISO8601DateFormat df = new ISO8601DateFormat();
		try {
			Date date = df.parse(u.getDateOfBirth());
			user.setDateOfBirth(date);
		} catch (ParseException e) {
		}		
		user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		user.setUsername(u.getUsername());
		user.setEmail(u.getEmail());
		return user;
	}

	@Override
	public boolean userExists(String username) {
		return userRepository.isUserExsist(username);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

}
