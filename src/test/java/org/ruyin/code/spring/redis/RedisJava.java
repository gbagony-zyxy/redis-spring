package org.ruyin.code.spring.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.Jedis;

public class RedisJava {
	ApplicationContext context;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void Test(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("Server info:"+jedis.ping());
		jedis.close();
	}
	
	
	// the key same will be overrided
	//StringRedisTemplate is a convenient one-stop solution for intensive String operations.
	@Test
	public void test1(){
		StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) context.getBean("stringRedisTemplate");
		long value = stringRedisTemplate.opsForList().leftPush("name", "timo");
		stringRedisTemplate.opsForValue().set("name", "nike");
		System.out.println(value);
	}
}
