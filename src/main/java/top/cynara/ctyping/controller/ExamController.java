package top.cynara.ctyping.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import top.cynara.ctyping.entitiy.ActiveUser;
import top.cynara.ctyping.entitiy.Exam;
import top.cynara.ctyping.entitiy.ExamRecode;
import top.cynara.ctyping.entitiy.Question;
import top.cynara.ctyping.entitiy.Score;
import top.cynara.ctyping.entitiy.User;
import top.cynara.ctyping.service.ExamRecodeService;
import top.cynara.ctyping.service.ExamService;
import top.cynara.ctyping.service.QuestionService;
import top.cynara.ctyping.service.ScoreService;

/**
 * @ClassName ExamController
 * @Description 测试相关控制器
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月22日 下午9:59:53
 * @version V1.0
 */
@Controller
public class ExamController {
	private Logger log = Logger.getLogger(ExamController.class);
	@Autowired
	private ExamService examService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ExamRecodeService recodeService;
	@Autowired
	private ScoreService scoreService;
	/**
	 * @Title examsubmit 
	 * @Description 用户提交 将成绩持久化 并且将对应的记录设置为不能修改
	 * @param request
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年11月5日 下午9:28:06
	 */
	@RequestMapping(value="/customer/examsubmit",method=RequestMethod.POST)
	public String examsubmit(HttpServletRequest request) {
		System.out.println("123");
		String content = request.getParameter("typetext");
		String useTime = request.getParameter("time");
		String userid = request.getParameter("userid");
		String examid = request.getParameter("examid");
		String oid = request.getParameter("oid");
		String errorcount = request.getParameter("er");
		String score = request.getParameter("score");
		String accuracy = request.getParameter("accuracy");
		if (userid == null || "".equals(userid)) {
			// 打字练习 成绩不记录
		} else {
			Score _score = new Score();
			_score.setAccuracy(accuracy);
			_score.setContent(content);
			_score.setCreateTime(new Date().toLocaleString());
			Exam exam = new Exam();
			exam.setId(Integer.parseInt(examid));
			_score.setExam(exam);
			_score.setRemarks(errorcount);
			_score.setScore(score);
			_score.setState("1");
			User user = new User();
			user.setId(Integer.parseInt(userid));
			_score.setUser(user);
			_score.setUseTime(useTime);
			scoreService.insert(_score);
			// 提交后讲记录设置为不可重复编辑
			ExamRecode recode = recodeService.findById(Integer.parseInt(oid));
			recode.setState("2");
			recodeService.update(recode);
		}
		return "customer/submit";

	}

	/**
	 * @Title contyping
	 * @Description 前台 记录回显
	 * @param uid
	 * @param udt
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:58:22
	 */
	@RequestMapping(value="/customer/contyping",method=RequestMethod.POST)
	public String contyping(@RequestParam("uid") Integer uid, @RequestParam("udt") String udt,
			Map<String, Object> map) {
		ExamRecode recode = recodeService.findByUidAndUdt(uid, udt);
		if (recode.getState().equals("2")) {
			return "customer/submit";
		}
		Exam exam = examService.findById(recode.getExam().getId());
		if (exam != null) {
			Question question = questionService.findById(exam.getQuestion().getId());
			map.put("question", question);
			map.put("exam", exam);
			map.put("recode", recode);
			map.put("oid", recode.getId());
		}
		return "customer/typing";

	}

	/**
	 * @Title typingexam
	 * @Description 前台 考试列表页面
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:56:28
	 */
	@RequestMapping("/customer/typingexam")
	public String typingexam(Map<String, Object> map) {
		List<Exam> eList = examService.findAllExam();
		map.put("eList", eList);
		return "customer/typingexam";
	}

	/**
	 * @Title typing
	 * @Description 前台 初始化数据转向练习页面
	 * @param id
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:55:03
	 */
	@RequestMapping("/customer/typing")
	public String typing(@RequestParam("id") Integer id, Map<String, Object> map) {
		Exam exam = examService.findById(id);
		if (exam != null) {
			Question question = questionService.findById(exam.getQuestion().getId());
			map.put("question", question);
			map.put("exam", exam);
			ExamRecode recode = new ExamRecode();
			recode.setExam(exam);
			recode.setUseTime("0");
			recodeService.insert(recode);
			map.put("oid", recode.getId());
		}
		return "customer/typing";

	}

