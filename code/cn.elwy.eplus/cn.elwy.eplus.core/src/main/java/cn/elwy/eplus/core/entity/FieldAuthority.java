package cn.elwy.eplus.core.entity;

import java.util.Date;

import cn.elwy.common.entity.CommonEntity;

public class FieldAuthority extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String subjectType; // 主体类型
	private String subjectCode; // 主体代码
	private String dataCode; // 数据代码
	private String field; // 字段名称
	private Integer permission; // 权限：0.禁用、1.只读、2.可授权
	private Date inceptTime; // 生效时间
	private Date expiryTime; // 失效时间
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public FieldAuthority() {
		super();
	}

	public FieldAuthority(String id) {
		super(id);
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

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode == null ? null : dataCode.trim();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
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