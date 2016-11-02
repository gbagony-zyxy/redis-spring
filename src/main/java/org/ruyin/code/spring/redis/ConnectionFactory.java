package org.ruyin.code.spring.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class ConnectionFactory {

	@Bean
	public RedisConnectionFactory jedisConnectionFactory(){
		RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration().master("server").sentinel("",26379).sentinel("", 36379);
		return new JedisConnectionFactory(sentinelConfiguration);
	}
}
