package cn.elwy.eplus.framework.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class JCacheConfig {

	// @Bean("jCacheCacheManager")
	// @Bean
	// public JCacheCacheManager jcacheCacheManager() {
	// JCacheCacheManager cm = new JCacheCacheManager();
	// cm.setCacheManager(jsr107cacheManager());
	// return cm;
	// }
	//
	// @Bean
	// public CacheManager jsr107cacheManager() {
	// CachingProvider provider = Caching.getCachingProvider();
	// CacheManager cacheManager = provider.getCacheManager();
	//
	// MutableConfiguration<Long, String> configuration = new
	// MutableConfiguration<Long, String>()
	// // Cannot set type for store! this may be a bug in spring or ehCache
	// // .setTypes(Long.class, String.class)
	// .setStoreByValue(false).setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
	// cacheManager.createCache("CONSTANT", configuration);
	//
	// return cacheManager;
	// }

}