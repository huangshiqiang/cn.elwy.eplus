package cn.elwy.eplus.framework.biz.impl;

import cn.elwy.eplus.framework.dao.Dao;

public class CommonBiz<E> {

	protected Dao<E> dao;
	protected boolean autoCheck;
	protected boolean checkSwitch;

	public Dao<E> getDao() {
		return dao;
	}

	public void setDao(Dao<E> dao) {
		this.dao = dao;
	}

	protected boolean autoCheck() {
		// 根据操作编码获取对应的配置，是否开启自动审核功能。
		return false;
	}

}
