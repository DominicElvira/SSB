package com.school.ssb;

import com.school.ssb.mapperDao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShunshoubangApplicationTests {

	@Autowired
	private UserMapper userMapper;

	//	@Test
//	public  void  testInsert(){
//		User user = new User("xk", "123456789", (byte) 0);
//		userMapper.insertSelective(user);
//	}
	Logger logger = LoggerFactory.getLogger(getClass());


	@Test
	public void get(){
		 userMapper.selectByPrimaryKey(1L);
	}


	@Test
	public void contextLoads() {
		logger.trace("tarce日志");
		logger.debug("debug日志");
		logger.info("info日志");
		logger.warn("warning日志");
		logger.error("erro日志");

	}

}
