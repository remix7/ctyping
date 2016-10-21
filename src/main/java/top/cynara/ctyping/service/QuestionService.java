package top.cynara.ctyping.service;

import java.util.List;

import top.cynara.ctyping.entitiy.Question;

/**
 * @ClassName QuestionService
 * @Description 题库服务接口
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午8:52:08
 * @version V1.0
 */
public interface QuestionService {

	void insert(Question question);

	void delete(Integer id);

	void update(Question question);

	Question findById(Integer id);

	List<Question> findAll();
}
