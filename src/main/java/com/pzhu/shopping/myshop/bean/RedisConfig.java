package com.pzhu.shopping.myshop.bean;

import com.pzhu.shopping.myshop.commons.redis.JedisClientPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * code by JerryChan  2019/4/7 12:58
 * ━━━━━━感觉萌萌哒━━━━━━
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.pool.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,host,port,5000);
        return jedisPool;
    }
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxTotal(1024);
        return jedisPoolConfig;
    }




    @Bean
    public JedisClientPool jedisClientPool(JedisPool jedisPool) {
        JedisClientPool jedisClientPool = new JedisClientPool();
        jedisClientPool.setJedisPool(jedisPool);
        return jedisClientPool;
    }


    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(5242880);
        return commonsMultipartResolver;
    }



}
