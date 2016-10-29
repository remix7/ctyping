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

import top.cynara.ctyping.entitiy.Question;
import top.cynara.ctyping.service.QuestionService;

/**
 * @ClassName QuestionController
 * @Description 试题相关控制器
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月22日 下午5:26:50
 * @version V1.0
 */
@Controller
public class QuestionController {
	private Logger log = Logger.getLogger(QuestionController.class);
	@Autowired
	private QuestionService questionService;

	@RequiresPermissions("question:delete")
	@RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		questionService.delete(id);
		return "redirect:/questionList";
	}

	@RequiresPermissions("question:insert")
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public String save(@Valid Question question, BindingResult result, Map<String, Object> map) {
		if (result.getAllErrors().size() != 0) {
			for (FieldError error : result.getFieldErrors()) {
				log.debug(error.getField() + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			map.put("question", question);
			return "questionUpdate";
		}
		question.setContentLength(question.getContent().length() + "");
		question.setCreateTime(new Date().toLocaleString());
		questionService.insert(question);
		return "redirect:/questionList";
	}

	@RequestMapping("/question")
	public String saveUi() {
		return "questionUpdate";

	}
	@RequiresPermissions("question:update")
	@RequestMapping(value = "/question/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Integer id, @Valid Question question, BindingResult result,
			Map<String, Object> map) {
		if (result.getAllErrors().size() != 0) {
			for (FieldError error : result.getFieldErrors()) {
				log.debug(error.getField() + error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			map.put("question", question);
			return "questionUpdate";
		}
		Question q = questionService.findById(id);
		q.setContent(question.getContent());
		q.setContentLength(question.getContent().length() + "");
		q.setDegree(question.getDegree());
		q.setRemarks(question.getRemarks());
		q.setState(question.getState());
		q.setTitle(question.getTitle());
		questionService.update(q);
		return "redirect:/questionList";
	}

	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
	public String updateUi(@PathVariable("id") Integer id, Map<String, Object> map) {
		Question question = questionService.findById(id);
		map.put("question", question);
		return "questionUpdate";
	}
	@RequiresPermissions("question:list")
	@RequestMapping("/questionList")
	public String questionList(Map<String, Object> map) {
		List<Question> qList = questionService.findAll();
		map.put("qList", qList);
		return "questionlist";
	}
}
