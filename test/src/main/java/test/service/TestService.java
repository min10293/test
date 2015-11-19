package test.service;

import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.controller.TestController;
import test.dao.TestDao;

@Service
public class TestService {
	
	static final Logger Logger = LoggerFactory.getLogger(TestService.class);
	
	@Autowired
	private TestDao testDao;
	
	public HashMap<String, Object> test(HashMap<String, Object> map){
		HashMap <String, Object> resultMap = new HashMap<String, Object>();
		resultMap = testDao.test(map);
		return resultMap;
	}
}
