package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class Widgets extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String name; // 名称
	private String code; // 代码
	private String type; // 类型
	private String group; // 分组
	private Integer editState; // 编辑状态
	private Integer order; // 显示次序
	private String icon; // 图标
	private String content; // 控件内容
	private String includeFile; // 引用文件
	private String template; // 控件模版
	private String remark; // 备注

	public Widgets() {
		super();
	}

	public Widgets(String id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group == null ? null : group.trim();
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getIncludeFile() {
		return includeFile;
	}

	public void setIncludeFile(String includeFile) {
		this.includeFile = includeFile == null ? null : includeFile.trim();
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template == null ? null : template.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}