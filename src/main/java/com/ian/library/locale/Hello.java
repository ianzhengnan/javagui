package com.ian.library.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {

    public static void main(String[] args) throws Exception{
//        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        Locale myLocale = Locale.SIMPLIFIED_CHINESE;
        // 这里的baseName要带包名，不然会报错说找不到resource bundle
        ResourceBundle bundle = ResourceBundle.getBundle("com.ian.library.locale.mess", myLocale);
        String output = new String(bundle.getString("hello"));
        System.out.println(output);
    }
}
