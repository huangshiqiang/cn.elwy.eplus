package cn.elwy.eplus.framework.biz;

import java.util.List;

import cn.elwy.common.entity.Page;
import cn.elwy.common.entity.Parameter;
import cn.elwy.eplus.framework.dao.Dao;

/**
 * @description 通用Biz接口
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface Biz<E> {

	/**
	 * @description 设置实体对应的Dao
	 * @author huangsq
	 * @param dao
	 */
	public void setDao(Dao<E> dao);

	/**
	 * @description 获取实体的Dao
	 * @author huangsq
	 * @return
	 */
	public Dao<E> getDao();

	/**
	 * @description 根据查询条件返回实体数目
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 返回实体数目
	 */
	public int countByCondition(Parameter parameter);

	/**
	 * @description 根据条件删除对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int deleteByCondition(Parameter parameter);

	/**
	 * @description 根据id删除对象
	 * @author huangsq
	 * @param id 主键
	 * @return 影响条数
	 */
	public int deleteByPrimaryKey(String id);

	/**
	 * @description 根据多个ids删除对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int deleteByPrimaryKeys(String... ids);

	/**
	 * @description 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return
	 */
	public int logicalDelete(E entity);

	/**
	 * @description 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return
	 */
	public int logicalDelete(E entity, Parameter parameter);

	/**
	 * @description 根据条件逻辑删除对象
	 * @author huangsq
	 * @param entityList 记录集
	 * @return
	 */
	public int logicalDelete(List<E> entityList);

	/**
	 * @description 插入所有字段的内容
	 * @author huangsq
	 * @param entity 记录
	 * @return entity
	 */
	public E insert(E entity);

	/**
	 * @description 批量插入所有字段的内容
	 * @author huangsq
	 * @param entityList 记录集
	 * @return entityList
	 */
	public List<E> insertBatch(List<E> entityList);

	/**
	 * @description 批量插入内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录集
	 * @return entityList
	 */
	public List<E> insertBatchSelective(List<E> entityList);

	/**
	 * @description 插入内容不为null的字段
	 * @author huangsq
	 * @param entity 记录
	 * @return entity
	 */
	public E insertSelective(E entity);

	/**
	 * @description 查询所有对象
	 * @author huangsq
	 * @return 实体对象列表
	 */
	public List<E> queryAll();

	/**
	 * @description 查询所有对象
	 * @author huangsq
	 * @param page 分页
	 * @return 实体对象列表
	 */
	public Page<E> queryAllByPage(Page<E> page);

	/**
	 * @description 根据条件查询实体对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @return 实体对象列表
	 */
	public List<E> queryByCondition(Parameter parameter);

	/**
	 * @description 根据条件查询实体对象
	 * @author huangsq
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 实体对象列表
	 */
	public Page<E> queryByCondition(Parameter parameter, Page<E> page);

	/**
	 * @description 根据id查找对象
	 * @author huangsq
	 * @param id 主键
	 * @return 实体对象
	 */
	public E queryByPrimaryKey(String id);

	/**
	 * @description 根据ids查找对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 实体对象列表
	 */
	public List<E> queryByPrimaryKeys(String... ids);

	/**
	 * @description 根据条件更新对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByCondition(E entity, Parameter parameter);

	/**
	 * @description 根据条件更新对象
	 * @author huangsq
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public int updateByConditionSelectives(E entity, Parameter parameter);

	/**
	 * @description 根据id更新所有字段
	 * @author huangsq
	 * @param entity 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKey(E entity);

	/**
	 * @description 批量根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeys(List<E> entityList);

	/**
	 * @description 根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entity 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelective(E entity);

	/**
	 * @description 批量根据id更新内容不为null的字段
	 * @author huangsq
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public int updateByPrimaryKeySelectives(List<E> entityList);

	/**
	 * @description 根据多个ids审核对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int audit(String... ids);

	/**
	 * @description 根据多个ids反审核对象
	 * @author huangsq
	 * @param ids 主键
	 * @return 影响条数
	 */
	public int unaudit(String... ids);

}
