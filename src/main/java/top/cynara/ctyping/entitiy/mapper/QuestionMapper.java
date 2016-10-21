package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import top.cynara.ctyping.entitiy.Question;

/**
 * @ClassName QuestionMapper
 * @Description 题库
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午8:49:01
 * @version V1.0
 */
public interface QuestionMapper {
	void insert(Question question);

	void delete(Integer id);

	void update(Question question);

	Question findById(Integer id);

	List<Question> findAll();
}
