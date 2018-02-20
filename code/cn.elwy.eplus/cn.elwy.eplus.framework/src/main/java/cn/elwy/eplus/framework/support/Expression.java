package cn.elwy.eplus.framework.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 表达式连接.
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class Expression implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> joins = new ArrayList<String>();
	private List<Expression> expressions = new ArrayList<Expression>();
	private String property;
	private String comparator;
	private Object[] values;

	public Expression() {
	}

	protected Expression(String property, String comparator, Object... values) {
		this.property = property;
		this.comparator = comparator;
		this.values = values;
	}

	public void appand(String operator, Expression expression) {
		joins.add(operator);
		expressions.add(expression);
	}

	public boolean isValid() {
		if (!isValidExprossions()) {
			return false;
		}
		return true;
	}

	protected boolean isValidExprossions() {
		if (expressions.size() != 0) {
			for (Expression expression : expressions) {
				if (!expression.isValid()) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Object> getValueList() {
		List<Object> arrayList = new ArrayList<Object>();
		if (values != null) {
			arrayList.addAll(Arrays.asList(values));
		}
		if (expressions.size() != 0) {
			for (Expression expression : expressions) {
				List<Object> valueList = expression.getValueList();
				arrayList.addAll(valueList);
			}
		}
		return arrayList;
	}

	public String getQl() {
		StringBuilder ql = new StringBuilder();
		if (property != null && property.trim().length() > 0) {
			ql.append(property).append(comparator);
		}
		if (values != null) {
			int length = values.length;
			if (length == 1) {
				ql.append("?");
			} else {
				ql.append("(");
				for (int i = 0; i < length; i++) {
					ql.append("?").append(",");
				}
				ql.deleteCharAt(ql.length() - 1);
				ql.append(")");
			}
		}
		ql.append(getExpressionsQL());
		return ql.toString();
	}

	protected String getExpressionsQL() {
		StringBuilder ql = new StringBuilder();
		int size = expressions.size();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				String op = joins.get(i);
				Expression expression = expressions.get(i);
				ql.append(op);
				if (i == 0) {
					ql.append("(");
				}
				ql.append(expression.getQl());
			}
			ql.append(")");
		}
		return ql.toString();
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}

	public List<String> getJoins() {
		return joins;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	// public void setExpressions(List<Expression> expressions) {
	// this.expressions = expressions;
	// }

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}

	public static final String IN = " in ";
	public static final String NOT_IN = " not in ";
	public static final String TRUE = " 1=1 ";
	public static final String AND = " and ";
	public static final String OR = " or ";
	public static final String EQUAL = "=";
	public static final String IS_NULL = " is null ";
	public static final String IS_NOT_NULL = " is not null ";
	public static final String BETWEEN = " between ";
	public static final String LIKE = " like ";
	public static final String GT = " >";
	public static final String GE = " >=";
	public static final String LT = " <";
	public static final String LE = " <=";
	public static final String NE = " <>";
	public static final String ORDER_BY = " order by ";
	public static final String WHERE = " where ";
}
