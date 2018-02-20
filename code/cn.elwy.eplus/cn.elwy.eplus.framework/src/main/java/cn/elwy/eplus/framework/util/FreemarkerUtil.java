package cn.elwy.eplus.framework.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class FreemarkerUtil {

	/**
	 * 输出到输出到文件
	 * @param ftlName ftl文件名
	 * @param root 传入的map
	 * @param outFile 输出后的文件全部路径
	 * @param filePath 输出前的文件上部路径
	 */
	public static void printFile(String ftlPath, String ftlName, Map<String, Object> root, String outFile,
			String filePath) throws Exception {
		try {
			File file = new File(outFile);
			if (!file.getParentFile().exists()) { // 判断有没有父路径，就是判断文件整个路径是否存在
				file.getParentFile().mkdirs(); // 不存在就全部创建
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			Template template = getTemplate(ftlPath, ftlName);
			template.process(root, out); // 模版输出
			out.flush();
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过文件名加载模版
	 * @param ftlName
	 */
	@SuppressWarnings("deprecation")
	public static Template getTemplate(String filePath, String ftlName) throws Exception {
		try {
			Configuration cfg = new Configuration(); // 通过Freemaker的Configuration读取相应的ftl
			cfg.setEncoding(Locale.CHINA, "utf-8");
			cfg.setDirectoryForTemplateLoading(new File(
					"E:/Workspace/Java/cn.elwy/cn.elwy.common/code/cn.elwy.eplus.framework/src/main/resources/" + filePath)); // 设定去哪里读取相应的ftl模板文件
			Template temp = cfg.getTemplate(ftlName); // 在模板文件目录中找到名称为name的文件
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
