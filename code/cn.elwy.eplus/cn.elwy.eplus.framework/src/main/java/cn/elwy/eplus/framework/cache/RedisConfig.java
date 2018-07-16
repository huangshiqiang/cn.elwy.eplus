package cn.elwy.eplus.framework.cache;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis缓存配置类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig extends CachingConfigurerSupport {

	private final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

	private String host;

	private String password;

	private int port;

	private int timeout;

	private int maxIdle;// 最大空闲连接数, 默认8个

	private long maxWaitMillis;// 获取连接时的最大等待毫秒数

	private boolean testOnBorrow;// 在获取连接的时候检查有效性, 默认false

	private boolean testWhileIdle;// 空闲是否检查是否有效，默认为false

	private List<String> cacheNames = new ArrayList<String>();// 空闲是否检查是否有效，默认为false

	@Bean("jedisPoolConfig")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		jedisPoolConfig.setTestWhileIdle(testWhileIdle);
		return jedisPoolConfig;
	}

	@Bean("jedisConnectionFactory")
	@DependsOn({ "jedisPoolConfig" })
	public JedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		// 如果集群使用new JedisConnectionFactory(new
		// RedisClusterConfiguration()),集群配置在RedisClusterConfiguration,这里省略具体配置
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setPoolConfig(jedisPoolConfig);

		redisConnectionFactory.setHostName(host);
		redisConnectionFactory.setPort(port);
		redisConnectionFactory.setTimeout(timeout);
		return redisConnectionFactory;
	}

	/**
	 * RedisTemplate配置
	 * @param connectionFactory
	 * @return RedisTemplate
	 */
	@Bean("redisTemplate")
	@DependsOn({ "jedisConnectionFactory" })
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(connectionFactory);
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		// Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new
		// Jackson2JsonRedisSerializer<Object>(Object.class);
		// ObjectMapper om = new ObjectMapper();
		// om.setVisibility(PropertyAccessor.ALL,
		// JsonAutoDetect.Visibility.ANY);redisCacheManager
		// om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// jackson2JsonRedisSerializer.setObjectMapper(om);
		// redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
		redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
		return redisTemplate;
	}

	/**
	 * redis缓存管理器
	 * @param redisTemplate
	 * @return
	 */
	@Bean("redisCacheManager")
	@DependsOn({ "redisTemplate" })
	public RedisCacheManager redisCacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		// 设置缓存过期时间(秒),默认为0不限制
		// cacheManager.setDefaultExpiration(120);
		// List<String> cacheNames = new ArrayList<String>();
		// cacheNames.add("myRedis");
		// cacheNames.add("j2CacheRedis");
		cacheManager.setCacheNames(cacheNames);
		return cacheManager;
	}

	// @Bean
	// public JedisPool jredisPoolFactory() {
	// logger.info("JedisPool注入成功！！");
	// logger.info("redis地址：" + host + ":" + port);
	// JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	// jedisPoolConfig.setMaxIdle(maxIdle);
	// jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
	//
	// JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,
	// password);
	// return jedisPool;
	// }

	// /**
	// * spring cache整合(EhCache,Redis)二级缓存具体Cache
	// * @param redisCacheManager
	// * @param redisTemplate
	// * @return
	// */
	// @Bean
	// public MyCacheTemplate myCacheTemplate(RedisCacheManager redisCacheManager,
	// RedisTemplate<String, Object> redisTemplate) {
	// MyCacheTemplate myCacheTemplate = new MyCacheTemplate();
	// myCacheTemplate.setRedisCacheManager(redisCacheManager);
	// myCacheTemplate.setRedisTemplate(redisTemplate);
	// myCacheTemplate.setName("j2CacheRedis");
	// return myCacheTemplate;
	// }
	//
	// /**
	// * 自定义redis缓存
	// * @param redisCacheManager
	// * @param redisTemplate
	// * @return
	// */
	// @Bean
	// public MyRedisCache myRedisCache(RedisCacheManager redisCacheManager,
	// RedisTemplate<String, Object> redisTemplate) {
	// MyRedisCache myRedisCache = new MyRedisCache();
	// // 自定义属性配置缓存名称
	// myRedisCache.setName("myRedis");
	// // redis缓存管理器
	// myRedisCache.setRedisCacheManager(redisCacheManager);
	// // redisTemplate 实例
	// myRedisCache.setRedisTemplate(redisTemplate);
	// return myRedisCache;
	// }
	//
	// /**
	// * spring cache 统一缓存管理器
	// * @param myCacheTemplate
	// * @param myRedisCache
	// * @return
	// */
	// @Bean
	// @Primary
	// public CacheManager cacheManager(MyCacheTemplate myCacheTemplate,
	// MyRedisCache myRedisCache) {
	// MyCacheManager cacheManager = new MyCacheManager();
	// cacheManager.setMyCacheTemplate(myCacheTemplate);
	// cacheManager.setMyRedisCache(myRedisCache);
	// return cacheManager;
	// }
	//
	// // 整合ehcache
	// @Bean
	// public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean
	// ch) {
	// EhCacheCacheManager ehCacheCacheManager = new
	// EhCacheCacheManager(ch.getObject());
	// return ehCacheCacheManager;
	// }
	//
	// @Bean
	// public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
	// EhCacheManagerFactoryBean cacheManagerFactoryBean = new
	// EhCacheManagerFactoryBean();
	// // 这里暂时借用shiro的ehcache配置文件
	// Resource r = new ClassPathResource("ehcache-shiro.xml");
	// cacheManagerFactoryBean.setConfigLocation(r);
	// cacheManagerFactoryBean.setShared(true);
	// return cacheManagerFactoryBean;
	// }

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	public CacheErrorHandler errorHandler() {
		return new CacheErrorHandler() {

			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
				logger.warn("handleCacheGetError in redis: {}", exception.getMessage());
			}

			@Override
			public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
				logger.warn("handleCachePutError in redis: {}", exception.getMessage());
			}

			@Override
			public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
				logger.warn("handleCacheEvictError in redis: {}", exception.getMessage());
			}

			@Override
			public void handleCacheClearError(RuntimeException exception, Cache cache) {
				logger.warn("handleCacheClearError in redis: {}", exception.getMessage());
			}
		};
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public List<String> getCacheNames() {
		return cacheNames;
	}

	public void setCacheNames(List<String> cacheNames) {
		this.cacheNames = cacheNames;
	}

}