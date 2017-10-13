package com.ian.library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest
{
    public static void main(String[] args) throws IOException{
        // 获取系统的环境变量
        Map<String, String> env = System.getenv();
        for (String name :
                env.keySet()) {
            System.out.println(name + "---> " + env.get(name));
        }
        // 打印JAVA_HOME
        System.out.println(System.getenv("JAVA_HOME"));
        // 获得系统属性, 虚拟机信息
        Properties props = System.getProperties();
        // 将系统属性保存到指定文件中
        props.store(new FileOutputStream("src/main/java/com/ian/library/props.tmp"), "System Properties");
        // 打印系统名
        System.out.println(System.getProperty("os.name"));
        // 得到当前毫秒时间戳
        System.out.println(System.currentTimeMillis());
        // 获得当前纳秒时间戳
        System.out.println(System.nanoTime());

        String s1 = new String("kaka");
        String s2 = new String("kaka");
        // 相同
        System.out.println(s1.hashCode() + "---" + s2.hashCode());
        // 不同，以为他是根据对象在内存中的地址计算得来
        System.out.println(System.identityHashCode(s1) + "---" + System.identityHashCode(s2));



    }
}
