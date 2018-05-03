package junit.test;

import org.junit.Test;

import com.henu.entity.User;
import com.henu.exception.UserExistException;
import com.henu.service.UserService;

public class UserTest {

	@Test
	public void testAdd() {
		User user = new User();
		user.setUsername("789");
		user.setPassword("12453werd");
		user.setEmail("798456@qq.ocm");
		user.setPhone("15643278965");
		user.setGender("男");
		user.setType(1);
		UserService us = new UserService();
		try {
			us.register(user);
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
