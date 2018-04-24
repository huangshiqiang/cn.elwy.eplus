package cn.elwy.eplus.framework;

import java.util.Date;

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
		user.setUserType("1");
		user.setId("23");

		user.setRoleCode("role");
		user.setOrgCode("org");
		user.setPostCode("postCode");
		user.setPostcode("post");
		user.setPassword("zs");
		user.setEditState(1);
		user.setLockState(0);
		user.setCreatorId("ax");
		user.setCreateTime(new Date());

		// `FEDIT_STATE` smallint(6) not null comment '编辑状态',
		// `FLOCK_STATE` smallint(1) default null comment '锁定状态',
		// `FCREATOR_ID` varchar(30) not null comment '创建者',
		// `FCREATE_TIME` datetime not null comment '创建时间',

		mapper.insert(user);
		System.out.println("插入用户信息" + user.getUserName());
	}

}