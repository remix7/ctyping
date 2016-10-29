package top.cynara.ctyping.entitiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.cynara.ctyping.entitiy.Permission;

public interface ActiveUserMapper {
	List<Permission> findAllMenuBySysUserId(@Param("id") Integer id);
	List<Permission> findAllPermissionByUserId(@Param("id")Integer id);
}
