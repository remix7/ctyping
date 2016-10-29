package top.cynara.ctyping.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName CaptchaAuthenticationToken
 * @Description 自定义密码比对其
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月27日 下午2:20:39
 * @version V1.0
 */
public class CaptchaAuthenticationToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 1L;

	private String captcha;
	private String loginType;

	public CaptchaAuthenticationToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
