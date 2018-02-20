package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class HandDetail extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String handoverId; // 交接ID
	private String subjectId; // 主体ID
	private String subjectType; // 主体类型

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

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId == null ? null : subjectId.trim();
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType == null ? null : subjectType.trim();
	}

}