package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class FuncOper extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String funcCode; // 功能代码
	private String operCode; // 操作代码
	private String parentCode; // 上级代码
	private Integer order; // 显示次序
	private String target; // 打开目标
	private String remark; // 备注

	public FuncOper() {
		super();
	}

	public FuncOper(String id) {
		super(id);
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode == null ? null : funcCode.trim();
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode == null ? null : operCode.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}