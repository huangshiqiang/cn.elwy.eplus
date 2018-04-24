package cn.elwy.eplus.framework.biz;

import java.util.List;

import cn.elwy.common.model.Pageable;
import cn.elwy.common.model.Parameter;
import cn.elwy.eplus.framework.dao.Dao;

/**
 * 通用Biz接口
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface Biz<E> {

	/**
	 * 设置实体对应的Dao
	 * @author huangsq
	 * @param dao
	 */
	public void setDao(Dao<E> dao);

	/**
	 * 获取实体的Dao
	 * @author huangsq
	 * @return
	 */
	public Dao<E> getDao();

	/**
	 * 根据查询条件返回实体数目
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 返回实体数目
	 */
	public int countByCondition(Parameter parameter);

	/**
	 * 根据条件删除对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int deleteByCondition(Parameter parameter);

	/**
	 * 根据id删除对象
	 * @author huangsq
	 * @param id 主键
	 * @return 影响条数
	 */
	public int deleteByPrimaryKey(String id);

	/**
	 * 根据多个ids删除对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int deleteByPrimaryKeys(String... ids);

	/**
	 * 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return
	 */
	public int logicalDelete(E entity);

	/**
	 * 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return
	 */
	public int logicalDelete(E entity, Parameter parameter);

	/**
	 * 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entityList 记录集
	 * @return
	 */
	public int logicalDelete(List<E> entityList);

	/**
	 * 插入所有字段的内容
	 * @author huangsq
	 * @param entity 记录
	 * @return entity
	 */
	public E insert(E entity);

	/**
	 * 批量插入所有字段的内容
	 * @author huangsq
	 * @param entityList 记录集
	 * @return entityList
	 */
	public List<E> insertBatch(List<E> entityList);

	/**
	 * 批量插入内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录集
	 * @return entityList
	 */
	public List<E> insertBatchSelective(List<E> entityList);

	/**
	 * 插入内容不为null的字段
	 * @author huangsq
	 * @param entity 记录
	 * @return entity
	 */
	public E insertSelective(E entity);

	/**
	 * 查询所有对象
	 * @author huangsq
	 * @return 实体对象列表
	 */
	public List<E> queryAll();

	/**
	 * 查询所有对象
	 * @author huangsq
	 * @param page 分页
	 * @return 实体对象列表
	 */
	public Pageable<E> queryAllByPage(Pageable<E> page);

	/**
	 * 根据条件查询实体对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 实体对象列表
	 */
	public List<E> queryByCondition(Parameter parameter);

	/**
	 * 根据条件查询实体对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 实体对象列表
	 */
	public Pageable<E> queryByCondition(Parameter parameter, Pageable<E> page);

	/**
	 * 根据id查找对象
	 * @author huangsq
	 * @param id 主键
	 * @return 实体对象
	 */
	public E queryByPrimaryKey(String id);

	/**
	 * 根据ids查找对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 实体对象列表
	 */
	public List<E> queryByPrimaryKeys(String... ids);

	/**
	 * 根据条件更新对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByCondition(E entity, Parameter parameter);

	/**
	 * 根据条件更新对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByConditionSelectives(E entity, Parameter parameter);

	/**
	 * 根据id更新所有字段
	 * @author huangsq
	 * @param entity 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKey(E entity);

	/**
	 * 批量根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeys(List<E> entityList);

	/**
	 * 根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entity 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelective(E entity);

	/**
	 * 批量根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelectives(List<E> entityList);

	/**
	 * 根据多个ids审核对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int audit(String... ids);

	/**
	 * 根据多个ids反审核对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int unaudit(String... ids);

}
