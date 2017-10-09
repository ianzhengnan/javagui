package com.ian.awt.basic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutTest {
    private Frame f = new Frame();

    private void init(){
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20,5));
        for (int i = 0; i < 10; i++) {
            f.add(new Button("按钮" + i));
        }
        // 设置窗口为最佳
        f.addWindowListener(new MyListener());
        f.pack();
        f.setBounds(30,30, 250,200);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutTest().init();
    }

    class MyListener extends WindowAdapter{

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("用户关闭窗口！\n");
            System.exit(0);
        }
    }
}
