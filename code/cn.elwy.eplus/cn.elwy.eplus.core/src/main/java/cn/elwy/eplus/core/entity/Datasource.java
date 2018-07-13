package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Datasource extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String dsKey; // 数据源key
	private String dsCode; // 数据源代码

	public Datasource() {
		super();
	}

	public Datasource(String id) {
		super(id);
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey == null ? null : dsKey.trim();
	}

	public String getDsCode() {
		return dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode == null ? null : dsCode.trim();
	}

}