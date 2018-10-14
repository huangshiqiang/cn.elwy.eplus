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
	 * 设置实体对应的Biz
	 * @param biz
	 */
	public void setBiz(Biz<E> biz);

	/**
	 * 获取实体的Biz
	 * @return
	 */
	public Biz<E> getBiz();

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
	 * 根据实体的主键删除对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto deleteByPrimaryKey(E record);

	/**
	 * 批量根据实体的主键删除对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public ResultDto deleteByPrimaryKeys(List<E> recordList);

	/**
	 * 根据条件逻辑删除对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto logicallyDeleteByCondition(Parameter parameter);

	/**
	 * 根据条件逻辑删除对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto logicallyDeleteByPrimaryKey(E record);

	/**
	 * 批量根据条件逻辑删除对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public ResultDto logicallyDeleteByPrimaryKeys(List<E> recordList);

	/**
	 * 根据条件恢复对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto recoverByCondition(Parameter parameter);

	/**
	 * 根据条件恢复对象
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto recoverByPrimaryKey(E record);

	/**
	 * 批量根据条件恢复对象
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public ResultDto recoverByPrimaryKeys(List<E> recordList);

	/**
	 * 插入所有字段的内容
	 * @param record 记录
	 * @return record
	 */
	public ResultDto insert(E record);

	/**
	 * 批量插入所有字段的内容
	 * @param recordList 记录集
	 * @return recordList
	 */
	public ResultDto insertBatch(List<E> recordList);

	/**
	 * 批量插入内容不为null的字段
	 * @param recordList 记录集
	 * @return recordList
	 */
//	public ResultDto insertBatchSelective(List<E> recordList);

	/**
	 * 插入内容不为null的字段
	 * @param record 记录
	 * @return record
	 */
//	public ResultDto insertSelective(E record);

	/**
	 * 查询所有对象
	 * @return 记录列表
	 */
	public ResultDto queryAll();

	/**
	 * 查询所有对象
	 * @param page 分页
	 * @return 记录列表
	 */
	public ResultDto queryAllByPage(Pageable<E> page);

	/**
	 * 根据条件查询记录
	 * @param parameter 查询条件
	 * @return 记录列表
	 */
	public ResultDto queryByCondition(Parameter parameter);

	/**
	 * 根据条件查询记录
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 记录列表
	 */
	public ResultDto queryByCondition(Parameter parameter, Pageable<E> page);

	/**
	 * 根据id查找对象
	 * @param id 主键
	 * @return 记录
	 */
	public ResultDto queryByPrimaryKey(String id);

	/**
	 * 根据ids查找对象
	 * @param ids 主键
	 * @return 记录列表
	 */
	public ResultDto queryByPrimaryKeys(String... ids);

//	/**
//	 * 根据条件更新对象
//	 * @param parameter 查询条件
//	 * @return 影响条数
//	 */
//	public ResultDto updateByCondition(Parameter parameter);

	/**
	 * 根据条件更新对象
	 * @param parameter 查询条件
	 * @return 影响条数
	 */
	public ResultDto updateByConditionSelective(Parameter parameter);

//	/**
//	 * 根据id更新所有字段
//	 * @param record 记录
//	 * @return 影响条数
//	 */
//	public ResultDto updateByPrimaryKey(E record);
//
//	/**
//	 * 批量根据id更新所有字段
//	 * @param recordList 记录
//	 * @return 影响条数
//	 */
//	public ResultDto updateByPrimaryKeys(List<E> recordList);

	/**
	 * 根据id更新内容不为null的字段
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKeySelective(E record);

	/**
	 * 批量根据id更新内容不为null的字段
	 * @param recordList 记录
	 * @return 影响条数
	 */
	public ResultDto updateByPrimaryKeySelectives(List<E> recordList);

	/**
	 * 审核
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto audit(E record);

	/**
	 * 批量审核
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public ResultDto audit(List<E> recordList);

	/**
	 * 反审核
	 * @param record 记录
	 * @return 影响条数
	 */
	public ResultDto unaudit(E record);

	/**
	 * 批量反审核
	 * @param recordList 记录集
	 * @return 影响条数
	 */
	public ResultDto unaudit(List<E> recordList);

}
