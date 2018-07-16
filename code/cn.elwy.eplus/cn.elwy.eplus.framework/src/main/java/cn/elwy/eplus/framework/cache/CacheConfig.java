package cn.elwy.eplus.framework.cache;

import java.net.URISyntaxException;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

	@Bean("redisCacheManager")
	public RedisCacheManager redisCacheManager(@Qualifier("redisTemplate") RedisTemplate<?, ?> redisTemplate) {
		// 设置数据存入 redis 的序列化方式
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// redisTemplate.setHashValueSerializer(new BaseEntity<>());
		// redisTemplate.setValueSerializer(new BaseEntity<>());
		return new RedisCacheManager(redisTemplate);
	}

	@Bean("jCacheCacheManager")
	public JCacheCacheManager jCacheCacheManager() throws URISyntaxException {
		CachingProvider provider = Caching.getCachingProvider();
		JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
		javax.cache.CacheManager eh107CacheManager = provider
				.getCacheManager(getClass().getResource("/ehcache.xml").toURI(), getClass().getClassLoader());
		jCacheCacheManager.setCacheManager(eh107CacheManager);
		return jCacheCacheManager;
	}

	@Bean("cacheManager")
	@DependsOn({ "jCacheCacheManager", "redisCacheManager" })
	@Primary
	public CacheManager initMixCacheManager(JCacheCacheManager jcacheCacheManager, RedisCacheManager redisCacheManager) {
		AppCacheManager cacheManager = new AppCacheManager();
		cacheManager.setEhCacheCacheManager(jcacheCacheManager);
		cacheManager.setRedisCacheManager(redisCacheManager);
		return cacheManager;
	}

}