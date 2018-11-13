package cn.smartGame.AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DemoGridBagLayout extends Frame{
    public static void main(String[] args) {
        new DemoGridBagLayout(" GridBagLayout");
    }
    public DemoGridBagLayout(String title){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        this.setSize(400, 400);
        this.setLocation(400, 300);
        this.setLayout(layout);
        c.fill = GridBagConstraints.BOTH;//设置组件横向纵向可以拉伸 1
        c.weightx = 1;//设置横向权重为1
        c.weighty = 1;//设置纵向权重为1
        this.addcomponent("btn1",layout,c);
        this.addcomponent("btn2",layout,c);
        this.addcomponent("btn3",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行最后一个组件 0
        this.addcomponent("btn4", layout, c);
        c.weightx = 0;//设置横向权重为0
        c.weighty = 0;//设置纵向权重为0
        c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行最后一个组件 0
        this.addcomponent("btn5", layout, c);
        c.gridwidth = 1;
        this.addcomponent("btn6", layout, c);
        c.gridwidth = GridBagConstraints.REMAINDER;//添加的组件是本行最后一个组件 0
        this.addcomponent("btn7", layout, c);
        c.gridheight = 2;//设置组件纵向跨2个网格
        c.gridwidth = 1;//设置组件横向跨1个网格
        c.weightx = 2;////设置纵向权重为2
        c.weighty = 2;//设置纵向权重为2
        this.addcomponent("btn8", layout, c);
        c.gridwidth =  GridBagConstraints.REMAINDER;//添加的组件是本行最后一个组件 0
        c.gridheight = 1;
        this.addcomponent("btn9", layout, c);
        this.addcomponent("btn10", layout, c);
        this.pack();
        this.setVisible(true);
        
    }
    private void addcomponent(String name, GridBagLayout layout, GridBagConstraints c) {
        Button bt = new Button(name);
        layout.setConstraints(bt, c);
        this.add(bt);
    }
}