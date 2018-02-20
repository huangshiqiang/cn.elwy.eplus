package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Role extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String orgId; // 机构ID
	private String roleCode; // 代码
	private String roleName; // 名称
	private String roleType; // 类型
	private String parentId; // 上级ID
	private Integer editState; // 编辑状态
	private Integer order; // 显示次序
	private Integer lvalue; // 左值
	private Integer rvalue; // 右值
	private Integer level; // 层级
	private Integer subnum; // 子节点个数
	private String remark; // 备注

	public Role() {
		super();
	}

	public Role(String id) {
		super(id);
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType == null ? null : roleType.trim();
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
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