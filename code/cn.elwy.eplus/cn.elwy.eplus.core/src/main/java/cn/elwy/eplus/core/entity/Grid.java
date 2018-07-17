package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Grid extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String gridCode; // 代码
	private String gridName; // 名称
	private String funcCode; // 功能代码
	private Boolean canCustom; // 可自定义显示
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public Grid() {
		super();
	}

	public Grid(String id) {
		super(id);
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode == null ? null : gridCode.trim();
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName == null ? null : gridName.trim();
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode == null ? null : funcCode.trim();
	}

	public Boolean getCanCustom() {
		return canCustom;
	}

	public void setCanCustom(Boolean canCustom) {
		this.canCustom = canCustom;
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