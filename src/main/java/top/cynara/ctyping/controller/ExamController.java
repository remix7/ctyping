package top.cynara.ctyping.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import top.cynara.ctyping.entitiy.Exam;
import top.cynara.ctyping.entitiy.Question;
import top.cynara.ctyping.service.ExamService;
import top.cynara.ctyping.service.QuestionService;

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

	
	@RequestMapping("/customer/typingexam")
	public String typingexam(){
		
		return "customer/typingexam";
	}
	
	@RequestMapping("/customer/typingtest")
	public String typingTest(Map<String, Object> map) {
		List<Exam> eList = examService.findAll();
		map.put("eList", eList);
		return "customer/typingtest";
	}

	@RequiresPermissions("exam:delete")
	@RequestMapping(value = "/exam/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		examService.delete(id);
		return "redirect:/examList";
	}

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

	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public String addUi(Map<String, Object> map) {
		List<Question> qList = questionService.findAll();
		map.put("qList", qList);
		return "examUpdate";

	}

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

	@RequestMapping(value = "/exam/{id}", method = RequestMethod.GET)
	public String updateUi(@PathVariable("id") Integer id, Map<String, Object> map) {
		Exam exam = examService.findById(id);
		map.put("exam", exam);
		List<Question> qList = questionService.findAll();
		map.put("qList", qList);
		return "examUpdate";
	}

	@RequiresPermissions("exam:list")
	@RequestMapping("/examList")
	public String ExamList(Map<String, Object> map) {
		List<Exam> eList = examService.findAll();
		map.put("eList", eList);
		return "examlist";

	}
}
