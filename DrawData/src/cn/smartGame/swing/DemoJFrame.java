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
		//����һ����ť
		JButton btn = new JButton("exit");
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//������ʽ���ֹ�����
		this.setLayout(new FlowLayout());
		//��Ӱ�ť
		this.add(btn);
		//���õ���رհ�ťʱĬ�ϲ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DemoJFrame();
	}
}
