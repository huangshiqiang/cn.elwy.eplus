package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class DataAcl extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String dataCode; // 代码
	private String dataName; // 名称
	private String property; // 属性
	private String field; // 字段名称
	private Integer order; // 显示次序
	private String clazz; // 类
	private String parameter; // 参数
	private String remark; // 备注

	public DataAcl() {
		super();
	}

	public DataAcl(String id) {
		super(id);
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode == null ? null : dataCode.trim();
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName == null ? null : dataName.trim();
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property == null ? null : property.trim();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz == null ? null : clazz.trim();
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter == null ? null : parameter.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}