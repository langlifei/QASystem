package com.test.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 配置RedisTemplate的序列化。
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }

    /*
            设置Redis为默认缓存工具
         */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        // 配置序列化
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1));
        RedisCacheConfiguration redisCacheConfiguration = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        //配置连接工厂
        template.setConnectionFactory(factory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值(默认使用jdk序列化)
        Jackson2JsonRedisSerializer jacksonSerial = new Jackson2JsonRedisSerializer(Object.class);
        //注：可查看各个序列化类的效果来加深理解。
        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，以及修饰符范围;ANY是包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //指定序列化输入的类型，类必须是非final修饰的。
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL,JsonTypeInfo.As.PROPERTY);
        jacksonSerial.setObjectMapper(objectMapper);
        //值采用json序列化
        template.setValueSerializer(jacksonSerial);
        //键采用StringRedisSerializer序列化
        template.setKeySerializer(new StringRedisSerializer());
        //设置hash key 和 value的序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);
        //对redisTemplate进行初始化。
        template.afterPropertiesSet();
        return template;
    }
}
