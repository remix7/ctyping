package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import top.cynara.ctyping.entitiy.User;

/**
 * @ClassName UserMapper
 * @Description 用户增删改查接口
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午12:25:41
 * @version V1.0
 */
public interface UserMapper {
	/**
	 * @Title insert 
	 * @Description 增加用户
	 * @param user       
	 * @author Cynara-remix
	 * @Date 2016年10月21日 下午12:37:37
	 */
	void insert(User user);
	/**
	 * @Title delete 
	 * @Description 删除用户 
	 * @param id       
	 * @author Cynara-remix
	 * @Date 2016年10月21日 下午12:37:55
	 */
	void delete(Integer id);
	/**
	 * @Title update 
	 * @Description 修改
	 * @param user       
	 * @author Cynara-remix
	 * @Date 2016年10月21日 下午12:38:10
	 */
	void update(User user);
	/**
	 * @Title findAll 
	 * @Description 获取全部
	 * @author Cynara-remix
	 * @Date 2016年10月21日 下午12:38:19
	 */
	List<User> findAll();
	/**
	 * @Title findById 
	 * @Description 根据id获取
	 * @param id
	 * @author Cynara-remix
	 * @Date 2016年10月21日 下午12:38:28
	 */
	User findById(Integer id);
}
