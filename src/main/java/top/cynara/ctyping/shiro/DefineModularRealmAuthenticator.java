package top.cynara.ctyping.shiro;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

import top.cynara.ctyping.exception.CtypingException;

/**
 * @ClassName DefineModularRealmAuthenticator
 * @Description 自定义realm验证规则 只要验证匹配就直接返回
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月27日 下午1:56:21
 * @version V1.0
 */
public class DefineModularRealmAuthenticator extends ModularRealmAuthenticator {
	private Logger log = Logger.getLogger(DefineModularRealmAuthenticator.class);
	/**
	 * 将realm坐为map 上传 只要便于分清前台和后台
	 */
	private Map<String, Object> defineRealms;

	/**
	 * 调用单个Realm 进行验证
	 */
	@Override
	protected AuthenticationInfo doSingleRealmAuthentication(Realm realm, AuthenticationToken token) {
		if (!realm.supports(token)) {
			String msg = "Realm [" + realm + "] does not support authentication token [" + token
					+ "].  Please ensure that the appropriate Realm implementation is "
					+ "configured correctly or that the realm accepts AuthenticationTokens of this type.";
			throw new UnsupportedTokenException(msg);
		}
		AuthenticationInfo info = null;
		try {
			info = realm.getAuthenticationInfo(token);
			if (info == null) {
				String msg = "Realm [" + realm + "] was unable to find account data for the "
						+ "submitted AuthenticationToken [" + token + "].";
				throw new UnknownAccountException(msg);
			}
		} catch (CtypingException e) {
			throw e;
		} catch (IncorrectCredentialsException e) {
			throw e;
		} catch (UnknownAccountException e) {
			throw e;
		} catch (Throwable throwable) {
			if (log.isDebugEnabled()) {
				String msg = "Realm [" + realm + "] threw an exception during a multi-realm authentication attempt:";
				log.debug(msg, throwable);
			}
		}
		return info;
	}
	/**
	 * 判断realm 是不是null
	 */
	@Override
	protected void assertRealmsConfigured() throws IllegalStateException {
		defineRealms = getDefineRealms();
		if (CollectionUtils.isEmpty(defineRealms)) {  
            String msg = "Configuration error:  No realms have been configured!  One or more realms must be "  
                    + "present to execute an authentication attempt.";  
            throw new IllegalStateException(msg);  
        }  
	}
	/**
	 * 这个方法比较重要  用来判断此次调用的前台和后台
	 */
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		assertRealmsConfigured();
		CaptchaAuthenticationToken token = (CaptchaAuthenticationToken)authenticationToken;
		Realm realm = null;
		//前端登录
		if(StringUtils.equals(token.getLoginType(), LoginEnum.CUSTOMER.toString())){
			realm = (Realm) defineRealms.get("customerRealm");
		}
		//后台登陆
		if(StringUtils.equals(token.getLoginType(), LoginEnum.ADMIN.toString())){
			realm = (Realm) defineRealms.get("userRealm");
		}
		if(realm == null){
			return null;
		}
		return doSingleRealmAuthentication(realm, authenticationToken);
	}
	
	
	public Map<String, Object> getDefineRealms() {
		return defineRealms;
	}
	public void setDefineRealms(Map<String, Object> defineRealms) {
		this.defineRealms = defineRealms;
	}
	
}
