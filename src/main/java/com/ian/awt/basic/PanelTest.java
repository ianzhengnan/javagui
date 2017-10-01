package com.ian.awt.basic;

import java.awt.*;

public class PanelTest {

    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
//        Panel panel = new Panel();
        ScrollPane panel = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        panel.add(new TextField(20));
        panel.add(new Button("点击我"));
        // 不可以直接加入frame
//        f.add(new TextField(20));
//        f.add(new Button("Frame中"));
        f.add(panel);
        f.setBounds(30, 30, 250, 200);
        f.setVisible(true);
    }

}
