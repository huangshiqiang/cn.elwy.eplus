package cn.elwy.eplus.framework.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.elwy.common.id.IdUtil;
import cn.elwy.common.model.Auditable;
import cn.elwy.common.model.Deletable;
import cn.elwy.common.model.Editable;
import cn.elwy.common.model.Pageable;
import cn.elwy.common.model.Parameter;
import cn.elwy.common.util.Assert;
import cn.elwy.eplus.framework.annotation.Operation;
import cn.elwy.eplus.framework.biz.Biz;
import cn.elwy.eplus.framework.context.AppContext;
import cn.elwy.eplus.framework.dao.Dao;

public class BizImpl<E> implements Biz<E> {

	protected boolean auditSwitch;
	protected boolean autoAudit;
	private Dao<E> dao;

	public Dao<E> getDao() {
		return dao;
	}

	public void setDao(Dao<E> dao) {
		this.dao = dao;
	}

	@Operation(code = "audit")
	public int audit(String... ids) {
		Assert.notNull(ids);
		List<E> list = new ArrayList<E>();
		for (int i = 0; i < ids.length; i++) {
			E s = null;
			list.add(s);
		}
		return updateByPrimaryKeys(list);
	}

	@Operation(code = "count")
	public int countByCondition(Parameter parameter) {
		return dao.countByCondition(parameter);
	}

	@Operation(code = "delete")
	public int deleteByCondition(Parameter parameter) {
		return dao.deleteByCondition(parameter);
	}

	@Operation(code = "delete")
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Operation(code = "delete")
	public int physicalDeleteByPrimaryKeys(String... ids) {
		return dao.deleteByPrimaryKeys(ids);
	}

	@Operation(code = "delete")
	public int deleteByPrimaryKeys(String... ids) {
		return dao.deleteByPrimaryKeys(ids);
	}

	@Operation(code = "logicalDelete")
	public int logicalDelete(E entity, Parameter parameter) {
		if (entity instanceof Deletable) {
			updateDeleteInfo((Deletable) entity, 1);
			return updateByConditionSelectives(entity, parameter);
		}
		return 0;
	}

	@Operation(code = "logicalDelete")
	public int logicalDelete(E entity) {
		if (entity instanceof Deletable) {
			updateDeleteInfo((Deletable) entity, 1);
			return updateByPrimaryKeySelective(entity);
		}
		return 0;
	}

	@Operation(code = "logicalDelete")
	public int logicalDelete(List<E> entityList) {
		Assert.notEmpty(entityList);
		if (entityList.get(0) instanceof Deletable) {
			for (E entity : entityList) {
				updateDeleteInfo((Deletable) entity, 1);
			}
			return updateByPrimaryKeySelectives(entityList);
		}
		return 0;
	}

	// @CacheEvict(value = "CONSTANT", key = "test")
	@Operation(code = "insert")
	public E insert(E entity) {
		if (entity instanceof Editable) {
			insertEditInfo((Editable) entity);
		}
		return dao.insert(entity);
	}

	@Operation(code = "insertBatch")
	public List<E> insertBatch(List<E> entityList) {
		Assert.notEmpty(entityList);
		if (entityList.get(0) instanceof Editable) {
			for (E entity : entityList) {
				insertEditInfo((Editable) entity);
			}
		}
		return dao.insertBatch(entityList);
	}

	@Operation(code = "insertBatchSelective")
	public List<E> insertBatchSelective(List<E> entityList) {
		Assert.notEmpty(entityList);
		if (entityList.get(0) instanceof Editable) {
			for (E entity : entityList) {
				insertEditInfo((Editable) entity);
			}
		}
		return dao.insertBatchSelective(entityList);
	}

	@Operation(code = "insertSelective")
	public E insertSelective(E entity) {
		if (entity instanceof Editable) {
			insertEditInfo((Editable) entity);
		}
		return dao.insertSelective(entity);
	}

	@Operation(code = "queryAll")
	public List<E> queryAll() {
		return dao.selectAll();
	}

	@Operation(code = "queryAll")
	public Pageable<E> queryAllByPage(Pageable<E> page) {
		return dao.selectAllByPage(page);
	}

	// @Cacheable(value = "CONSTANT", key = "test")
	@Operation(code = "queryByCondition")
	public List<E> queryByCondition(Parameter parameter) {
		return dao.selectByCondition(parameter);
	}

	@Operation(code = "queryByCondition")
	public Pageable<E> queryByCondition(Parameter parameter, Pageable<E> page) {
		return dao.selectByConditionPage(parameter, page);
	}

