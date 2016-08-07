package uk.gomedia.service;

import java.util.List;

import uk.gomedia.dto.UserDto;
import uk.gomedia.exceptions.UserException;
import uk.gomedia.entity.User;

public interface UserService {
	void addUser(UserDto u) throws UserException;
	boolean userExists(String username);
	List<User> getUsers();
}
