package cn.smartGame.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DemoMenu extends JFrame
{
	public DemoMenu(){
		JMenuBar jMenuBar = new JMenuBar();//创建菜单栏
		this.setJMenuBar(jMenuBar);//将菜单栏添加到窗口
		JMenu jMenu = new JMenu("操作");
		jMenuBar.add(jMenu);//将菜单添加到菜单栏
		//创建两个菜单项
		JMenuItem item1 = new JMenuItem("弹出窗口");
		JMenuItem item2 = new JMenuItem("关闭");
		//为菜单项添加事件监听器
		item1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//创建一个JDialog窗口
				JDialog jDialog = new JDialog(DemoMenu.this,"弹出窗口",true);
				jDialog.setSize(200, 200);
				jDialog.setLocation(50, 50);
				jDialog.setVisible(true);
			}
		});
		item2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		jMenu.add(item1);
		jMenu.addSeparator();
		jMenu.add(item2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new DemoMenu();
	}

}
