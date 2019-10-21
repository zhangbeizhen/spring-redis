package com.zbz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 *  
 * @ClassName: OptRedisClusterService
 * @author: ag
 * @date: 2019年10月21日 下午8:11:57
 */

@Service
public class OptRedisClusterService {
	private static final Logger logger = LoggerFactory.getLogger(OptRedisClusterService.class);
	@Autowired
	private RedisTemplate redisClusterTemplate;	
	public String optCluster(){
		String result ="";
		logger.info("从集群读出数据:" +"Hello");
		ValueOperations value = redisClusterTemplate.opsForValue();
		result = value.get("Hello").toString();
		logger.info("集群读出结果是: " + result);		
		logger.info("向集群写入数据:" +"HelloCluster:20191021");
		value.set("HelloCluster", "20191021");		
		return result;
	}
}


