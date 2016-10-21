package top.cynara.ctyping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.ctyping.entitiy.User;
import top.cynara.ctyping.entitiy.mapper.UserMapper;
import top.cynara.ctyping.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	public void insert(User user) {
		mapper.insert(user);
	}

	public void delete(Integer id) {
		mapper.delete(id);
	}

	public void update(User user) {
		mapper.update(user);
	}

	public List<User> findAll() {
		return mapper.findAll();
	}

	public User findById(Integer id) {
		return mapper.findById(id);
	}

}
