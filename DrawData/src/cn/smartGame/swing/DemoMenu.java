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
		JMenuBar jMenuBar = new JMenuBar();//�����˵���
		this.setJMenuBar(jMenuBar);//���˵�����ӵ�����
		JMenu jMenu = new JMenu("����");
		jMenuBar.add(jMenu);//���˵���ӵ��˵���
		//���������˵���
		JMenuItem item1 = new JMenuItem("��������");
		JMenuItem item2 = new JMenuItem("�ر�");
		//Ϊ�˵�������¼�������
		item1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//����һ��JDialog����
				JDialog jDialog = new JDialog(DemoMenu.this,"��������",true);
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
