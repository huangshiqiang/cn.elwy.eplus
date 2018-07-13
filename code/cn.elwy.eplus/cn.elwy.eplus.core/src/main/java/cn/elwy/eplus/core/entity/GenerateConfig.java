package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class GenerateConfig extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String geneCode; // 代码
	private String geneName; // 名称
	private String filePath; // 生成文件路径
	private String packageName; // 生成包路径
	private String moduleName; // 生成模块名
	private String subModuleName; // 生成子模块名
	private String functionCode; // 功能代码
	private String functionName; // 功能名称
	private String functionAuthor; // 功能作者
	private String remark; // 备注

	public GenerateConfig() {
		super();
	}

	public GenerateConfig(String id) {
		super(id);
	}

	public String getGeneCode() {
		return geneCode;
	}

	public void setGeneCode(String geneCode) {
		this.geneCode = geneCode == null ? null : geneCode.trim();
	}

	public String getGeneName() {
		return geneName;
	}

	public void setGeneName(String geneName) {
		this.geneName = geneName == null ? null : geneName.trim();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName == null ? null : packageName.trim();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName == null ? null : subModuleName.trim();
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode == null ? null : functionCode.trim();
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName == null ? null : functionName.trim();
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor == null ? null : functionAuthor.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}