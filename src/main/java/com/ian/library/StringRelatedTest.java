package com.ian.library;

public class StringRelatedTest {

    public static void main(String[] args) {

        String str = new String();
        System.out.println(str.equals(""));

        str = "How are you?I'm fine. Thank you.";
        System.out.println("str.charAt(5) = " + str.charAt(5));

        String str1 = "How";
        // 返回不一样的长度差
        System.out.println("str.compareTo(str1): " + str.compareTo(str1));
        System.out.println(str.equals(str1));
        System.out.println(str.equalsIgnoreCase(str1));
        System.out.println(str.endsWith("."));
        byte[] bytes = str.getBytes();

        char[] s1 = {'I', ' ', 'l', 'o', 'v', 'e', ' ','y', 'o', 'u'};
        System.out.println(s1);
        String s2 = new String("ejb");
        // 把s2中的0-3个字符复制到s1中
        s2.getChars(0,3, s1, 7);
        System.out.println(s1);

        String str2 = "1234567890";
        // 此处的52是4的ascii十进制码
        System.out.println(str2.indexOf(52));
        System.out.println(str.indexOf("w"));
        System.out.println(str.indexOf("a", 2));
        System.out.println(str2.indexOf(52, 2));
        System.out.println(str.lastIndexOf("j"));
        System.out.println(str.length());
        System.out.println(str.startsWith("are"));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        //类方法String.valueOf(X x); X: int, long, Double, boolean, float, char[]
        System.out.println(String.valueOf(23.45));

        String str3 = "   haha haha   ";
        // trim()可以去掉string两边空格
        System.out.println(str3.trim());

        // 线程安全但性能略低
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer);
        stringBuffer.append("kaka");
        System.out.println(stringBuffer);
        stringBuffer.delete(2, 5);
        System.out.println(stringBuffer);
        stringBuffer.insert(2, "wakaka");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());
        stringBuffer.reverse();
        System.out.println(stringBuffer);

        // 线程不安全，但性能略高
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        stringBuilder.append("kaka");
        System.out.println(stringBuilder);
        stringBuilder.delete(2, 5);
        System.out.println(stringBuilder);
        stringBuilder.insert(2, "wakaka");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.capacity());
        stringBuilder.reverse();
        System.out.println(stringBuilder);

    }
}
