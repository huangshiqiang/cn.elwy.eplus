package cn.elwy.eplus.core.entity;

import cn.elwy.common.model.CommonEntity;

public class DictI18n extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String dictType; // 字典类型
	private String dictCode; // 字典代码
	private String langCode; // 语种代码
	private String text; // 显示名称

	public DictI18n() {
		super();
	}

	public DictI18n(String id) {
		super(id);
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType == null ? null : dictType.trim();
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode == null ? null : dictCode.trim();
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode == null ? null : langCode.trim();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

}