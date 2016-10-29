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
	
	@RequestMapping("/customer/recorde")
	public String customerrecord(HttpSession session,Map<String, Object> map){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		List<ExamRecode> erList = recodeService.findByUserId(user.getId());
		map.put("erList", erList);
		return "customer/recorde";
		
	}
	
	
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
		ExamRecode oldRecode = recodeService.findById(recode.getId());
		User user = null;
		Exam exam = null;
		try {
			user = userService.findById(recode.getUser().getId());
			exam = examService.findById(recode.getExam().getId());
		} catch (Exception e) {
			response.getOutputStream().write("error".getBytes());
		}
		// 如果这个用户不存在就直接return
		if (user == null) {
			return;
		}
		// 能走到这说明用户存在
		if (oldRecode == null) {
			oldRecode = new ExamRecode();
			oldRecode.setAccuracy(recode.getAccuracy());
			oldRecode.setContent(new String(recode.getContent().getBytes("ISO-8859-1"),"UTF-8"));
			oldRecode.setExam(exam);
			oldRecode.setRemarks("-");
			oldRecode.setScore(recode.getScore());
			oldRecode.setState("1");
			oldRecode.setUpdateTime(new Date().toLocaleString());
			oldRecode.setUser(user);
			oldRecode.setUseTime(recode.getUseTime());
			recodeService.insert(oldRecode);
		} else {
			oldRecode.setAccuracy(recode.getAccuracy());
			oldRecode.setContent(new String(recode.getContent().getBytes("ISO-8859-1"),"UTF-8"));
			oldRecode.setExam(exam);
			oldRecode.setRemarks(recode.getRemarks());
			oldRecode.setScore(recode.getScore());
			oldRecode.setState(recode.getState());
			oldRecode.setUpdateTime(new Date().toLocaleString());
			oldRecode.setUser(user);
			oldRecode.setUseTime(recode.getUseTime());
			recodeService.update(oldRecode);
		}
		//成功
		response.getOutputStream().write("ok".getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
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

	@RequestMapping("/recode")
	public String recode() {
		return "recode";
	}

	@RequestMapping(value = "/recode/{id}", method = RequestMethod.DELETE)
	public String delte(@PathVariable("id") Integer id) {
		recodeService.delete(id);
		return "redirect:/recodeList";

	}
	@RequiresPermissions("recode:list")
	@RequestMapping("/recodeList")
	public String recodeList(Map<String, Object> map) {
		List<ExamRecode> erList = recodeService.findAll();
		map.put("erList", erList);
		return "recodelist";
	}
}
