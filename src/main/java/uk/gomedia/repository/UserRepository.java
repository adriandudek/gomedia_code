package uk.gomedia.repository;

import java.util.List;

import uk.gomedia.entity.User;

public interface UserRepository {
	void addUser(User u);
	boolean isUserExsist(String email);
	public List<User> getUsers();
}
