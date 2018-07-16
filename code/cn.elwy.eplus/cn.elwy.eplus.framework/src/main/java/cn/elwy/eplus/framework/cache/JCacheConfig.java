package cn.elwy.eplus.framework.cache;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JCacheConfig {

	// @Bean("jCacheCacheManager")
	// public JCacheCacheManager jCacheCacheManager() throws URISyntaxException {
	// CachingProvider provider = Caching.getCachingProvider();
	// JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
	// javax.cache.CacheManager eh107CacheManager =
	// provider.getCacheManager(getClass().getResource("/config/ehcache.xml").toURI(),
	// getClass().getClassLoader());
	// jCacheCacheManager.setCacheManager(eh107CacheManager);
	// return jCacheCacheManager;
	// }

//	@Bean("jCacheCacheManager")
//	public JCacheCacheManager jcacheCacheManager() {
//		JCacheCacheManager cm = new JCacheCacheManager();
//		cm.setCacheManager(jsr107cacheManager());
//		return cm;
//	}
//
//	@Bean
//	public CacheManager jsr107cacheManager() {
//		CachingProvider provider = Caching.getCachingProvider();
//		CacheManager cacheManager = provider.getCacheManager();
//
//		MutableConfiguration<Long, String> configuration = new MutableConfiguration<Long, String>();
//		// Cannot set type for store! this may be a bug in spring or ehCache
//		// configuration.setTypes(Long.class, String.class)
//		configuration.setStoreByValue(false).setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
////		cacheManager.createCache("CONSTANT21", configuration);
//
//		return cacheManager;
//	}

}