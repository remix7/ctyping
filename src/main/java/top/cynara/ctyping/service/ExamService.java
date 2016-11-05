package top.cynara.ctyping.service;

import java.util.List;

import top.cynara.ctyping.entitiy.Exam;

/**
 * @ClassName ExamService
 * @Description 测试操作
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午5:58:34
 * @version V1.0
 */
public interface ExamService {
	void insert(Exam exam);

	void delete(Integer id);

	void update(Exam exam);

	Exam findById(Integer id);

	List<Exam> findAll();

	List<Exam> findAllTest();

	List<Exam> findAllExam();
}
