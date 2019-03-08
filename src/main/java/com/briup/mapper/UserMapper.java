package com.briup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.User;

//@Mapper
public interface UserMapper {
	List<User> getAll();
	User getOne(long id);
	void insert(User user);
	void update(User user);
	void delete(long id);
}