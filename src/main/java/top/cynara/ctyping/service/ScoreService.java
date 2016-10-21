package top.cynara.ctyping.service;

import java.util.List;

import top.cynara.ctyping.entitiy.Score;

/**
 * @ClassName ScoreService
 * @Description 成绩相关操作
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午4:46:51
 * @version V1.0
 */
public interface ScoreService {
	void insert(Score score);

	void delete(Integer id);

	void update(Score score);

	Score findById(Integer id);

	List<Score> findAll();
}
