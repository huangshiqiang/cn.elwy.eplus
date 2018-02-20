package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.PostBiz;
import cn.elwy.eplus.core.dao.PostDao;
import cn.elwy.eplus.core.entity.Post;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description PostBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class PostBizImpl extends BizImpl<Post> implements PostBiz {

	@Resource(name = "postDao")
	public void setPostDao(PostDao dao) {
		super.setDao(dao);
	}

}