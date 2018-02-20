package cn.elwy.eplus.framework.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import cn.elwy.common.entity.Criteria;
import cn.elwy.common.entity.QueryRule;

/**
 * @description 表达式连接.
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class Translator implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 条件规则列表 */
	protected List<Criteria> criterias;
	protected List<Object> valueList = new ArrayList<Object>();

	protected Translator() {
	}

	// if (values != null) {
	// arrayList.addAll(Arrays.asList(values));
	// }
	// if (expressions.size() != 0) {
	// for (Expression expression : expressions) {
	// List<Object> valueList = expression.getValueList();
	// arrayList.addAll(valueList);
	// }
	// }
	// return arrayList;

	public static Translator getInstance(Criteria criteria) {
		List<Criteria> criterias = new ArrayList<Criteria>();
		criterias.add(criteria);
		return getInstance(criterias);
	}

	public static Translator getInstance(List<Criteria> criterias) {
		Translator translator = new Translator();
		translator.criterias = criterias;
		return translator;
	}

	public String getQl() {
		StringBuilder ql = new StringBuilder();
		String op = " AND ";
		if (criterias != null) {
			for (Criteria criteria : criterias) {
				// ql.append("(");
				getQl(ql, criteria);
				ql.append(op);
			}
			ql.delete(ql.length() - op.length(), ql.length());
		}
		return ql.toString();
	}

	private String getQl(StringBuilder ql, Criteria criteria) {
		if (criteria == null) {
			return ql.toString();
		}
		String op = criteria.getOp().toString();
		ql.append("(");
		List<QueryRule> rules = criteria.getRules();
		for (QueryRule qr : rules) {
			ql.append(qr.getField()).append(qr.getOp());
			if (qr.isNoValue()) {

			} else {
				Object value = qr.getValue();
				if (qr.isSingleValue()) {
					ql.append("?");
					valueList.add(value);
				} else if (qr.isBetweenValue()) {
					ql.append("? AND ?");
					valueList.add(value);
					valueList.add(qr.getSecondValue());
				} else if (qr.isListValue()) {
					if (value instanceof Collection<?>) {
						valueList.addAll((Collection<?>) value);
					} else if (value instanceof Object[]) {
						valueList.addAll(Arrays.asList((Object[]) value));
					}
					int valueSize = qr.getValueSize();
					ql.append("(");
					for (int i = 1; i < valueSize; i++) {
						ql.append("? ,");
					}
					ql.deleteCharAt(ql.length() - 1);
					ql.append(")");
				}
			}
			ql.append(op);
		}
		ql.delete(ql.length() - op.length(), ql.length());

		List<Criteria> groups = criteria.getGroups();
		if (groups != null && groups.size() > 0) {
			ql.append(criteria.getRgop());// .append("(");
			String gop = criteria.getGop().toString();
			for (Criteria qrg : groups) {
				getQl(ql, qrg);
				ql.append(gop);
			}
			ql.delete(ql.length() - gop.length(), ql.length());
		}
		ql.append(")");

		return ql.toString();
	}

	public List<Object> getValueList() {
		return valueList;
	}

	public void setValueList(List<Object> valueList) {
		this.valueList = valueList;
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
