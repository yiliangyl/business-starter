package com.qyl.cache;

import com.qyl.utils.component.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @Author: qyl
 * @Date: 2021/2/10 17:20
 * @Description: MyBatis缓存类
 */
@Slf4j
public class RedisCache implements Cache {

    /**
     * namespace
     */
    private String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        log.info("当前缓存id:[{}]", id);
        return this.id;
    }

    /**
     * 放入redis缓存
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        log.info("缓存key:[{}], 缓存value:[{}]", key.toString(), value);
        RedisUtil.getRedisTemplate().opsForHash().put(id, key.toString(), value);
    }

    /**
     * 从redis缓存获取
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        log.info("获取缓存key:[{}]", key.toString());
        return RedisUtil.getRedisTemplate().opsForHash().get(id, key.toString());
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    /**
     * 清除缓存
     */
    @Override
    public void clear() {
        log.info("清除所有缓存");
        RedisUtil.getRedisTemplate().delete(id);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
