package com.jczx.jcms;

import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class JcmsApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ConfigScanner configScanner;
    @Autowired
    private DomainUtil domainUtil;
    @Test
    void contextLoads() {
    }
    @Test
    public void initContext() {
        System.out.println("-------------test  start-------------");
        configScanner.scan();
        domainUtil.generateAllSingleTable();


    }
    @Test
    public  void testReidis(){
        System.out.println(stringRedisTemplate.opsForValue());
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("k1", "value1");//存一个key
        System.out.println("操作成功");
        System.out.println(opsForValue.get("k1"));
    }
}
