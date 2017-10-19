package com.ian.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException{

        Properties props = new Properties();
        props.setProperty("username", "ian");
        props.setProperty("password", "12345");
        props.store(new FileOutputStream("src/main/java/com/ian/map/test.ini"), "comment line");
        System.out.println(props);

        Properties props2 = new Properties();
        props2.setProperty("gender", "male");
        props2.load(new FileInputStream("src/main/java/com/ian/map/test.ini"));
        System.out.println(props2);
    }
}
