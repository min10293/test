package test.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.service.TestService;

@Controller
public class TestController {
	
	static final Logger Logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;

	@RequestMapping("/test")
	public ModelAndView test(@RequestParam HashMap<String, Object> testMap, HttpServletRequest request){
		HashMap<String, Object> resultMap = testService.test(testMap);
		ModelAndView model = new ModelAndView();
		model.addObject("resultMap", resultMap);
		model.setViewName("showMessage");
		return model;
	}
}
