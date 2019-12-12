package com.jczx.jcms;

import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.File;
import java.io.IOException;

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

    /**
     * 测试file类的用法
     */
    @Test
    public void testFile() throws IOException {

        File file = new File("static");
        System.out.println(file);//打印路径
        file.renameTo(new File("D:/IDEA_Project/bb.txt"));//改名
        File file2 = new File("hehe.txt");
       /* file.createNewFile();//创建*/
        System.out.println(file.exists()+"判断file是否存在");

      /*  File file3 = new File("d:mm.txt");
        file3.mkdirs();//目录中有一个不存在也没关系,会创建整个目录*/

        System.out.println(file.getAbsolutePath()+"绝对路径");
        System.out.println(file.getPath()+"相对路径");//构建的时候如果是相对路径就是相对路径,如果是绝对路径返回的就是绝对路径
        System.out.println(file.getParent()+"父路径,也就是上一级");
        System.out.println(System.getProperty("user.dir")+"相对路径");
    }
}