	/**
	 * @Title typingTest
	 * @Description 前台 全部练习
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:54:32
	 */
	@RequestMapping("/customer/typingtest")
	public String typingTest(Map<String, Object> map) {
		List<Exam> eList = examService.findAllTest();
		map.put("eList", eList);
		return "customer/typingtest";
	}

	/**
	 * @Title delete
	 * @Description 删除已有的测试 需要exam:delete 权限
	 * @param id
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:54:08
	 */
	@RequiresPermissions("exam:delete")
	@RequestMapping(value = "/exam/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		examService.delete(id);
		return "redirect:/examList";
	}

	/**
	 * @Title add
	 * @Description 添加测试 需要 exam:insert权限
	 * @param exam
	 * @param result
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:53:13
	 */
	@RequiresPermissions("exam:insert")
	@RequestMapping(value = "/exam", method = RequestMethod.POST)
	public String add(@Valid Exam exam, BindingResult result, Map<String, Object> map) {
		if (result.getAllErrors().size() != 0) {
			for (FieldError error : result.getFieldErrors()) {
				log.debug(error.getField() + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			List<Question> qList = questionService.findAll();
			map.put("qList", qList);
			map.put("exam", exam);
			return "examUpdate";
		}
		Exam e = new Exam();
		e.setBeginTime(exam.getBeginTime());
		e.setCreateTime(new Date().toLocaleString());
		e.setEndTime(exam.getEndTime());
		e.setName(exam.getName());
		e.setQuestion(exam.getQuestion());
		e.setRemarks(exam.getRemarks());
		e.setState(exam.getState());
		examService.insert(e);
		return "redirect:/examList";

	}

	/**
	 * @Title addUi
	 * @Description 转到添加测试页面
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:52:54
	 */
	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public String addUi(Map<String, Object> map) {
		List<Question> qList = questionService.findAll();
		map.put("qList", qList);
		return "examUpdate";

	}

	/**
	 * @Title update
	 * @Description 更新已有测试的内容
	 * @param id
	 * @param exam
	 * @param result
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:25:56
	 */
	@RequiresPermissions("exam:update")
	@RequestMapping(value = "/exam/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Integer id, @Valid Exam exam, BindingResult result,
			Map<String, Object> map) {
		if (result.getAllErrors().size() != 0) {
			for (FieldError error : result.getFieldErrors()) {
				log.debug(error.getField() + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			List<Question> qList = questionService.findAll();
			map.put("qList", qList);
			map.put("exam", exam);
			return "examUpdate";
		}
		Exam e = examService.findById(id);
		e.setBeginTime(exam.getBeginTime());
		e.setEndTime(exam.getEndTime());
		e.setName(exam.getName());
		e.setQuestion(exam.getQuestion());
		e.setRemarks(exam.getRemarks());
		e.setState(exam.getState());
		examService.update(e);
		return "redirect:/examList";
	}

	/**
	 * @Title updateUi
	 * @Description 获取更新指定id的测试页面
	 * @param id
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:23:50
	 */
	@RequestMapping(value = "/exam/{id}", method = RequestMethod.GET)
	public String updateUi(@PathVariable("id") Integer id, Map<String, Object> map) {
		Exam exam = examService.findById(id);
		map.put("exam", exam);
		List<Question> qList = questionService.findAll();
		map.put("qList", qList);
		return "examUpdate";
	}

	/**
	 * @Title ExamList
	 * @Description 测试列表 需要exam:list 权限
	 * @param map
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年11月4日 下午3:23:14
	 */
	@RequiresPermissions("exam:list")
	@RequestMapping("/examList")
	public String ExamList(Map<String, Object> map) {
		List<Exam> eList = examService.findAll();
		map.put("eList", eList);
		return "examlist";

	}
}
