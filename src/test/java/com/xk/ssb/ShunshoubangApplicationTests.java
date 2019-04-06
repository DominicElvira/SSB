package com.xk.ssb;

import com.xk.ssb.bean.User;
import com.xk.ssb.constant.UserSexEnum;
import com.xk.ssb.mapperDao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShunshoubangApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public  void  testInsert(){
		User user = new User("xk", "123456789", (byte) 0);
		userMapper.insertSelective(user);
	}




	@Test
	public void contextLoads() {
	}

}
