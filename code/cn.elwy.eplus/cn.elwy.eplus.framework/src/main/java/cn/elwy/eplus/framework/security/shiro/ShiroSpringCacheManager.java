package cn.elwy.eplus.framework.security.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * 自定义cacheManage 扩展shiro里面的缓存 使用reids作缓存，引入自己定义的CacheManager
 * @author huangsq
 * @date 2018-02-19
 */
@Component
@DependsOn("cacheManager")
public class ShiroSpringCacheManager implements CacheManager, Destroyable {

	private org.springframework.cache.CacheManager cacheManager;

	public org.springframework.cache.CacheManager getCacheManager() {
		return cacheManager;
	}

	@Autowired
	public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public void destroy() throws Exception {
		cacheManager = null;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) {
		if (name == null) {
			return null;
		}
		return new ShiroSpringCache<K, V>(name, getCacheManager());
	}

}