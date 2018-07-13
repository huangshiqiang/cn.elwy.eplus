package cn.elwy.eplus.framework.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Description:
 * 告诉shiro如何验证加密密码，通过SimpleCredentialsMatcher或HashedCredentialsMatcher
 * @Author: wjl
 * @Create Date: 2017-3-14
 */
public class CustomCredentialsMatcher extends HashedCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		/*-
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object credentials = getCredentials(info);
		String password = String.valueOf(token.getPassword());
		// 自定义加密 
			return equals(	EncodeUtil.encryptSHA(password), credentials);
		*/
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return super.doCredentialsMatch(authcToken, info);
	}

	public static void main(String[] args) {
		String hashAlgorithmName = "SHA-256";
		String password = "fa";
		int hashIterations = 1024;
		ByteSource credentialsSalt = ByteSource.Util.bytes("fa");
		Object obj = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations);
		System.out.println(obj);
	}

}