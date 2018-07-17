package cn.elwy.eplus.core.entity;

import java.util.Date;

import cn.elwy.common.entity.CommonEntity;

public class Handover extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String userId; // 用户ID
	private String trusteeId; // 受托人ID
	private Boolean handover; // 是否交接
	private Boolean allAuth; // 是否所有权限
	private Date inceptTime; // 生效时间
	private Date expiryTime; // 失效时间
	private Date execTime; // 执行时间
	private Integer execState; // 执行状态
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public Handover() {
		super();
	}

	public Handover(String id) {
		super(id);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getTrusteeId() {
		return trusteeId;
	}

	public void setTrusteeId(String trusteeId) {
		this.trusteeId = trusteeId == null ? null : trusteeId.trim();
	}

	public Boolean getHandover() {
		return handover;
	}

	public void setHandover(Boolean handover) {
		this.handover = handover;
	}

	public Boolean getAllAuth() {
		return allAuth;
	}

	public void setAllAuth(Boolean allAuth) {
		this.allAuth = allAuth;
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

	public Date getExecTime() {
		return execTime;
	}

	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}

	public Integer getExecState() {
		return execState;
	}

	public void setExecState(Integer execState) {
		this.execState = execState;
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