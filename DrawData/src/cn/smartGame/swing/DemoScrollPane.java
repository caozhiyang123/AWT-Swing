package cn.smartGame.swing;


import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DemoScrollPane extends JFrame
{
	
	public DemoScrollPane()
	{
		this.setTitle("DemoScrollPane");
		JScrollPane jScrollPane = new JScrollPane();
		//设置水平滚动条一直显示
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//设置垂直滚动条需要时显示
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		//定义一个JPanel面板
		Panel panel = new Panel();
		//在jPanel面板添加四个按钮
		panel.add(new JButton("按钮1"));
		panel.add(new JButton("按钮2"));
		panel.add(new JButton("按钮3"));
		panel.add(new JButton("按钮4"));
		jScrollPane.setViewportView(panel);
		this.add(jScrollPane,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,250);
		this.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new DemoScrollPane();
	}
}
