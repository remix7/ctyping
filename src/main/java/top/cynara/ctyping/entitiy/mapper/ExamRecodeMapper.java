package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import top.cynara.ctyping.entitiy.Exam;
import top.cynara.ctyping.entitiy.ExamRecode;

/**
 * @ClassName ExamRecodeMapper
 * @Description 测试记录
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午8:24:28
 * @version V1.0
 */
public interface ExamRecodeMapper {
	int insert(ExamRecode examRecode);

	void delete(Integer id);

	void update(ExamRecode examRecode);

	ExamRecode findById(Integer id);

	List<ExamRecode> findAll();
	
	List<ExamRecode> findByUserId(Integer id);
	
	ExamRecode findByUidAndUdt(Integer uid,String udt);
}
