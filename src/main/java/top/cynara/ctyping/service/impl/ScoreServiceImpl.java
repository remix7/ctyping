package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.ctyping.entitiy.Score;
import top.cynara.ctyping.entitiy.mapper.ScoreMapper;
import top.cynara.ctyping.service.ScoreService;

/**
 * @ClassName ScoreServiceImpl
 * @Description 实现service
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午4:47:29
 * @version V1.0
 */
@Service("ScoreService")
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper mapper;

	public void insert(Score score) {
		mapper.insert(score);
	}

	public void delete(Integer id) {
		mapper.delete(id);
	}

	public void update(Score score) {
		mapper.update(score);
	}

	public Score findById(Integer id) {
		return mapper.findById(id);
	}

	public List<Score> findAll() {
		return mapper.findAll();
	}

}
