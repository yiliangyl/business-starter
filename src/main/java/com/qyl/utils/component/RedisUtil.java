package com.qyl.utils.component;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: qyl
 * @Date: 2021/2/21 11:20
 * @Description: 获取序列化后的 RedisTemplate
 */
public class RedisUtil {

    public static RedisTemplate getRedisTemplate() {
        // 通过工厂工具类获取 redisTemplate
        RedisTemplate  redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");

        // redis key 的 string 序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // redis value 的 json 序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        /*
        转换java对象时使用
        */
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 指定要序列化的域 field，get和set以及修饰符范围，ANY是都有包括private和public
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String，Integer等会抛出异常
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 序列化string类型
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        // 序列化hash类型
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        return redisTemplate;
    }
}
