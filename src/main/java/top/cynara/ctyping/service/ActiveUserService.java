package top.cynara.ctyping.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.cynara.ctyping.entitiy.Permission;

/**
 * @ClassName ActiveUserService 
 * @Description 当前用户相关 权限操作接口
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月27日 下午8:50:33 
 * @version V1.0
 */
public interface ActiveUserService {
	List<Permission> findAllMenuBySysUserId(@Param("id") Integer id);
	List<Permission> findAllPermissionByUserId(@Param("id")Integer id);
}
