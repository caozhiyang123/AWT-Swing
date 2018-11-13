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
		//����ˮƽ������һֱ��ʾ
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//���ô�ֱ��������Ҫʱ��ʾ
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		//����һ��JPanel���
		Panel panel = new Panel();
		//��jPanel�������ĸ���ť
		panel.add(new JButton("��ť1"));
		panel.add(new JButton("��ť2"));
		panel.add(new JButton("��ť3"));
		panel.add(new JButton("��ť4"));
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
