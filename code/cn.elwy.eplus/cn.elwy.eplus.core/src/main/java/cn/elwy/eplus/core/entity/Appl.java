package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Appl extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String applType; // 类型
	private String applCode; // 代码
	private String applName; // 名称
	private String icon; // 图标
	private Integer order; // 显示次序
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public Appl() {
		super();
	}

	public Appl(String id) {
		super(id);
	}

	public String getApplType() {
		return applType;
	}

	public void setApplType(String applType) {
		this.applType = applType == null ? null : applType.trim();
	}

	public String getApplCode() {
		return applCode;
	}

	public void setApplCode(String applCode) {
		this.applCode = applCode == null ? null : applCode.trim();
	}

	public String getApplName() {
		return applName;
	}

	public void setApplName(String applName) {
		this.applName = applName == null ? null : applName.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
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