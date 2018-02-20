package cn.elwy.eplus.framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.core.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService mapper;

	@Test
	public void testInsert() {
		User user = new User();
		user.setUserName("张三");
		user.setUserCode("张三");
		user.setId("23");
		mapper.insert(user);
		System.out.println("插入用户信息" + user.getUserName());
	}

}