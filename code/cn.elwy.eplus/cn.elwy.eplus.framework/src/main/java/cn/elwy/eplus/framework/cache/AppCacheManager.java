package cn.elwy.eplus.framework.cache;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * @author huangsq
 * @version 1.0, 2018-02-24
 */
public class AppCacheManager implements CacheManager {

	private CacheManager redisCacheManager;
	private CacheManager ehCacheManager;

	private final static String redisPrefix = "redis";

	@Override
	public Cache getCache(String name) {
		if (name.startsWith(redisPrefix) && redisCacheManager != null) {
			return redisCacheManager.getCache(name);
		} else {
			return ehCacheManager.getCache(name);
		}
	}

	@Override
	public Collection<String> getCacheNames() {
		Collection<String> cacheNames = new ArrayList<String>();
		if (redisCacheManager != null) {
			cacheNames.addAll(redisCacheManager.getCacheNames());
		}
		if (ehCacheManager != null) {
			cacheNames.addAll(ehCacheManager.getCacheNames());
		}
		return cacheNames;
	}

	public CacheManager getRedisCacheManager() {
		return redisCacheManager;
	}

	public void setRedisCacheManager(CacheManager redisCacheManager) {
		this.redisCacheManager = redisCacheManager;
	}

	public CacheManager getEhCacheCacheManager() {
		return ehCacheManager;
	}

	public void setEhCacheCacheManager(CacheManager ehcacheCacheManager) {
		this.ehCacheManager = ehcacheCacheManager;
	}

}