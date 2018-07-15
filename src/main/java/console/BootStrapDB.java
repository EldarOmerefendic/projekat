package console;

import dao.UserDAO;
import model.User;
import service.UserService;

public class BootStrapDB {

	public static void main(String[] args) {	UserService userService = new UserService(new UserDAO());
	User user;
	
	if (userService.findByUsername("Admin") == null) {
		user = new User();
		user.setUsername("Admin");
		user.setPassword("@start1234");
		user.setEmail("quiz.admin@fet.ba");
		user.setId(1);
		user.setSuperadmin(1);
		userService.create(user);
	}
	
	if (userService.findByUsername("Eldar") == null) {
		user = new User();
		user.setUsername("Eldar");
		user.setPassword("@start1234");
		user.setEmail("eldar.omerefendic@fet.ba");
		user.setId(2);
		userService.create(user);			
	} 
	
	if (userService.findByUsername("Samra") == null) {
		user = new User();
		user.setUsername("Samra");
		user.setPassword("@start1234");
		user.setEmail("samra.muratovic@fet.ba");
		user.setId(3);
		userService.create(user);						
	}

}

}
