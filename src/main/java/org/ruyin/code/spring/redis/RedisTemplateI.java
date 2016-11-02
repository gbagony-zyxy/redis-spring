package org.ruyin.code.spring.redis;

import java.net.URL;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateI {

	// inject the actual template
	@SuppressWarnings("unused")
	@Autowired
	private RedisTemplate<String, String> template;
	
	// inject the template as ListOprations
	@Resource(name="redisTemplate")
	private ListOperations<String, String> listOps;
	
	public void addLink(String userId,URL url){
		listOps.leftPush(userId, url.toExternalForm());
	}
}
