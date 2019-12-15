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
    /**
     * 删除单个文件
     * @param fileName
     * 被删除文件的文件名
     * @return 单个文件删除成功返回true,否则返回false
     */
   /* public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            System.out.println("删除单个文件" + fileName + "成功！");
            return true;
        } else {
            System.out.println("删除单个文件" + fileName + "失败！");
            return false;
        }
    }
*/
    /**
     * 删除一个文件夹下的所有文件(包括子目录内的文件)
     */
    /*static int flag = 1;//用来判断文件是否删除成功
    public static void main(String[] args) {
        //删除一个文件夹下的所有文件(包括子目录内的文件)
        File file = new File("D:\\delete");//输入要删除文件目录的绝对路径
        deleteFile(file);
        if (flag == 1){
            System.out.println("文件删除成功！");
        }
    }
    public static void deleteFile(File file){
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()){
            flag = 0;
            System.out.println("文件删除失败,请检查文件路径是否正确");
            return;
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f: files){
            //打印文件名
            String name = file.getName();
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()){
                deleteFile(f);
            }else {
                f.delete();
            }
        }
        //删除空文件夹  for循环已经把上一层节点的目录清空。
        file.delete();
    }*/





}
