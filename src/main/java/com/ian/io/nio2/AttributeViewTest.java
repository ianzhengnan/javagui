package com.ian.io.nio2;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AttributeViewTest {

    public static void main(String[] args) throws Exception{

        Path testPath = Paths.get("src/main/java/com/ian/io/nio2/AttributeViewTest.java");

        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);

        BasicFileAttributes basicFileAttributes = basicView.readAttributes();

        System.out.println("创建时间：" + stampToDate(basicFileAttributes.creationTime().toMillis()));
        System.out.println("最后访问时间：" + stampToDate(basicFileAttributes.lastAccessTime().toMillis()));
        System.out.println("最后修改时间：" + stampToDate(basicFileAttributes.lastModifiedTime().toMillis()));
        System.out.println("文件大小：" + basicFileAttributes.size());

        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        System.out.println("文件的所有者是：" + ownerView.getOwner());

        // 获取系统中guest对应的用户
//        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        // 更改当前文件的owner
//        ownerView.setOwner(user);

        UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);

        List<String> attrNames = userView.list();
        for(String name : attrNames){
            ByteBuffer buffer = ByteBuffer.allocate(userView.size(name));
            userView.read(name, buffer);
            buffer.flip();
            String value = Charset.defaultCharset().decode(buffer).toString();
            System.out.println(name + "--->" + value);
        }
        // Exception in thread "main" java.nio.file.AccessDeniedException: src\main\java\com\ian\io\nio2\AttributeViewTest.java:发行者
//        userView.write("发行者", Charset.defaultCharset().encode("疯狂Java联盟"));

        // 获取DOS 属性的
        DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
        dosView.setHidden(true);
        dosView.setReadOnly(true);
    }

    // 时间戳转换为时间
    private static String stampToDate(long time){
        String result;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        result = simpleDateFormat.format(date);
        return result;
    }
}
