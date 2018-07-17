package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class UserConfig extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String userId; // 用户ID
	private String confCode; // 代码
	private String confName; // 名称
	private Integer version; // 版本
	private Integer editState; // 编辑状态
	private String content; // 配置内容
	private String remark; // 备注

	public UserConfig() {
		super();
	}

	public UserConfig(String id) {
		super(id);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}