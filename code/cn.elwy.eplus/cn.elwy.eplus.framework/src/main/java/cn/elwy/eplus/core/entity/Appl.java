package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Appl extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String applName; // 名称
	private String applCode; // 代码
	private String applType; // 类型
	private Integer editState; // 编辑状态
	private Integer order; // 显示次序
	private String icon; // 图标
	private String remark; // 备注

	public Appl() {
		super();
	}

	public Appl(String id) {
		super(id);
	}

	public String getApplName() {
		return applName;
	}

	public void setApplName(String applName) {
		this.applName = applName == null ? null : applName.trim();
	}

	public String getApplCode() {
		return applCode;
	}

	public void setApplCode(String applCode) {
		this.applCode = applCode == null ? null : applCode.trim();
	}

	public String getApplType() {
		return applType;
	}

	public void setApplType(String applType) {
		this.applType = applType == null ? null : applType.trim();
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}