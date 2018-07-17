package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Module extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String moduleType; // 类型
	private String moduleCode; // 代码
	private String moduleName; // 名称
	private Integer order; // 显示次序
	private String icon; // 图标
	private String remark; // 备注

	public Module() {
		super();
	}

	public Module(String id) {
		super(id);
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType == null ? null : moduleType.trim();
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode == null ? null : moduleCode.trim();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
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