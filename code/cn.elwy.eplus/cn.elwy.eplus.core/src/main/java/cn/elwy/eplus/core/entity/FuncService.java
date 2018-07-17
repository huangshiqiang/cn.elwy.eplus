package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class FuncService extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String funcCode; // 功能代码
	private String objectType; // 类型:TABLE、VIEW
	private String objectName; // 表或视图名
	private String className; // 类名称
	private Boolean issync; // 同步
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public FuncService() {
		super();
	}

	public FuncService(String id) {
		super(id);
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode == null ? null : funcCode.trim();
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType == null ? null : objectType.trim();
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName == null ? null : objectName.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public Boolean getIssync() {
		return issync;
	}

	public void setIssync(Boolean issync) {
		this.issync = issync;
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