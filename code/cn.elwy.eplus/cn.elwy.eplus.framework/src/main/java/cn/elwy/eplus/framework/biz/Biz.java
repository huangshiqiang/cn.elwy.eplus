package cn.elwy.eplus.framework.biz;

import java.util.List;

import cn.elwy.common.entity.Pageable;
import cn.elwy.common.entity.Parameter;
import cn.elwy.eplus.framework.dao.Dao;

/**
 * 通用Biz接口
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface Biz<E> {

	/**
	 * 设置实体对应的Dao
	 * @param dao
	 */
	public void setDao(Dao<E> dao);

	/**
	 * 获取实体的Dao
	 * @return
	 */
	public Dao<E> getDao();

	/**
	 * 根据查询条件返回实体数目
	 * @param parameter 查询条件
	 * @return 返回实体数目
	 */
	public int countByCondition(Parameter parameter);

	/**
	 * 根据条件删除对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int deleteByCondition(Parameter parameter);

	/**
	 * 根据实体的主键删除对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public int deleteByPrimaryKey(E record);

	/**
	 * 批量根据实体的主键删除对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public int deleteByPrimaryKeys(List<E> recordList);

	/**
	 * 根据条件逻辑删除对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int logicallyDeleteByCondition(Parameter parameter);

	/**
	 * 根据条件逻辑删除对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public int logicallyDeleteByPrimaryKey(E record);

	/**
	 * 批量根据条件逻辑删除对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public int logicallyDeleteByPrimaryKeys(List<E> recordList);

	/**
	 * 根据条件恢复对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int recoverByCondition(Parameter parameter);

	/**
	 * 根据条件恢复对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public int recoverByPrimaryKey(E record);

	/**
	 * 批量根据条件恢复对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public int recoverByPrimaryKeys(List<E> recordList);

	/**
	 * 插入所有字段的内容
	 * @param record 记录
	 * @return record
	 */
	public E insert(E record);

	/**
	 * 批量插入所有字段的内容
	 * @param recordList 记录集
	 * @return recordList
	 */
	public List<E> insertBatch(List<E> recordList);

	/**
	 * 批量插入内容不为null的字段
	 * @param recordList 记录集
	 * @return recordList
	 */
	public List<E> insertBatchSelective(List<E> recordList);

	/**
	 * 插入内容不为null的字段
	 * @param record 记录
	 * @return record
	 */
	public E insertSelective(E record);

	/**
	 * 查询所有对象
	 * @return 记录列表
	 */
	public List<E> queryAll();

	/**
	 * 查询所有对象
	 * @param page 分页
	 * @return 记录列表
	 */
	public Pageable<E> queryAllByPage(Pageable<E> page);

	/**
	 * 根据条件查询记录
	 * @param parameter 查询条件
	 * @return 记录列表
	 */
	public List<E> queryByCondition(Parameter parameter);

	/**
	 * 根据条件查询记录
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 记录列表
	 */
	public Pageable<E> queryByCondition(Parameter parameter, Pageable<E> page);

	/**
	 * 根据id查找对象
	 * @param id 主键
	 * @return 记录
	 */
	public E queryByPrimaryKey(String id);

	/**
	 * 根据ids查找对象
	 * @param ids 主键
	 * @return 记录列表
	 */
	public List<E> queryByPrimaryKeys(String... ids);

	/**
	 * 根据条件更新对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByCondition(Parameter parameter);

	/**
	 * 根据条件更新对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByConditionSelective(Parameter parameter);

	/**
	 * 根据id更新所有字段
	 * @param record 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKey(E record);

	/**
	 * 批量根据id更新所有字段
	 * @param recordList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeys(List<E> recordList);

	/**
	 * 根据id更新内容不为null的字段
	 * @param record 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelective(E record);

	/**
	 * 批量根据id更新内容不为null的字段
	 * @param recordList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelectives(List<E> recordList);

	/**
	 * 审核
	 * @param record 记录
	 * @return 影响条数
	 */
	public int audit(E record);

	/**
	 * 批量审核
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public int audit(List<E> recordList);

	/**
	 * 反审核
	 * @param record 记录
	 * @return 影响条数
	 */
	public int unaudit(E record);

	/**
	 * 批量反审核
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public int unaudit(List<E> recordList);

}
