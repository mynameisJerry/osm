package com.pzhu.shopping.myshop.controller.sms;


import com.pzhu.shopping.myshop.commons.redis.JedisClientPool;
import com.pzhu.shopping.myshop.utils.msg.IndustrySMS;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Administrator
 * @Date 2019/1/9 15:48
 * @Classname SmsController
 */
@Controller
@RequestMapping("/sms")
public class SmsController {

    private static final Logger logger = Logger.getLogger(SmsController.class);

    @Autowired
    private JedisClientPool jedisClientPool;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/msg")
    public String getPhoneCode(String phone) {
        Jedis jedis = jedisPool.getResource();
        System.out.println("phone ====>  "+phone);
        String phoneCode = IndustrySMS.execute(phone);
        jedis.set(phone, phoneCode);
        jedis.expire(phone, 120);
        logger.info("验证码已发送"+phoneCode);
        return phoneCode;
    }

}
