package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.PostBiz;
import cn.elwy.eplus.core.entity.Post;
import cn.elwy.eplus.core.service.PostService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * PostService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class PostServiceImpl extends BaseService<Post> implements PostService {

	@Resource
	public void setPostBiz(PostBiz biz) {
		super.setBiz(biz);
	}

}