	@Operation(code = "queryByPrimaryKey")
	public E queryByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Operation(code = "queryByPrimaryKeys")
	public List<E> queryByPrimaryKeys(String... ids) {
		return dao.selectByPrimaryKeys(ids);
	}

	@Operation(code = "unaudit")
	public int unaudit(String... ids) {
		Assert.notNull(ids);
		List<E> list = new ArrayList<E>();
		for (int i = 0; i < ids.length; i++) {
			E s = null;
			list.add(s);
		}
		return updateByPrimaryKeys(list);
	}

	@Operation(code = "updateByCondition")
	public int updateByCondition(E entity, Parameter parameter) {
		Assert.notEmpty(entity);
		if (entity instanceof Editable) {
			updateEditInfo((Editable) entity);
		}
		return dao.updateByCondition(parameter);
	}

	@Operation(code = "updateByConditionSelectives")
	public int updateByConditionSelectives(E entity, Parameter parameter) {
		Assert.notEmpty(entity);
		if (entity instanceof Editable) {
			updateEditInfo((Editable) entity);
		}
		return dao.updateByConditionSelectives(parameter);
	}

	@Operation(code = "updateByPrimaryKey")
	public int updateByPrimaryKey(E entity) {
		Assert.notNull(entity);
		if (entity instanceof Editable) {
			updateEditInfo((Editable) entity);
		}
		return dao.updateByPrimaryKey(entity);
	}

	@Operation(code = "updateByPrimaryKeys")
	public int updateByPrimaryKeys(List<E> entityList) {
		Assert.notEmpty(entityList);
		if (entityList.get(0) instanceof Editable) {
			for (E entity : entityList) {
				updateEditInfo((Editable) entity);
			}
		}
		return dao.updateByPrimaryKeys(entityList);
	}

	@Operation(code = "updateByPrimaryKeySelective")
	public int updateByPrimaryKeySelective(E entity) {
		Assert.notNull(entity);
		if (entity instanceof Editable) {
			updateEditInfo((Editable) entity);
		}
		return dao.updateByPrimaryKeySelective(entity);
	}

	@Operation(code = "updateByPrimaryKeySelectives")
	public int updateByPrimaryKeySelectives(List<E> entityList) {
		Assert.notEmpty(entityList);
		if (entityList.get(0) instanceof Editable) {
			for (E entity : entityList) {
				updateEditInfo((Editable) entity);
			}
		}
		return dao.updateByPrimaryKeySelectives(entityList);
	}

	/**
	 * 获取只读的字段
	 * @param editable
	 */
	protected List<String> getReadlonyColumns(String type) {
		List<String> readlonyColumns = new ArrayList<String>();
		return readlonyColumns;
	}

	protected Date getUpdateTime() {
		return new Date();
	}

	/**
	 * 插入记录时更新编辑信息
	 * @param editable
	 */
	protected void insertEditInfo(Editable editable) {
		Date updateTime = getUpdateTime();
		String userId = AppContext.getUserId();
		editable.setCreatorId(userId);
		editable.setCreateTime(updateTime);
		editable.setId(generateId(updateTime));
		if (editable instanceof Auditable) {
			updateAuditInfo((Auditable) editable, userId, updateTime);
		}
	}

	/**
	 * 保存记录时更新编辑信息
	 * @param editable
	 */
	protected void updateEditInfo(Editable editable) {
		String userId = AppContext.getUserId();
		Date updateTime = getUpdateTime();
		editable.setEditorId(userId);
		editable.setEditTime(updateTime);
		if (editable instanceof Auditable) {
			updateAuditInfo((Auditable) editable, userId, updateTime);
		}
	}

	/**
	 * 保存记录时更新删除信息
	 * @param deletable
	 */
	protected void updateDeleteInfo(Deletable deletable, int deleteState) {
		if (deleteState > 0) {
			String userId = AppContext.getUserId();
			Date updateTime = getUpdateTime();
			deletable.setDeletorId(userId);
			deletable.setDeleteTime(updateTime);
		} else {
			deletable.setDeletorId(null);
			deletable.setDeleteTime(null);
		}
		deletable.setDeleteState(deleteState);
	}

	/**
	 * 保存记录时更新审核信息
	 * @param auditable
	 * @param userId
	 * @param updateTime
	 */
	protected void updateAuditInfo(Auditable auditable, String userId, Date updateTime) {
		// 启用自审核功能
		if (autoAudit()) {
			auditable.setAuditorId(userId);
			auditable.setAuditTime(updateTime);
			auditable.setAuditState(1);
		}
	}

	protected String generateId(Date date) {
		if (date != null) {
			return IdUtil.nextId(date.getTime());
		} else {
			return IdUtil.nextId();
		}
	}

	protected boolean autoAudit() {
		return false;
	}

}
