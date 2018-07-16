package cn.elwy.eplus.framework.security.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * Description:
 * 告诉shiro如何验证加密密码，通过SimpleCredentialsMatcher或HashedCredentialsMatcher
 * @Author: wjl
 * @Create Date: 2017-3-14
 */
public class CustomCredentialsMatcher extends HashedCredentialsMatcher {

	private static final String hashAlgorithm = "SHA-256";
	private static final int hashIterations = 1024;
	private static final boolean storedCredentialsHexEncoded = true;

	private Ehcache passwordRetryCache;

	public CustomCredentialsMatcher() {
		this(hashAlgorithm, hashIterations, storedCredentialsHexEncoded);
	}

	public CustomCredentialsMatcher(String hashAlgorithm, int hashIterations, boolean storedCredentialsHexEncoded) {
		this.setHashAlgorithmName(hashAlgorithm);
		this.setHashIterations(hashIterations);
		// storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
		this.setStoredCredentialsHexEncoded(storedCredentialsHexEncoded);
		// CacheManager cacheManager =
		// CacheManager.create(CacheManager.class.getClassLoader().getResource("ehcache.xml"));
		// passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		String username = (String) authcToken.getPrincipal();
		if (passwordRetryCache != null) {
			Element element = passwordRetryCache.get(username);
			if (element == null) {
				element = new Element(username, new AtomicInteger(0));
				passwordRetryCache.put(element);
			}
			AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
			if (retryCount.incrementAndGet() > 5) {
				throw new ExcessiveAttemptsException();
			}
		}
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		boolean matches = super.doCredentialsMatch(authcToken, info);
		if (matches) {
			if (passwordRetryCache != null) {
				passwordRetryCache.remove(username);
			}
		}
		/*-
		// 自定义加密 
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object credentials = getCredentials(info);
		String password = String.valueOf(token.getPassword());
		matches = equals(	EncodeUtil.encryptSHA(password), credentials);
		*/
		return matches;
	}

	public Ehcache getPasswordRetryCache() {
		return passwordRetryCache;
	}

	public void setPasswordRetryCache(Ehcache passwordRetryCache) {
		this.passwordRetryCache = passwordRetryCache;
	}

	public static void main(String[] args) {
		String password = "fa";
		ByteSource credentialsSalt = ByteSource.Util.bytes("fa");
		CustomCredentialsMatcher ccm = new CustomCredentialsMatcher();
		Object obj = new SimpleHash(ccm.getHashAlgorithmName(), password, credentialsSalt, ccm.getHashIterations());
		System.out.println(obj);
	}

}