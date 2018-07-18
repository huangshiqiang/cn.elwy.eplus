//package cn.elwy.eplus.framework.dao.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import cn.elwy.eplus.framework.annotation.DS.DsId;
//
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//	private final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);
//
//	@Override
//	protected Object determineCurrentLookupKey() {
//		DsId dsId = DynamicDataSourceContextHolder.getDsId();
//		logger.debug("数据源为{}", dsId);
//		return dsId.name();
//	}
//
//}