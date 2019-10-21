package com.zbz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbz.service.OptRedisClusterService;

/**
 * http://127.0.0.1:8080/spring-redis/service/redis?str=test
 * @ClassName: DevOptController
 * @author: ag
 * @date: 2019年10月21日 下午7:51:36
 */

@Controller
@RequestMapping("/service")
public class DevOptController {
	private static final Logger logger = LoggerFactory.getLogger(DevOptController.class);
	@Autowired
	private OptRedisClusterService opt;
	@ResponseBody
	@RequestMapping(value = "redis", method = RequestMethod.GET)
	public String service(String str) throws Exception {
		logger.info("DevOptController->service 测试开始......");
		String result = "{\"result\" : \"success\"}";
		String result2 = opt.optCluster();
		logger.info("DevOptController->service 测试结束......");
		return result;
	}
}
