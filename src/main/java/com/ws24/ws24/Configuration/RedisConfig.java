package com.ws24.ws24.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.username}")
    String redisUsername;
    @Value("${spring.data.redis.password}")
    String redisPassword;
    @Value("${spring.data.redis.host}")
    String redisHost;
    @Value("${spring.data.redis.port}")
    Integer redisPort;


    @Bean("application")
    public RedisTemplate<String,String> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setHostName(redisHost);
        rsc.setPort(redisPort);
        if (!redisUsername.equals("") && !redisPassword.equals("")){
            rsc.setUsername(redisUsername);
            rsc.setPassword(redisPassword);
        }
        JedisClientConfiguration jcc = JedisClientConfiguration.builder().build();
        JedisConnectionFactory jcf = new JedisConnectionFactory(rsc,jcc);
        return jcf;
    }

}
