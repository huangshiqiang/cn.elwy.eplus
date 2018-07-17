package cn.elwy.eplus.framework.service;

import java.util.List;

import cn.elwy.common.entity.Pageable;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.eplus.framework.biz.Biz;

/**
 * 通用Service接口
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface Service<E> {

	/**
	 * 根据多个ids审核对象
	 * @param ids 主键
	 * @return 影响条数
	 */
	public ResultDto audit(String... ids);

	/**
	 * 根据查询条件返回实体数目
	 * @param parameter 查询条件
	 * @return 返回实体数目
	 */
	public ResultDto countByCondition(Parameter parameter);

	/**
	 * 根据条件删除对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto deleteByCondition(Parameter parameter);

	/**
	 * 根据id删除对象
	 * @param id 主键
	 * @return 影响条数
	 */
	public ResultDto deleteByPrimaryKey(String id);

	/**
	 * 根据多个ids删除对象
	 * @param ids 主键
	 * @return 影响条数
	 */
	public ResultDto deleteByPrimaryKeys(String... ids);

	/**
	 * 获取实体的Biz
	 * @return
	 */
	public Biz<E> getBiz();

	/**
	 * 插入所有字段的内容
	 * @param entity 记录
	 * @return entity
	 */
	public ResultDto insert(E entity);

	/**
	 * 批量插入所有字段的内容
	 * @param entityList 记录集
	 * @return entityList
	 */
	public ResultDto insertBatch(List<E> entityList);

	/**
	 * 批量插入内容不为null的字段
	 * @param entityList 记录集
	 * @return entityList
	 */
	public ResultDto insertBatchSelective(List<E> entityList);

	/**
	 * 插入内容不为null的字段
	 * @param entity 记录
	 * @return entity
	 */
	public ResultDto insertSelective(E entity);

	/**
	 * 查询所有对象
	 * @return 实体对象列表
	 */
	public ResultDto queryAll();

	/**
	 * 查询所有对象
	 * @param page 分页
	 * @return 实体对象列表
	 */
	public ResultDto queryAllByPage(Pageable<E> page);

	/**
	 * 根据条件查询实体对象
	 * @param parameter 查询条件
	 * @return 实体对象列表
	 */
	public ResultDto queryByCondition(Parameter parameter);

	/**
	 * 根据条件查询实体对象
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 实体对象列表
	 */
	public ResultDto queryByCondition(Parameter parameter, Pageable<E> page);

	/**
	 * 根据id查找对象
	 * @param id 主键
	 * @return 实体对象
	 */
	public ResultDto queryByPrimaryKey(String id);

	/**
	 * 根据ids查找对象
	 * @param ids 主键
	 * @return 实体对象列表
	 */
	public ResultDto queryByPrimaryKeys(String... ids);

	/**
	 * 设置实体对应的Biz
	 * @param biz
	 */
	public void setBiz(Biz<E> biz);

	/**
	 * 根据多个ids反审核对象
	 * @param ids 主键
	 * @return 影响条数
	 */
	public ResultDto unaudit(String... ids);

	/**
	 * 根据条件更新对象
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto updateByCondition(E entity, Parameter parameter);

	/**
	 * 根据条件更新对象
	 * @param entity 记录
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto updateByConditionSelectives(E entity, Parameter parameter);

	/**
	 * 根据id更新所有字段
	 * @param entity 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKey(E entity);

	/**
	 * 根据id更新内容不为null的字段
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKeys(List<E> entityList);

	/**
	 * 根据id更新内容不为null的字段
	 * @param entity 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKeySelective(E entity);

	/**
	 * 批量根据id更新内容不为null的字段
	 * @param entityList 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKeySelectives(List<E> entityList);

}
