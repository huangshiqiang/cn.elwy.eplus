package cn.elwy.eplus.core.entity;

import java.util.Date;

import cn.elwy.common.entity.CommonEntity;

public class UserGroup extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String userId; // 用户ID
	private String groupId; // 组ID
	private Boolean canManage; // 是否可以管理
	private Date inceptTime; // 生效时间
	private Date expiryTime; // 失效时间
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public UserGroup() {
		super();
	}

	public UserGroup(String id) {
		super(id);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
	}

	public Boolean getCanManage() {
		return canManage;
	}

	public void setCanManage(Boolean canManage) {
		this.canManage = canManage;
	}

	public Date getInceptTime() {
		return inceptTime;
	}

	public void setInceptTime(Date inceptTime) {
		this.inceptTime = inceptTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
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