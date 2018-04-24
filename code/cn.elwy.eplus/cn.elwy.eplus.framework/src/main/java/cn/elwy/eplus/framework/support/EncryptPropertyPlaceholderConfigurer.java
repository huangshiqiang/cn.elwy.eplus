package cn.elwy.eplus.framework.support;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import cn.elwy.common.util.encode.SecurityUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		String decryptValue = propertyValue;
		// 如果在加密属性名单中发现该属性
		if (isEncryptProp(propertyName)) {
			if (SecurityUtil.isEncryptDES(propertyValue, null)) {
				decryptValue = SecurityUtil.decryptDES(propertyValue);
				System.out.println(decryptValue);
			}
		}
		return decryptValue;
	}

	private boolean isEncryptProp(String propertyName) {
		for (String encryptName : encryptPropNames) {
			if (encryptName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}

}