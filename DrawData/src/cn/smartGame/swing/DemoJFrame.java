package cn.smartGame.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoJFrame extends JFrame
{
	public DemoJFrame(){
		this.setTitle("JFrame title");
		this.setSize(200, 300);
		//定义一个按钮
		JButton btn = new JButton("exit");
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//设置流式布局管理器
		this.setLayout(new FlowLayout());
		//添加按钮
		this.add(btn);
		//设置点击关闭按钮时默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DemoJFrame();
	}
}
