package com.jczx.jcms;

import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JcmsApplicationTests {
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
}
