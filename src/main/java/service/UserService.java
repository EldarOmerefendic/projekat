package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {
	
	private UserDAO UserDAO;
	
	public UserService(UserDAO UserDao) {
		this.UserDAO = UserDao;
	}
	
	public boolean create(User user) {		
		return UserDAO.save(user);	
	}
	
	public boolean remove(int userId) {
		return UserDAO.deleteById(userId);
	}
	
	public List<User> findAll() {
		return UserDAO.findAll();
	}
	
	public User findByUsername(String username) {
		return UserDAO.findByUsername(username);
	}
	
	public User authenticate(String username, String password) {
		
		User user = findByUsername(username);
		
		if (user == null) {
			return null;
		}
		
		if (user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
}