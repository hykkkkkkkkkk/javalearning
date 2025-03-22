package com.hyk.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int[][] win = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

    int count = 0;
    String path = "puzzlegame\\image\\sport\\sport9\\";

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("微信号");

    JMenuItem womanItem = new JMenuItem("人物");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

    //游戏的主界面
    public GameJframe(){
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据
        data =initData();

        //初始化图片
        initImage();



        this.setVisible(true);
    }

    //记录空白方块在二维数组中的位置
    int x;
    int y;
    private int[][] initData() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        int[][] data = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            data[i/4][i%4] = tempArr[i];
            if(tempArr[i]==0){
                x = i/4;
                y = i%4;
            }
        }
        return data;
    }

    private void initJMenuBar() {
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutusJMenu = new JMenu("关于我");

        JMenu changeImage = new JMenu("更改图片");

        //将条目添加到选项
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(changeImage);

        aboutusJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        changeImage.add(womanItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);

        womanItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

        //将选项添加到菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutusJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603,680);
        //设置标题
        this.setTitle("拼图单机版");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //把位置默认居中关闭
        this.setLayout(null);

        this.addKeyListener(this);
    }

    private void initImage(){
        this.getContentPane().removeAll();

        if(victory()){
            JLabel winJLable = new JLabel(new ImageIcon("C:\\Users\\HYKKK\\Desktop\\javalearning\\TestCode\\puzzlegame\\image\\win.png"));
            winJLable.setBounds(203,83,197,73);
            this.getContentPane().add(winJLable);
        }

        JLabel stepcount = new JLabel("步数"+count);
        stepcount.setBounds(50,30,100,20);
        this.getContentPane().add(stepcount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //创建JLable对象
                JLabel jLabel = new JLabel( new ImageIcon(path+num+".jpg"));
                //指定图片的位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器加入界面
                this.getContentPane().add(jLabel);
            }
        }

        ImageIcon bg = new ImageIcon("puzzlegame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        if(code == 65){
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);


            ImageIcon bg = new ImageIcon("puzzlegame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }

        int code = e.getKeyCode();
        switch (code){
            case 37:
                System.out.println("left");
                if(y!=3){
                    data[x][y] = data[x][y+1];
                    data[x][y+1] = 0;
                    y++;
                    count++;
                    initImage();
                }
                break;
            case 38:
                System.out.println("up");
                if(x!=3){
                    data[x][y] = data[x+1][y];
                    data[x+1][y] = 0;
                    x++;
                    count++;
                    initImage();
                }

                break;
            case 39:
                System.out.println("right");
                if(y!=0){
                    data[x][y] = data[x][y-1];
                    data[x][y-1] = 0;
                    y--;
                    count++;
                    initImage();
                }
                break;
            case 40:
                System.out.println("down");
                if(x!=0){
                    data[x][y] = data[x-1][y];
                    data[x-1][y] = 0;
                    x--;
                    count++;
                    initImage();
                }
                break;
            case 65:
                initImage();
                break;
            case 87:
                data = win;
                x = 3;
                y = 3;
                initImage();
                break;
        }
    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            count = 0;
            x = 0;
            y = 0;
            data = initData();
            initImage();

        }else if(obj == reloginItem){
            this.setVisible(false);
            new LoginJframe();
        }else if(obj == closeItem){
            System.exit(0);
        } else if (obj == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel =new JLabel(new ImageIcon("C:\\Users\\HYKKK\\Desktop\\javalearning\\TestCode\\puzzlegame\\image\\about.png"));
            jLabel.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);

        } else if (obj == animalItem) {
            Random r = new Random();
            int num = r.nextInt(1,9);
            path = "puzzlegame\\image\\animal\\animal"+num+"\\";
            data = initData();
            initImage();
        } else if (obj == womanItem) {
            Random r = new Random();
            int num = r.nextInt(1,14);
            path = "puzzlegame\\image\\girl\\girl"+num+"\\";
            data = initData();
            initImage();
        } else if (obj == sportItem) {
            Random r = new Random();
            int num = r.nextInt(1,11);
            path = "puzzlegame\\image\\sport\\sport"+num+"\\";
            data = initData();
            initImage();
        }
    }
}
