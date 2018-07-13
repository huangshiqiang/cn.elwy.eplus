package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Post extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String postType; // 类型
	private String postCode; // 代码
	private String postName; // 名称
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public Post() {
		super();
	}

	public Post(String id) {
		super(id);
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType == null ? null : postType.trim();
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode == null ? null : postCode.trim();
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName == null ? null : postName.trim();
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