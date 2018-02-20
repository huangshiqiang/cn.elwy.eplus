// package cn.elwy.eplus.framework.config;
//
// import java.lang.reflect.Method;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.cache.Cache;
// import org.springframework.cache.CacheManager;
// import org.springframework.cache.annotation.CachingConfigurerSupport;
// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.cache.interceptor.CacheErrorHandler;
// import org.springframework.cache.interceptor.KeyGenerator;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.cache.RedisCacheManager;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
//
/// **
// * Created by yangyibo on 17/1/16.
// */
// @Configuration
// @EnableCaching
// public class RedisConfig extends CachingConfigurerSupport {
// private static final Logger logger =
// LoggerFactory.getLogger(RedisConfig.class);
//
// @Bean
// public KeyGenerator keyGenerator() {
// return new KeyGenerator() {
// @Override
// public Object generate(Object target, Method method, Object... params) {
// StringBuilder sb = new StringBuilder();
// sb.append(target.getClass().getName());
// sb.append(method.getName());
// for (Object obj : params) {
// sb.append(obj.toString());
// }
// return sb.toString();
// }
// };
// }
//
// @Bean
// public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
// RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
// // 设置缓存过期时间
// // cacheManager.setDefaultExpiration(60);//秒
// return cacheManager;
// }
//
// @Bean
// public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory
// factory) {
// RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String,
// Object>();
// redisTemplate.setConnectionFactory(factory);
// return redisTemplate;
// // StringRedisTemplate template = new StringRedisTemplate(factory);
// // Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
// Jackson2JsonRedisSerializer(Object.class);
// // ObjectMapper om = new ObjectMapper();
// // om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
// // om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
// // jackson2JsonRedisSerializer.setObjectMapper(om);
// // template.setValueSerializer(jackson2JsonRedisSerializer);
// // template.afterPropertiesSet();
// // return template;
// }
//
//// @Autowired
//// private Environment env;
////
//// @Bean
//// public JedisConnectionFactory redisConnectionFactory() {
//// JedisConnectionFactory redisConnectionFactory = new
// JedisConnectionFactory();
//// redisConnectionFactory.setHostName(env.getProperty("redis.hostname"));
//// redisConnectionFactory.setPort(Integer.parseInt(env.getProperty("redis.port")));
//// return redisConnectionFactory;
//// }
//
// public CacheErrorHandler errorHandler() {
// return new CacheErrorHandler() {
//
// @Override
// public void handleCacheGetError(RuntimeException exception, Cache cache,
// Object key) {
// logger.warn("handleCacheGetError in redis: {}", exception.getMessage());
// }
//
// @Override
// public void handleCachePutError(RuntimeException exception, Cache cache,
// Object key, Object value) {
// logger.warn("handleCachePutError in redis: {}", exception.getMessage());
// }
//
// @Override
// public void handleCacheEvictError(RuntimeException exception, Cache cache,
// Object key) {
// logger.warn("handleCacheEvictError in redis: {}", exception.getMessage());
// }
//
// @Override
// public void handleCacheClearError(RuntimeException exception, Cache cache) {
// logger.warn("handleCacheClearError in redis: {}", exception.getMessage());
// }
// };
// }
// }
