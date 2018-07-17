package cn.elwy.eplus.core.entity;

import cn.elwy.common.entity.CommonEntity;

public class GridInfo extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String gridCode; // 表格代码
	private String columnCode; // 代码
	private String columnName; // 名称
	private String property; // 属性
	private Boolean isList; // 是否列表字段
	private Boolean isShow; // 是否显示字段
	private Boolean isForm; // 是否表单显示
	private Boolean isEdit; // 是否编辑字段
	private Integer width; // 列宽
	private Integer colspan; // 跨列
	private Integer rowspan; // 跨行
	private Integer level; // 层级
	private String align; // 对齐
	private Integer queryState; // 是否高级查询
	private String queryType; // 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	private String dictType; // 字典类型
	private String format; // 格式化
	private Boolean required; // 是否必填
	private Integer minLength; // 最小长度
	private Integer maxLength; // 最大长度
	private String minValue; // 最小值
	private String maxValue; // 最大值
	private String validateType; // 验证类型
	private String widgetId; // 控件类型（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	private Boolean isPk; // 是否主键
	private Boolean isNull; // 是否可为空
	private Boolean isInsert; // 是否为插入字段
	private String javaType; // JAVA类型
	private String jdbcType; // JDBC类型
	private Integer order; // 显示次序
	private String remark; // 备注

	public GridInfo() {
		super();
	}

	public GridInfo(String id) {
		super(id);
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode == null ? null : gridCode.trim();
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode == null ? null : columnCode.trim();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property == null ? null : property.trim();
	}

	public Boolean getIsList() {
		return isList;
	}

	public void setIsList(Boolean isList) {
		this.isList = isList;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Boolean getIsForm() {
		return isForm;
	}

	public void setIsForm(Boolean isForm) {
		this.isForm = isForm;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public Integer getRowspan() {
		return rowspan;
	}

	public void setRowspan(Integer rowspan) {
		this.rowspan = rowspan;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align == null ? null : align.trim();
	}

	public Integer getQueryState() {
		return queryState;
	}

	public void setQueryState(Integer queryState) {
		this.queryState = queryState;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType == null ? null : queryType.trim();
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType == null ? null : dictType.trim();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format == null ? null : format.trim();
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue == null ? null : minValue.trim();
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue == null ? null : maxValue.trim();
	}

	public String getValidateType() {
		return validateType;
	}

	public void setValidateType(String validateType) {
		this.validateType = validateType == null ? null : validateType.trim();
	}

	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId == null ? null : widgetId.trim();
	}

	public Boolean getIsPk() {
		return isPk;
	}

	public void setIsPk(Boolean isPk) {
		this.isPk = isPk;
	}

	public Boolean getIsNull() {
		return isNull;
	}

	public void setIsNull(Boolean isNull) {
		this.isNull = isNull;
	}

	public Boolean getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(Boolean isInsert) {
		this.isInsert = isInsert;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType == null ? null : javaType.trim();
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType == null ? null : jdbcType.trim();
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}