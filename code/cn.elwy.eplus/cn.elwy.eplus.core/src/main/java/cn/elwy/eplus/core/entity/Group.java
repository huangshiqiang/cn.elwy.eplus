package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Group extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String groupType; // 类型
	private String groupCode; // 代码
	private String groupName; // 名称
	private String parentCode; // 上级代码
	private Integer editState; // 编辑状态
	private Integer order; // 显示次序
	private Integer lvalue; // 左值
	private Integer rvalue; // 右值
	private Integer level; // 层级
	private Integer subnum; // 子节点个数
	private String remark; // 备注

	public Group() {
		super();
	}

	public Group(String id) {
		super(id);
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType == null ? null : groupType.trim();
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode == null ? null : groupCode.trim();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}