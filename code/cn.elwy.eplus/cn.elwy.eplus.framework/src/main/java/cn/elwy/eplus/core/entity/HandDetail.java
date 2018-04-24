package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class HandDetail extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String handoverId; // 交接ID
	private String subjectType; // 主体类型
	private String subjectCode; // 主体代码

	public HandDetail() {
		super();
	}

	public HandDetail(String id) {
		super(id);
	}

	public String getHandoverId() {
		return handoverId;
	}

	public void setHandoverId(String handoverId) {
		this.handoverId = handoverId == null ? null : handoverId.trim();
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType == null ? null : subjectType.trim();
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode == null ? null : subjectCode.trim();
	}

}