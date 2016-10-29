package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.ctyping.entitiy.Permission;
import top.cynara.ctyping.entitiy.mapper.ActiveUserMapper;
import top.cynara.ctyping.service.ActiveUserService;
/**
 * @ClassName ActiveUserServiceImpl 
 * @Description 当前用户相关权限实现类 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月27日 下午8:51:22 
 * @version V1.0
 */
@Service("ActiveUserService")
public class ActiveUserServiceImpl implements ActiveUserService {
	
	@Autowired
	private ActiveUserMapper mapper;
	
	public List<Permission> findAllMenuBySysUserId(Integer id) {
		return mapper.findAllMenuBySysUserId(id);
	}

	public List<Permission> findAllPermissionByUserId(Integer id) {
		return mapper.findAllPermissionByUserId(id);
	}

}
