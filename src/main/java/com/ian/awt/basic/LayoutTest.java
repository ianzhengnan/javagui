package com.ian.awt.basic;

import java.awt.*;

public class LayoutTest {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20,5));
        for (int i = 0; i < 10; i++) {
            f.add(new Button("按钮" + i));
        }
        // 设置窗口为最佳
        f.pack();
        f.setBounds(30,30, 250,200);
        f.setVisible(true);
    }
}
