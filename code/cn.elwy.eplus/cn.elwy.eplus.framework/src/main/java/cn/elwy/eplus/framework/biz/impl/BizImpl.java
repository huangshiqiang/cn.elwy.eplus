package cn.elwy.eplus.framework.biz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.elwy.common.entity.Auditable;
import cn.elwy.common.entity.Condition;
import cn.elwy.common.entity.ConditionBuilder;
import cn.elwy.common.entity.Criteria;
import cn.elwy.common.entity.Deletable;
import cn.elwy.common.entity.Editable;
import cn.elwy.common.entity.Identity;
import cn.elwy.common.entity.Pageable;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.id.IdUtil;
import cn.elwy.common.util.Assert;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.common.util.ClassUtil;
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

	@Operation(code = "count")
	public int countByCondition(Parameter parameter) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.countByCondition(condition);
	}

	@Operation(code = "delete")
	public int deleteByCondition(Parameter parameter) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.deleteByCondition(condition);
	}

	@Operation(code = "delete")
	public int deleteByPrimaryKey(E record) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			Criteria criteria = condition.addCriteria();
			criteria.andEqualTo("FID", ((Identity) record).getId());
			return dao.deleteByCondition(condition);
		}
		return dao.deleteByPrimaryKey(record);
	}

	@Operation(code = "delete")
	public int deleteByPrimaryKeys(List<E> recordList) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			Criteria criteria = condition.addCriteria();
			List<String> ids = new ArrayList<String>();
			for (E e : recordList) {
				ids.add(((Identity) e).getId());
			}
			criteria.andIn("FID", ids);
			return dao.deleteByCondition(condition);
		}
		return dao.deleteByPrimaryKeys(recordList);
	}

	@Operation(code = "logicallyDelete")
	public int logicallyDeleteByCondition(Parameter parameter) {
		E record = parameter.getData();
		if (record instanceof Deletable) {
			updateDeleteInfo((Deletable) record, getUpdateTime(), 1);

			String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
			Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
			return dao.updateByConditionSelective(condition);
		}
		return 0;
	}

	@Operation(code = "logicallyDelete")
	public int logicallyDeleteByPrimaryKey(E record) {
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return logicallyDeleteByPrimaryKeys(recordList);
	}

	@Operation(code = "logicallyDelete")
	public int logicallyDeleteByPrimaryKeys(List<E> recordList) {
		Assert.notNull(recordList);
		E record = recordList.get(0);
		if (record instanceof Deletable) {
			E deleteable = ClassUtil.newInstance(record.getClass());
			updateDeleteInfo((Deletable) deleteable, getUpdateTime(), 1);

			String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
			return updateByPrimaryKeys(deleteable, recordList, methodFullName);
		}
		return 0;
	}

	@Operation(code = "recover")
	public int recoverByCondition(Parameter parameter) {
		E record = parameter.getData();
		if (record instanceof Deletable) {
			updateDeleteInfo((Deletable) record, getUpdateTime(), 0);

			String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
			Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
			return dao.updateByConditionSelective(condition);
		}
		return 0;
	}

	@Operation(code = "recover")
	public int recoverByPrimaryKey(E record) {
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return logicallyDeleteByPrimaryKeys(recordList);
	}

	@Operation(code = "recover")
	public int recoverByPrimaryKeys(List<E> recordList) {
		Assert.notNull(recordList);
		E record = recordList.get(0);
		if (record instanceof Deletable) {
			E deleteable = ClassUtil.newInstance(record.getClass());
			updateDeleteInfo((Deletable) deleteable, getUpdateTime(), 0);

			String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
			return updateByPrimaryKeys(deleteable, recordList, methodFullName);
		}
		return 0;
	}

	// @CacheEvict(value = "CONSTANT", key = "test")
	@Operation(code = "insert")
	public E insert(E record) {
		if (record instanceof Editable) {
			insertEditInfo((Editable) record, getUpdateTime());
		}
		return dao.insert(record);
	}

	@Operation(code = "insertBatch")
	public List<E> insertBatch(List<E> recordList) {
		Assert.notEmpty(recordList);
		if (recordList.get(0) instanceof Editable) {
			Date updateTime = getUpdateTime();
			for (E record : recordList) {
				insertEditInfo((Editable) record, updateTime);
			}
		}
		return dao.insertBatch(recordList);
	}

	@Operation(code = "insertBatchSelective")
	public List<E> insertBatchSelective(List<E> recordList) {
		Assert.notEmpty(recordList);
		if (recordList.get(0) instanceof Editable) {
			Date updateTime = getUpdateTime();
			for (E record : recordList) {
				insertEditInfo((Editable) record, updateTime);
			}
		}
		return dao.insertBatchSelective(recordList);
	}

	@Operation(code = "insertSelective")
	public E insertSelective(E record) {
		if (record instanceof Editable) {
			insertEditInfo((Editable) record, getUpdateTime());
		}
		return dao.insertSelective(record);
	}

	@Operation(code = "queryAll")
	public List<E> queryAll() {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		return dao.selectByCondition(condition);
	}

	@Operation(code = "queryAll")
	public Pageable<E> queryAllByPage(Pageable<E> page) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		return dao.selectByCondition(condition, page);
	}

	// @Cacheable(value = "CONSTANT", key = "test")
	@Operation(code = "queryByCondition")
	public List<E> queryByCondition(Parameter parameter) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.selectByCondition(condition);
	}

	@Operation(code = "queryByCondition")
	public Pageable<E> queryByCondition(Parameter parameter, Pageable<E> page) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.selectByCondition(condition, page);
	}

	@Operation(code = "queryByPrimaryKey")
	public E queryByPrimaryKey(String id) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
