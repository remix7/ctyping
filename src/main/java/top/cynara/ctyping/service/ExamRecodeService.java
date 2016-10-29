package top.cynara.ctyping.service;

import java.util.List;

import top.cynara.ctyping.entitiy.ExamRecode;
/**
 * @ClassName ExamRecodeService 
 * @Description 测试记录服务接口
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月21日 下午8:26:07 
 * @version V1.0
 */
public interface ExamRecodeService {
	void insert(ExamRecode examRecode);

	void delete(Integer id);

	void update(ExamRecode examRecode);

	ExamRecode findById(Integer id);

	List<ExamRecode> findAll();
	
	List<ExamRecode> findByUserId(Integer id);
}
