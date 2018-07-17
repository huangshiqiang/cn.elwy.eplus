package cn.elwy.eplus.core.entity;

import java.util.Date;

import cn.elwy.common.entity.CommonEntity;

public class SysLog extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String logType; // 类型
	private String userId; // 操作员ID
	private String operator; // 操作员
	private String level; // 日志级别
	private String clientIp; // 操作IP
	private String serverIp; // 服务器IP
	private String visitPath; // 访问路径
	private String msg; // 日志信息
	private Date updateTime; // 更新时间
	private String content; // 操作内容

	public SysLog() {
		super();
	}

	public SysLog(String id) {
		super(id);
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType == null ? null : logType.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level == null ? null : level.trim();
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp == null ? null : clientIp.trim();
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp == null ? null : serverIp.trim();
	}

	public String getVisitPath() {
		return visitPath;
	}

	public void setVisitPath(String visitPath) {
		this.visitPath = visitPath == null ? null : visitPath.trim();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg == null ? null : msg.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

}