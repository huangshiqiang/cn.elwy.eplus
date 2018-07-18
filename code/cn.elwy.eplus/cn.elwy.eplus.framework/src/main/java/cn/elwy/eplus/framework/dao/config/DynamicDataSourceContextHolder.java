//package cn.elwy.eplus.framework.dao.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import cn.elwy.eplus.framework.annotation.DS.DsId;
//
//public class DynamicDataSourceContextHolder {
//
//	public static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
//
//	/** 默认数据源 */
//	public static final DsId DEFAULT_DS = DsId.master;
//
//	private static List<String> dataSourceIds = new ArrayList<String>();
//
//	private static final ThreadLocal<DsId> contextHolder = new ThreadLocal<DsId>() {
//		@Override
//		protected DsId initialValue() {
//			return DEFAULT_DS;
//		}
//	};
//
//	// 设置数据源名
//	public static void setDsId(DsId dsId) {
//		logger.debug("切换到{}数据源", dsId);
//		contextHolder.set(dsId);
//	}
//
//	// 获取数据源名
//	public static DsId getDsId() {
//		return contextHolder.get();
//	}
//
//	public static boolean addDataSource(String dsId) {
//		return dataSourceIds.add(dsId);
//	}
//
//	public static boolean addDataSource(DsId dsId) {
//		return dataSourceIds.add(dsId.name());
//	}
//
//	public static List<String> getDataSourceIds() {
//		return dataSourceIds;
//	}
//
//	/**
//	 * 判断指定DataSrouce当前是否存在
//	 * @param dsId
//	 * @return
//	 * @author SHANHY
//	 * @create 2016年1月24日
//	 */
//	public static boolean containsDataSource(DsId dsId) {
//		return dataSourceIds.contains(dsId.name());
//	}
//
//	/**
//	 * 判断指定DataSrouce当前是否存在
//	 * @param dsId
//	 * @return
//	 * @author SHANHY
//	 * @create 2016年1月24日
//	 */
//	public static boolean containsDataSource(String dsId) {
//		return dataSourceIds.contains(dsId);
//	}
//
//	// 清除数据源名
//	public static void clear() {
//		contextHolder.remove();
//	}
//
//}