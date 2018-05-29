package cn.bgenius.pconnect.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.bgenius.pconnect.Application;

public class UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Test
	public void save() {
		System.out.println("添加用户信息");
		log.error("-------添加用户信息");
	}
	
	@Test
	public void delete() {
		System.out.println("删除用户信息");
		log.info("删除用户信息");
	}
}
