package cn.elwy.eplus.framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.elwy.eplus.framework.util.FreemarkerUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class Ftl {
	public static void main(String[] args) throws Exception {

		String packageName = "cn.elwy.eplus.framework"; // 包名 ========1
		String objectName = "User"; // 类名 ========2
		String zindext = "1"; // 属性总数
		int zindex = 1;
		if (null != zindext && !"".equals(zindext)) {
			zindex = Integer.parseInt(zindext);
		}
		List<String[]> fieldList = new ArrayList<String[]>(); // 属性集合 ========3
		for (int i = 0; i < zindex; i++) {
			fieldList.add("userName,password".split(",")); // 属性放到集合里面
			fieldList.add("password".split(",")); // 属性放到集合里面
		}

		Map<String, Object> root = new HashMap<String, Object>(); // 创建数据模型
		root.put("fieldList", fieldList);
		root.put("packageName", packageName); // 包名
		root.put("objectName", objectName); // 类名
		root.put("objectNameLower", objectName.toLowerCase()); // 类名(全小写)
		root.put("objectNameUpper", objectName.toUpperCase()); // 类名(全大写)
		root.put("nowDate", new Date()); // 当前日期

		/*
		 * =============================================================================
		 * ================
		 */

		String filePath = "E:/temp/code/"; // 存放路径
		String ftlPath = "codeTemplate"; // ftl路径

		/* 生成mybatis xml */
		FreemarkerUtil.printFile(ftlPath, "mapperMysqlTemplate.ftl", root,
				filePath + "mybatis_mysql/" + packageName + "/" + objectName + "Mapper.xml", filePath);
		// FreemarkerUtil.printFile(ftlPath, "mapperOracleTemplate.ftl",
		// root, "mybatis_oracle/" + packageName + "/" + objectName + "Mapper.xml",
		// filePath);

	}
}
