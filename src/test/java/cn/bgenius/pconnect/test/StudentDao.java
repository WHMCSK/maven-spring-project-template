package cn.bgenius.pconnect.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.bgenius.pconnect.Application;

public class StudentDao {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Test
	public void save() {
		System.out.println("添加学员信息");
		log.info("添加学员信息");
	}
	
	@Test
	public void delete() {
		System.out.println("删除学员信息");
		log.info("删除学员信息");
	}
}
