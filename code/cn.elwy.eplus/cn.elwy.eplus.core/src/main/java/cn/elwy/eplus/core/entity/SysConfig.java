package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class SysConfig extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String confType; // 类型
	private String confCode; // 代码
	private String confName; // 名称
	private String version; // 版本
	private String content; // 配置内容
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public SysConfig() {
		super();
	}

	public SysConfig(String id) {
		super(id);
	}

	public String getConfType() {
		return confType;
	}

	public void setConfType(String confType) {
		this.confType = confType == null ? null : confType.trim();
	}

	public String getConfCode() {
		return confCode;
	}

	public void setConfCode(String confCode) {
		this.confCode = confCode == null ? null : confCode.trim();
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName == null ? null : confName.trim();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
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