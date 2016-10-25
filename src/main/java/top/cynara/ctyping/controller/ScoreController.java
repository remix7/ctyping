package top.cynara.ctyping.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.cynara.ctyping.entitiy.Score;
import top.cynara.ctyping.service.ScoreService;
/**
 * @ClassName ScoreController 
 * @Description 分数相关控制器
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月24日 下午4:18:24 
 * @version V1.0
 */
@Controller
public class ScoreController {

	private Logger log = Logger.getLogger(ScoreController.class);

	@Autowired
	private ScoreService scoreService;

	@RequestMapping("/score")
	public String score(Map<String, Object> map) {
		List<Score> sList = scoreService.findAll();
		map.put("sList", sList);
		return "score";

	}
}
