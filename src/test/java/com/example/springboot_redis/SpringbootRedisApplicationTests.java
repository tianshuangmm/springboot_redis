package com.example.springboot_redis;

import com.example.springboot_redis.redisUtils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        /*redisUtil.set("ts","mm",15);
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId","1");
        map.put("money","36.6");
        map.put("time","2018-01-01");
        redisUtil.hmset("order:2",map,15);
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("orderId","2");
        map1.put("money","36.6");
        map1.put("time","2018-01-01");
        redisUtil.hmset("order:1",map1,15);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("orderId","3");
        map2.put("money","36.6");
        map2.put("time","2018-01-01");
        redisUtil.hmset("order:3",map2,15);
        redisUtil.lpush(15,"user:1:order","order:1","order:2","order:3");
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("orderId","5");
        map3.put("money","36.6");
        map3.put("time","2018-01-01");
        redisUtil.hmset("order:4",map3,15);*/
        redisUtil.lpush(15,"user:1:order" ,"order:4");
        List orderkeys=redisUtil.lrange("user:1:order",0,-1,15);
        for (Object object:orderkeys) {
            Map<String, String> m=redisUtil.hgetall(object.toString(),15);
            for ( String str:m.keySet()) {
               System.out.println("//////////"+str+m.get(str));
            }
        }

    }

}
