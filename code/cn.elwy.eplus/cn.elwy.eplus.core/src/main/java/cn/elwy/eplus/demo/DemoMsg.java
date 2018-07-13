package cn.elwy.eplus.demo;

import cn.elwy.common.i18n.Msg;
import cn.elwy.common.i18n.NLS;

/**
 * 常用国际化信息类,信息按首字母分类 E:错误信息,F:需要格式化的信息,T:文本信息,,M:提示信息,
 * @author huangsq
 * @version 1.0, 2018-02-20
 */
public class DemoMsg extends Msg {

	private static Class<? extends Msg> clazz = DemoMsg.class;
	private static String BUNDLE_NAME = DemoMsg.class.getName();

	public static String DEMO_MSG;

	static {
		// msgMaps.put(Msg.class.getName(), NLS.initializeMessages(BUNDLE_NAME,
		// Msg.class));
		msgMaps.put(clazz, NLS.initializeMessages(BUNDLE_NAME, clazz));
	}

	protected DemoMsg() {
	}

}
