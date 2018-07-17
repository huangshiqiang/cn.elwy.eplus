package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Operation extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String operType; // 类型
	private String operCode; // 代码
	private String operName; // 名称
	private String parentCode; // 上级代码
	private String icon; // 图标
	private String url; // 链接地址
	private String action; // 操作的方法
	private String remark; // 备注

	public Operation() {
		super();
	}

	public Operation(String id) {
		super(id);
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType == null ? null : operType.trim();
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode == null ? null : operCode.trim();
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName == null ? null : operName.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
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