package test.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public HashMap<String, Object> test(HashMap<String, Object> map){
		HashMap<String, Object> resultMap = sqlSessionTemplate.selectOne("test.selecttest", map);
		return resultMap;
	}
}
