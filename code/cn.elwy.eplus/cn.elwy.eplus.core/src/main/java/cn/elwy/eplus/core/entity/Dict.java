package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Dict extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String dictType; // 类型
	private String dictCode; // 代码
	private String dictValue; // 值
	private String parentCode; // 上级代码
	private Integer lvalue; // 左值
	private Integer rvalue; // 右值
	private Integer level; // 层级
	private Integer subnum; // 子节点个数
	private Integer order; // 显示次序
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public Dict() {
		super();
	}

	public Dict(String id) {
		super(id);
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType == null ? null : dictType.trim();
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode == null ? null : dictCode.trim();
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue == null ? null : dictValue.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}

	public Integer getLvalue() {
		return lvalue;
	}

	public void setLvalue(Integer lvalue) {
		this.lvalue = lvalue;
	}

	public Integer getRvalue() {
		return rvalue;
	}

	public void setRvalue(Integer rvalue) {
		this.rvalue = rvalue;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSubnum() {
		return subnum;
	}

	public void setSubnum(Integer subnum) {
		this.subnum = subnum;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}