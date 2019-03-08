package com.briup;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.briup.bean.Gender;
import com.briup.bean.User;
import com.briup.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("briup1", 21, Gender.MAN));
		userMapper.insert(new User("briup2", 22, Gender.WOMAN));
		userMapper.insert(new User("briup3", 23, Gender.WOMAN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users);
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(36L);
		user.setName("woodcool");
		userMapper.update(user);
		Assert.assertTrue(("woodcool".equals(userMapper.getOne(36L).getName())));
	}

}
