package top.cynara.ctyping.controller;

import java.util.Collection;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SessionController
 * @Description 查看在线人数和详细信息
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月30日 下午1:03:30
 * @version V1.0
 */
@Controller
public class SessionController {

	@Autowired
	private SessionDAO sessionDAO;

	/**
	 * @Title list 
	 * @Description 获取所有在线用户
	 * @param map
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:45:14
	 */
	@RequiresRoles("admin")
	@RequestMapping("/sessions")
	public String list(Map<String, Object> map) {
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		map.put("sessions", sessions);
		return "sessionlist";
	}
	/**
	 * @Title reject 
	 * @Description 根据sessionid 来剔除在线用户
	 * @param sid
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:44:53
	 */
	@RequiresRoles("admin")
	@RequestMapping("/reject/{sid}")
	public String reject(@PathVariable("sid")String sid){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for (Session session : sessions) {
			if(session.getId().equals(sid)){
				session.setTimeout(0);
				break;
			}
		}
		return "redirect:/sessions";
	}

}
