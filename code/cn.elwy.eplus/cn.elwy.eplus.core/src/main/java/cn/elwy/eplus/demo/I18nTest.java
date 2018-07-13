package cn.elwy.eplus.demo;

import java.util.Map;

public class I18nTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DemoMsg.DEMO_MSG);
		Map<String, String> msg = DemoMsg.getMsgMap(DemoMsg.class);
		Map<String, String> msg1 = DemoMsg.getMsgMap(DemoMsg.class, "DEMO_MSG");
		System.out.println(msg);
		;
	}

}
