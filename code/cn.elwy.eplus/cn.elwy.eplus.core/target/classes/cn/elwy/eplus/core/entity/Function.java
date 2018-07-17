package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Function extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String funcType; // 类型
	private String funcCode; // 代码
	private String funcName; // 名称
	private String namepy; // 拼音码
	private String moduleCode; // 模块代码
	private Boolean displayable; // 可显示
	private Integer order; // 显示次序
	private String target; // 打开目标
	private String icon; // 图标
	private String url; // 链接地址
	private String action; // 动作
	private String remark; // 备注

	public Function() {
		super();
	}

	public Function(String id) {
		super(id);
	}

	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType == null ? null : funcType.trim();
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode == null ? null : funcCode.trim();
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName == null ? null : funcName.trim();
	}

	public String getNamepy() {
		return namepy;
	}

	public void setNamepy(String namepy) {
		this.namepy = namepy == null ? null : namepy.trim();
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode == null ? null : moduleCode.trim();
	}

	public Boolean getDisplayable() {
		return displayable;
	}

	public void setDisplayable(Boolean displayable) {
		this.displayable = displayable;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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