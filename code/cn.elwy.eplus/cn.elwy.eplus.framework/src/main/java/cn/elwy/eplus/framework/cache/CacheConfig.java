package cn.elwy.eplus.framework.cache;

import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
public class CacheConfig {

	// @Bean("cacheManager")
	// @Primary
	// public CacheManager cacheManager(RedisCacheManager redisCacheManager,
	// JCacheCacheManager jcacheCacheManager) {
	// AppCacheManager cacheManager = new AppCacheManager();
	// cacheManager.setRedisCacheManager(redisCacheManager);
	// cacheManager.setEhCacheCacheManager(jcacheCacheManager);
	// return cacheManager;
	// }

}