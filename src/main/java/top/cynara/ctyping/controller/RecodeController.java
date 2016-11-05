package top.cynara.ctyping.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import top.cynara.ctyping.entitiy.ActiveUser;
import top.cynara.ctyping.entitiy.Exam;
import top.cynara.ctyping.entitiy.ExamRecode;
import top.cynara.ctyping.entitiy.User;
import top.cynara.ctyping.service.ExamRecodeService;
import top.cynara.ctyping.service.ExamService;
import top.cynara.ctyping.service.UserService;

/**
 * @ClassName RecodeController
 * @Description 测试记录控制器
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月23日 下午5:08:48
 * @version V1.0
 */
@Controller
public class RecodeController {
	private Logger log = Logger.getLogger(RecodeController.class);
	@Autowired
	private ExamRecodeService recodeService;
	@Autowired
	private UserService userService;
	@Autowired
	private ExamService examService;

	/**
	 * @Title customerrecord
	 * @Description 查询当前用户的做题记录
	 * @param session
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:36:41
	 */
	@RequestMapping("/customer/recorde")
	public String customerrecord(HttpSession session, Map<String, Object> map) {
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		List<ExamRecode> erList = recodeService.findByUserId(user.getId());
		map.put("erList", erList);
		return "customer/recorde";

	}

	/**
	 * @Title ajaxPut
	 * @Description 后台接收 练习或者测试中发来的记录 并处理
	 * @param recode
	 * @param response
	 * @throws Exception
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:30:52
	 */
	@ResponseBody
	@RequestMapping("/ajaxput")
	public void ajaxPut(ExamRecode recode, HttpServletResponse response) throws Exception {
		// 设置相应头
		response.setCharacterEncoding("UTF-8");
		// 设置无缓存
		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		System.out.println(recode.getId());
		// ExamRecode oldRecode = recodeService.findById(recode.getId());
		User user = null;
		Exam exam = null;
		try {
			user = userService.findById(recode.getUser().getId());
			exam = examService.findById(recode.getExam().getId());
		} catch (Exception e) {
			response.getOutputStream().write("error".getBytes());
		}
		recode.setAccuracy(recode.getAccuracy());
		recode.setContent(new String(recode.getContent().getBytes("ISO-8859-1"), "UTF-8"));
		recode.setExam(exam);
		recode.setUpdateTime(new Date().toLocaleString());
		recode.setUser(user);
		recode.setState("1");
		if (exam.getState().equals("1")) {
			recode.setRemarks("打字练习");
		} else {
			recode.setRemarks("考试考试");
		}

		recodeService.update(recode);
		response.getOutputStream().write("ok".getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * @Title realRecode
	 * @Description 后台 查看实时记录
	 * @param response
	 * @throws IOException
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:14:30
	 */
	@ResponseBody
	@RequestMapping(value = "/realRecode", produces = "application/json; charset=utf-8")
	public void realRecode(HttpServletResponse response) throws IOException {
		List<ExamRecode> erList = recodeService.findAll();
		JSONArray ja = JSONArray.fromObject(erList);
		// 设置相应头
		response.setCharacterEncoding("UTF-8");
		// 设置无缓存
		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		OutputStream out = response.getOutputStream();
		out.write(ja.toString().getBytes());
		out.flush();
	}

	/**
	 * @Title recode
	 * @Description 后台 转向实时记录页面
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:14:10
	 */
	@RequestMapping("/recode")
	public String recode() {
		return "recode";
	}

	/**
	 * @Title delte
	 * @Description 后台 删除记录 需要权限 recode:delete
	 * @param id
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:12:34
	 */
	@RequiresPermissions("recode:delete")
	@RequestMapping(value = "/recode/{id}", method = RequestMethod.DELETE)
	public String delte(@PathVariable("id") Integer id) {
		recodeService.delete(id);
		return "redirect:/recodeList";

	}

	/**
	 * @Title recodeList
	 * @Description 后台 查看所有记录 需要权限 recode:list
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午4:10:43
	 */
	@RequiresPermissions("recode:list")
	@RequestMapping("/recodeList")
	public String recodeList(Map<String, Object> map) {
		List<ExamRecode> erList = recodeService.findAll();
		map.put("erList", erList);
		return "recodelist";
	}
}
