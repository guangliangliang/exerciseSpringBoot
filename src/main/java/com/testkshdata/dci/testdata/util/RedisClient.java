package com.testkshdata.dci.testdata.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class RedisClient{

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * <p>
     * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
     * </p>
     * <p>
     * 如果第一个list为空或者不存在则返回null
     * </p>
     *
     * @param srckey
     * @param dstkey
     * @return
     */
    public String add(String srckey, Object dstkey, int indexdb,int time,TimeUnit t) {

        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisTemplate
                .getConnectionFactory();
        jedisConnectionFactory.setDatabase(indexdb);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.opsForValue().set(srckey, dstkey, time,t);

        return 1+"";
    }

    /**
     * <p>
     * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
     * </p>
     * <p>
     * 如果第一个list为空或者不存在则返回null
     * </p>
     *
     * @return
     */
    public Object get(String srckey) {



        return redisTemplate.opsForValue().get(srckey);
    }


    /**
     * <p>
     * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
     * </p>
     * <p>
     * 如果第一个list为空或者不存在则返回null
     * </p>
     *
     * @return
     */
    public Object getDataByIndex(String srckey,int indexDb) {

        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisTemplate
                .getConnectionFactory();
        jedisConnectionFactory.setDatabase(indexDb);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate.opsForValue().get(srckey);
    }
    public String add1(String srckey, Object dstkey, int indexdb,TimeUnit t) {
        redisTemplate.opsForValue().set(srckey, dstkey,  indexdb, t);
        return 1+"";
    }
    /**
     * <p>

     public static void main(String[] args) {
     /*JedisPool jedisPool = new JedisPool(null,"localhost",6379,100,"123456");
     Jedis jedis = jedisPool.getResource();
     //r.get("", RedisConstants.datebase4);
     jedis.select(RedisConstants.datebase4);
     Set<String> str =  jedis.keys("*");
     for (String string : str) {
     System.out.println(string);
     }*/

}