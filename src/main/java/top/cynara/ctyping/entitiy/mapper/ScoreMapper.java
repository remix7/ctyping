package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import top.cynara.ctyping.entitiy.Score;

/**
 * @ClassName ScoreMapper 
 * @Description 分数增删改查
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月21日 下午4:16:46 
 * @version V1.0
 */
public interface ScoreMapper {
	void insert(Score score);
	void delete(Integer id);
	void update(Score score);
	Score findById(Integer id);
	List<Score> findAll();
}
