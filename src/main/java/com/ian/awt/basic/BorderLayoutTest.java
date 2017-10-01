package com.ian.awt.basic;

import java.awt.*;

public class BorderLayoutTest {

    public static void main(String[] args) {

        Frame f = new Frame("测试BorderLayout");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), BorderLayout.SOUTH);
        f.add(new Button("西"), BorderLayout.WEST);
        f.add(new Button("北"), BorderLayout.NORTH);
        f.add(new Button("东"), BorderLayout.EAST);
        f.add(new Button("中"), BorderLayout.CENTER);

        f.pack();
        f.setVisible(true);

    }
}
