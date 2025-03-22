package com.hyk.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginJframe extends JFrame {
    public LoginJframe(){
        this.setSize(488,430);
        this.setTitle("拼图登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);

        this.setLayout(null);

        JButton jbt = new JButton("点我");
        jbt.setBounds(0,0,100,50);

//        jbt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("hello");
//            }
//        });

//        jbt.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println(1);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println(2);
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println(3);
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                System.out.println(4);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println(5);
//            }
//        });

        this.getContentPane().add(jbt);

        this.setVisible(true);

    }
}
