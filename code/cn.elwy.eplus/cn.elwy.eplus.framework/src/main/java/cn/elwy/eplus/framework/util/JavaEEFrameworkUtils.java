package cn.elwy.eplus.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 框架的Utils
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class JavaEEFrameworkUtils {

	public static String getRandomString(int i) {
		StringBuffer sb = new StringBuffer();
//		for (int j = 0; j < i; j++) {
//			sb.append(String.valueOf(RandomUtils.nextInt(10, 0)));
//		}
		return sb.toString();
	}

	public static String stringFilter(String str) throws PatternSyntaxException {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
