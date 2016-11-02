package org.ruyin.code.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class StringRedisTemplateSample {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public void useCallback(){
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				long size = connection.dbSize();
				//Can cast to StringRedisConnection if using a StringRedisTemplate
				((StringRedisConnection)connection).set("key", size+"");
				return null;
			}
			
		});
	}
}
