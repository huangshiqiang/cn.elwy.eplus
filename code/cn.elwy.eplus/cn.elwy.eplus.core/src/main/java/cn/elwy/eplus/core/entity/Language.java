package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class Language extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String langCode; // 代码
	private String langName; // 名称
	private String region; // 地区

	public Language() {
		super();
	}

	public Language(String id) {
		super(id);
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode == null ? null : langCode.trim();
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName == null ? null : langName.trim();
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

}