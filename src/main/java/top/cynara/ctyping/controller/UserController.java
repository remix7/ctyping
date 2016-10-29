package top.cynara.ctyping.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.cynara.ctyping.entitiy.ActiveUser;
import top.cynara.ctyping.entitiy.User;
import top.cynara.ctyping.service.UserService;
import top.cynara.ctyping.utils.HashUtil;

/**
 * @ClassName UserController
 * @Description 用户相关控制器
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月22日 下午5:27:04
 * @version V1.0
 */
@Controller
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	
	@RequestMapping("/customer/info")
	public String info(Map<String, Object> map,HttpSession session){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		User realUser = userService.findById(user.getId());
		map.put("user", realUser);
		return "customer/userinfo";
	}
	
	/**
	 * @Title register
	 * @Description 用户注册
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月28日 下午8:36:02
	 */
	@RequestMapping(value = "/customer/register", method = RequestMethod.POST)
	public String register(User user, HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		String randomcode = request.getParameter("randomcode");
		String validateCode = (String) session.getAttribute("validateCode");
		if (randomcode == null || "".equals(randomcode) || !validateCode.equals(randomcode)) {
			map.put("randomcode", "*验证码错误!");
			map.put("user", user);
			return "customer/register";
		}
		User oldUser = userService.findByUserName(user.getUsername());
		if (oldUser != null) {
			map.put("error", "*用户已经存在");
			user.setUsername("");
			map.put("user", user);
			return "customer/register";
		}
		user.setCreateTime(new Date().toLocaleString());
		user.setPassword(HashUtil.getMd5Hash(user.getPassword(), user.getUsername()));
		user.setRemarks("-");
		user.setState("1");
		userService.insert(user);
		return "redirect:/";

	}
	/**
	 * @Title registerUI 
	 * @Description 转向用户注册页面 若用户已经登录 将用户剔除登录
	 * @param session
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月28日 下午11:34:44
	 */
	@RequestMapping(value = "/customer/register")
	public String registerUI(HttpSession session) {
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		if (user != null) {
			session.removeAttribute("activeUser");
		}
		return "customer/register";

	}
	/**
	 * @Title delete 
	 * @Description 管理员删除用户
	 * @param id
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月28日 下午11:35:35
	 */
	@RequiresPermissions("user:delete")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		return "redirect:/userList";

	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public String update(@Valid User user, BindingResult result, Map<String, Object> map,
			@PathVariable("id") Integer id) {
		// 判断是否有错误
		if (result.getAllErrors().size() != 0) {
			for (FieldError error : result.getFieldErrors()) {
				log.debug(error.getField() + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			map.put("user", user);
			return "userUpdate";
		}
		User oUser = userService.findById(id);
		oUser.setEmail(user.getEmail());
		oUser.setPassword(HashUtil.getMd5Hash(user.getPassword(), user.getUsername()));
		oUser.setPhoneNum(user.getPhoneNum());
		oUser.setRealname(user.getRealname());
		oUser.setState(user.getState());
		oUser.setStuNum(user.getStuNum());
		oUser.setUsername(user.getUsername());
		userService.update(oUser);
		return "redirect:/userList";

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String updateUi(@PathVariable("id") Integer id, Map<String, Object> map) {
		User user = userService.findById(id);
		map.put("user", user);
		return "userUpdate";
	}

	@RequiresPermissions("user:list")
	@RequestMapping("/userList")
	public String userList(Map<String, Object> map) {
		List<User> ulist = userService.findAll();
		ulist.remove(0);
		map.put("ulist", ulist);
		return "userlist";

	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpSession session) throws Exception {
		// 如果登录失败 从request中获取认证信息shiroLoginFailure 就是异常类的全类名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		log.debug("用户认证出现错误：" + exceptionClassName);
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				log.debug("用户认证错误：账号不存在!");
				request.setAttribute("errorMessage", "账号不存在!");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				log.debug("用户认证错误：密码错误!");
				request.setAttribute("errorMessage", "密码错误!");
			} else if ("randomcodeError".equals(exceptionClassName)) {
				log.debug("用户认证错误：验证码错误!");
				request.setAttribute("errorMessage", "验证码错误!");
			} else {
				log.debug("用户认证错误：未知错误!");
				request.setAttribute("errorMessage", "未知错误!");
			}
		}
		// 此方法不处理登录成功 shiro认证成功会自动跳转到上一个请求路径
		// 认证失败转向login
		return "login";
	}
}
