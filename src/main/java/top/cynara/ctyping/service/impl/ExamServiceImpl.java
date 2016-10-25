package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.ctyping.entitiy.Exam;
import top.cynara.ctyping.entitiy.mapper.ExamMapper;
import top.cynara.ctyping.service.ExamService;
/**
 * @ClassName ExamServiceImpl 
 * @Description service 接口实现类
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月21日 下午5:59:12 
 * @version V1.0
 */
@Service("ExamService")
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper mapper;
	
	public void insert(Exam exam) {
		mapper.insert(exam);
	}

	public void delete(Integer id) {
		mapper.delete(id);
	}

	public void update(Exam exam) {
		mapper.update(exam);
	}

	public Exam findById(Integer id) {
		return mapper.findById(id);
	}

	public List<Exam> findAll() {
		return mapper.findAll();
	}

}
