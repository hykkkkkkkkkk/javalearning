package com.hyk.ui;

import javax.swing.*;

public class RegisterJframe extends JFrame {
    public RegisterJframe(){
        this.setSize(488,500);
        this.setVisible(true);
        this.setTitle("拼图注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
    }
}
