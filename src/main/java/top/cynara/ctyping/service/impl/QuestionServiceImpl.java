package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import top.cynara.ctyping.entitiy.Question;
import top.cynara.ctyping.entitiy.mapper.QuestionMapper;
import top.cynara.ctyping.service.QuestionService;
/**
 * @ClassName QuestionServiceImpl 
 * @Description 题库服务接口实现
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月21日 下午8:52:36 
 * @version V1.0
 */
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionMapper mapper;
	
	public void insert(Question question) {
		mapper.insert(question);
	}

	public void delete(Integer id) {
		mapper.delete(id);
	}

	public void update(Question question) {
		mapper.update(question);
	}

	public Question findById(Integer id) {
		return mapper.findById(id);
	}

	public List<Question> findAll() {
		return mapper.findAll();
	}

}
