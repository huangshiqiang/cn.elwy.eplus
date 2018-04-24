package cn.elwy.eplus.framework.dao.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.elwy.eplus.framework.annotation.DS;
import cn.elwy.eplus.framework.annotation.DS.DsId;

@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	public DynamicDataSourceAspect() {
		System.out.println("DynamicDataSourceAspect");
	}

	@Before("@annotation(ds)")
	public void changeDataSource(JoinPoint point, DS ds) throws Throwable {
		DsId value = ds.value();
		if (!DynamicDataSourceContextHolder.containsDataSource(value)) {
			logger.error("数据源[{}]不存在，使用默认数据源 > {}", value.name(), point.getSignature());
		} else {
			logger.debug("Use DataSource : {} > {}", value.name(), point.getSignature());
			DynamicDataSourceContextHolder.setDsId(value);
		}
	}

	@After("@annotation(ds)")
	public void restoreDataSource(JoinPoint point, DS ds) {
		logger.debug("Revert DataSource : {} > {}", ds.value().name(), point.getSignature());
		DynamicDataSourceContextHolder.clear();
	}

}
//
// @Pointcut("execution( * cn.elwy.eplus.*.service.*.*(..))")
// // @Pointcut("@annotation(cn.elwy.eplus.framework.annotation.DS)")
// public void daoAspect() {
// }
//
// @Before("daoAspect()")
// public void before(JoinPoint joinPoint) {
// DsId dsId = DsId.master;
// Method method = InterceptorSupport.getMethod(joinPoint);
// DS ds = method.getAnnotation(DS.class);
// if (ds == null) {
// ds = joinPoint.getTarget().getClass().getAnnotation(DS.class);
// }
// if (ds != null) {
// dsId = ds.value();
// }
// // 切换数据源
// DataSourceContextHolder.setDsId(dsId);
// }
//
// @After("daoAspect()")
// public void after(JoinPoint point) {
// DataSourceContextHolder.clear();
// }
//
// }