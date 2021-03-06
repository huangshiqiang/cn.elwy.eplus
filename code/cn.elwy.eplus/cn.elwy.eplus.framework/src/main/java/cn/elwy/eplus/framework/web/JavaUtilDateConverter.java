package cn.elwy.eplus.framework.web;

import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

import cn.elwy.common.util.DateUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class JavaUtilDateConverter implements Converter {

	public Object convert(Class type, Object value) {
		if (value instanceof Date)
			return value;

		String p = (String) value;
		if (p == null || p.trim().length() == 0) {
			return null;
		}
		try {
			return DateUtil.parse(p, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			throw new ConversionException("unexpected type:" + value.getClass());
		}
	}

}