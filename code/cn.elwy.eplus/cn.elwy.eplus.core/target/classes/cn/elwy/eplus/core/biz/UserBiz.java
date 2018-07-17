package cn.elwy.eplus.core.biz;

import java.util.List;

import cn.elwy.common.entity.Parameter;
import cn.elwy.eplus.framework.biz.Biz;
import cn.elwy.eplus.framework.entity.User;

/**
 * UserBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
public interface UserBiz extends Biz<User> {

	public List<User> queryByCondition(Parameter parameter, int test);

}