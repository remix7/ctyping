package top.cynara.ctyping.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.cynara.ctyping.entitiy.ActiveUser;

/**
 * @ClassName HomePage
 * @Description 后台首页
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午9:33:33
 * @version V1.0
 */
@Controller
public class HomePage {
	private Logger log = Logger.getLogger(HomePage.class);

	/**
	 * @Title index
	 * @Description 将认证通过的用户信息 放入到作用域中
	 * @param model
	 *            此处作用和map相同
	 * @return 返回真正的index首页
	 * @throws Exception
	 * @author Cynara-remix
	 * @Date 2016年10月10日 下午5:24:31
	 */
	@RequestMapping("/admin/home")
	public String home(HttpSession session) throws Exception {
		// // 从shiro的session中取出activeUser
		// Subject subject = SecurityUtils.getSubject();
		// // 取出身份信息
		// ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// session.setAttribute("activeUser", activeUser);
		// log.debug(activeUser.getUsername() + ":登录成功！");
		return "home";
	}
}
