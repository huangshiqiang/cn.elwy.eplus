package cn.elwy.eplus.framework.dao;

/**
 * @description Mybatis Sql脚本的ID名称
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface SqlIdConst {

	/** 根据查询条件返回实体数目 */
	public static String countByCondition = "countByCondition";
	/** 根据条件删除对象 */
	public static String deleteByCondition = "deleteByCondition";
	/** 根据id删除对象 */
	public static String deleteByPrimaryKey = "deleteByPrimaryKey";
	/** 根据多个ids删除对象 */
	public static String deleteByPrimaryKeys = "deleteByPrimaryKeys";
	/** 插入所有字段的内容 */
	public static String insert = "insert";
	/** 插入内容不为null的字段 */
	public static String insertSelective = "insertSelective";
	/** 批量插入所有字段的内容 */
	// public static String insertBatch = "insertBatch";
	/** 批量插入内容不为null的字段 */
	// public static String insertBatchSelective = "insertBatchSelective";
	/** 查询所有实体对象 */
	// public static String selectAll = "selectAll";
	/** 根据条件查询实体对象 */
	public static String selectByCondition = "selectByCondition";
	// public static String selectByConditionPage = "selectByConditionPage";
	/** 根据id查找对象 */
	public static String selectByPrimaryKey = "selectByPrimaryKey";
	/** 根据ids查找对象 */
	// public static String selectByPrimaryKeys = "selectByPrimaryKey";
	/** 根据条件查询实体对象 */
	public static String selectPageByCondition = "selectPageByCondition";
	/** 根据条件更新对象 */
	public static String updateByCondition = "updateByCondition";
	/** 根据条件更新对象 */
	public static String updateByConditionSelectives = "updateByConditionSelectives";
	/** 根据id更新所有字段 */
	public static String updateByPrimaryKey = "updateByPrimaryKey";
	/** 根据id更新内容不为null的字段 */
	public static String updateByPrimaryKeySelective = "updateByPrimaryKeySelective";
	/** 批量根据id更新内容不为null的字段 */
	// public static String updateByPrimaryKeys = "updateByPrimaryKeys";
	/** 批量根据id更新内容不为null的字段 */
	// public static String updateByPrimaryKeySelectives =
	// "updateByPrimaryKeySelectives";

}
