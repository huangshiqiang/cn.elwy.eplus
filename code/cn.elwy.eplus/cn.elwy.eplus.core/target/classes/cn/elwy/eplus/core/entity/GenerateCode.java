package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class GenerateCode extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String geneCode; // 生成配置代码
	private String gridCode; // 表格代码
	private Integer editState; // 编辑状态
	private String remark; // 备注

	public GenerateCode() {
		super();
	}

	public GenerateCode(String id) {
		super(id);
	}

	public String getGeneCode() {
		return geneCode;
	}

	public void setGeneCode(String geneCode) {
		this.geneCode = geneCode == null ? null : geneCode.trim();
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode == null ? null : gridCode.trim();
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