package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.ctyping.entitiy.ExamRecode;
import top.cynara.ctyping.entitiy.mapper.ExamRecodeMapper;
import top.cynara.ctyping.service.ExamRecodeService;

/**
 * @ClassName ExamRecodeServiceImpl
 * @Description 测试记录接口实现
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午8:26:44
 * @version V1.0
 */
@Service("ExamRecodeService")
public class ExamRecodeServiceImpl implements ExamRecodeService {

	@Autowired
	private ExamRecodeMapper mapper;

	public void insert(ExamRecode examRecode) {
		mapper.insert(examRecode);
	}

	public void delete(Integer id) {
		mapper.delete(id);
	}

	public void update(ExamRecode examRecode) {
		mapper.update(examRecode);
	}

	public ExamRecode findById(Integer id) {
		return mapper.findById(id);
	}

	public List<ExamRecode> findAll() {
		return mapper.findAll();
	}

}
