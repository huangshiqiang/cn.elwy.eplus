package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class ApplFunc extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String applFuncName; // 名称
	private String applFuncCode; // 代码
	private String applFuncType; // 类型
	private String applId; // 应用ID
	private String funcId; // 功能ID
	private String parentId; // 上级ID
	private Integer editState; // 编辑状态
	private Integer order; // 显示次序
	private Integer lvalue; // 左值
	private Integer rvalue; // 右值
	private Integer level; // 层级
	private Integer subnum; // 子节点个数
	private String target; // 打开目标
	private String icon; // 图标
	private String url; // 链接地址
	private String action; // 动作
	private String remark; // 备注

	public ApplFunc() {
		super();
	}

	public ApplFunc(String id) {
		super(id);
	}

	public String getApplFuncName() {
		return applFuncName;
	}

	public void setApplFuncName(String applFuncName) {
		this.applFuncName = applFuncName == null ? null : applFuncName.trim();
	}

	public String getApplFuncCode() {
		return applFuncCode;
	}

	public void setApplFuncCode(String applFuncCode) {
		this.applFuncCode = applFuncCode == null ? null : applFuncCode.trim();
	}

	public String getApplFuncType() {
		return applFuncType;
	}

	public void setApplFuncType(String applFuncType) {
		this.applFuncType = applFuncType == null ? null : applFuncType.trim();
	}

	public String getApplId() {
		return applId;
	}

	public void setApplId(String applId) {
		this.applId = applId == null ? null : applId.trim();
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId == null ? null : funcId.trim();
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action == null ? null : action.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}