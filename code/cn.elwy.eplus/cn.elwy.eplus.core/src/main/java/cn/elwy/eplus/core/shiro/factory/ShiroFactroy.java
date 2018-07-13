package cn.elwy.eplus.core.shiro.factory;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.model.Parameter;
import cn.elwy.common.model.ResultDto;
import cn.elwy.eplus.core.service.UserService;
import cn.elwy.eplus.framework.context.SpringContext;
import cn.elwy.eplus.framework.entity.User;

@Service
@DependsOn("springContext")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

	@Autowired
	private UserService userService;

	public static IShiro instance() {
		return SpringContext.getBean(IShiro.class);
	}

	@Override
	public User user(String username) {

		Parameter parameter = new Parameter();
		parameter.setId("11");
		parameter.addParam("FUSER_NAME", username);
		// parameter.addParam("FPASSWORD", password);
		final ResultDto rd = userService.queryByCondition(parameter);// PrimaryKey(parameter.getId());
		if (rd != null) {
			User user = (User) rd.getDatas().get(0);
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", user);
			// 设置盐值
			return user;
		}
		return null;
	}

}