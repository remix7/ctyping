package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import top.cynara.ctyping.entitiy.Exam;

/**
 * @ClassName ExamMapper
 * @Description 测试操作接口
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午5:56:37
 * @version V1.0
 */
public interface ExamMapper {
	void insert(Exam exam);

	void delete(Integer id);

	void update(Exam exam);

	Exam findById(Integer id);

	List<Exam> findAll();
}