//		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
		Criteria criteria = condition.addCriteria();
		criteria.andEqualTo("FID", id);
		List<E> list = dao.selectByCondition(condition);
		if (AssertUtil.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
//		} else {
//			return dao.selectByPrimaryKey(id);
//		}
	}

	@Operation(code = "queryByPrimaryKeys")
	public List<E> queryByPrimaryKeys(String... ids) {
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
//		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
		Criteria criteria = condition.addCriteria();
		criteria.andIn("FID", ids);
		List<E> list = dao.selectByCondition(condition);
		if (AssertUtil.isNotEmpty(list)) {
			return list;
		}
		return Collections.emptyList();
//		} else {
//			return dao.selectByPrimaryKeys(ids);
//		}
	}

	@Operation(code = "audit")
	public int audit(E record) {
		Assert.notNull(record);
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return audit(record);
	}

	@Operation(code = "audit")
	public int audit(List<E> recordList) {
		Assert.notNull(recordList);
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());

		Date updateTime = getUpdateTime();
		E record = ClassUtil.newInstance(recordList.get(0).getClass());
		if (record instanceof Auditable) {
			updateAuditInfo((Auditable) record, updateTime, 1);
		}
		return updateByPrimaryKeys(record, recordList, methodFullName);
	}

	@Operation(code = "unaudit")
	public int unaudit(E record) {
		Assert.notNull(record);
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return unaudit(record);
	}

	@Operation(code = "unaudit")
	public int unaudit(List<E> recordList) {

		Assert.notNull(recordList);
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());

		Date updateTime = getUpdateTime();
		E record = ClassUtil.newInstance(recordList.get(0).getClass());
		if (record instanceof Auditable) {
			updateAuditInfo((Auditable) record, updateTime, 0);
		}
		return updateByPrimaryKeys(record, recordList, methodFullName);
	}

	@Operation(code = "updateByCondition")
	public int updateByCondition(Parameter parameter) {
		E record = parameter.getData();
		Assert.notEmpty(record);
		if (record instanceof Editable) {
			updateEditInfoAndAutoAudit((Editable) record, getUpdateTime());
		}
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.updateByCondition(condition);
	}

	@Operation(code = "updateByConditionSelective")
	public int updateByConditionSelective(Parameter parameter) {
		E record = parameter.getData();
		Assert.notEmpty(record);
		if (record instanceof Editable) {
			updateEditInfoAndAutoAudit((Editable) record, getUpdateTime());
		}

		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName, parameter);
		return dao.updateByConditionSelective(condition);
	}

	@Operation(code = "updateByPrimaryKey")
	public int updateByPrimaryKey(E record) {
		Assert.notNull(record);
		if (record instanceof Editable) {
			updateEditInfoAndAutoAudit((Editable) record, getUpdateTime());
		}
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			condition.setData(record);
			Criteria criteria = condition.addCriteria();
			criteria.andEqualTo("FID", ((Identity) record).getId());
			return dao.updateByCondition(condition);
		} else {
			return dao.updateByPrimaryKey(record);
		}
	}

	@Operation(code = "updateByPrimaryKeys")
	public int updateByPrimaryKeys(List<E> recordList) {
		Assert.notEmpty(recordList);
		if (recordList.get(0) instanceof Editable) {
			Date updateTime = getUpdateTime();
			for (E record : recordList) {
				updateEditInfoAndAutoAudit((Editable) record, updateTime);
			}
		}
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			Criteria criteria = condition.addCriteria();
			int result = 0;
			for (E record : recordList) {
				condition.setData(record);
				criteria.andEqualTo("FID", ((Identity) record).getId());
				result += dao.updateByCondition(condition);
				criteria.clear();
			}
			return result;
		} else {
			return dao.updateByPrimaryKeys(recordList);
		}
	}

	@Operation(code = "updateByPrimaryKeySelective")
	public int updateByPrimaryKeySelective(E record) {
		Assert.notNull(record);
		if (record instanceof Editable) {
			updateEditInfoAndAutoAudit((Editable) record, getUpdateTime());
		}
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			Criteria criteria = condition.addCriteria();
			criteria.andEqualTo("FID", ((Identity) record).getId());
			return dao.updateByConditionSelective(condition);
		} else {
			return dao.updateByPrimaryKeySelective(record);
		}
	}

	@Operation(code = "updateByPrimaryKeySelectives")
	public int updateByPrimaryKeySelectives(List<E> recordList) {
		Assert.notEmpty(recordList);
		if (recordList.get(0) instanceof Editable) {
			Date updateTime = getUpdateTime();
			for (E record : recordList) {
				updateEditInfoAndAutoAudit((Editable) record, updateTime);
			}
		}
		String methodFullName = getMethodFullName(ClassUtil.getCurrentStackTraceElement());
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		if (AssertUtil.isNotEmpty(condition.getCriterias())) {
			Criteria criteria = condition.addCriteria();
			int result = 0;
			for (E record : recordList) {
				criteria.andEqualTo("FID", ((Identity) record).getId());
				result += dao.updateByConditionSelective(condition);
			}
			return result;
		} else {
			return dao.updateByPrimaryKeySelectives(recordList);
		}
	}

	protected int updateByPrimaryKeys(E record, List<E> recordList, String methodFullName) {
		Condition condition = ConditionBuilder.getCondition(methodFullName);
		condition.setData(record);
		Criteria criteria = condition.addCriteria();
		List<String> ids = new ArrayList<String>();
		for (E e : recordList) {
			ids.add(((Identity) e).getId());
		}
//		criteria.andEqualTo("FID", "QpCYtRb8G78vq2bI002");
		criteria.andIn("FID", ids);
		return dao.updateByConditionSelective(condition);
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
	protected void insertEditInfo(Editable editable, Date updateTime) {
		editable.setId(generateId(updateTime));

		String userId = AppContext.getUserId();
		editable.setCreatorId(userId);
		editable.setCreateTime(updateTime);
		editable.setEditorId(userId);
		editable.setEditTime(updateTime);

		if (editable instanceof Auditable) {
			updateAutoAuditInfo((Auditable) editable, updateTime);
		}
	}

	/**
	 * 保存记录时更新编辑信息
	 * @param editable
	 */
	protected void updateEditInfoAndAutoAudit(Editable editable, Date updateTime) {
		editable.setEditorId(AppContext.getUserId());
		editable.setEditTime(updateTime);

		if (editable instanceof Auditable) {
			updateAutoAuditInfo((Auditable) editable, updateTime);
		}
	}

	/**
	 * 保存记录时更新审核信息
	 * @param deletable
	 * @param userId
	 * @param updateTime
	 * @param state
	 */
	protected void updateDeleteInfo(Deletable deletable, Date updateTime, int state) {
		deletable.setDeletorId(AppContext.getUserId());
		deletable.setDeleteTime(updateTime);
		deletable.setDeleteState(state);
	}

	/**
	 * 保存记录时更新审核信息
	 * @param record
	 * @param userId
	 * @param updateTime
	 * @param state
	 */
	protected void updateAutoAuditInfo(Auditable record, Date updateTime) {
		if (autoAudit()) {
			updateAuditInfo((Auditable) record, updateTime, 1);
		}
	}

	/**
	 * 保存记录时更新审核信息
	 * @param record
	 * @param userId
	 * @param updateTime
	 * @param state
	 */
	protected void updateAuditInfo(Auditable record, Date updateTime, int state) {
		Auditable auditable = (Auditable) record;
		auditable.setAuditorId(AppContext.getUserId());
		auditable.setAuditTime(updateTime);
		auditable.setAuditState(state);
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

	protected String getMethodFullName(StackTraceElement ste) {
		String simpleName = this.getClass().getName();
//		return ste.getClassName() + ste.getMethodName();
		return simpleName + "." + ste.getMethodName();
	}

}
