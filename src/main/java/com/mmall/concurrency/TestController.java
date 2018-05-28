package com.mmall.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test interface Controller
 *
 * @author SQiang
 * @create 2018-05-22 11:36
 **/
@Controller
@Slf4j
public class TestController {
	@RequestMapping("test")
	@ResponseBody
	public String test(){
		return "test";
	}
}
