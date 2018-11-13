package cn.smartGame.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoJDialog
{
	public static void main(String[] args)
	{
		//����������ť
		JButton btn1 = new JButton("ģ̬�Ի���");
		JButton btn2 = new JButton("��ģ̬�Ի���");
		JFrame f = new JFrame("DemoJDialog");
		f.setSize(300, 250);
		f.setLocation(300,200);
		f.setLayout(new FlowLayout());
		//��Ӱ�ť
		f.add(btn1);
		f.add(btn2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ���رհ�ťĬ�ϴ���
		f.setVisible(true);
		final JLabel jLabel = new JLabel();
		final JDialog jDialog = new JDialog(f,"jDialog");//����ָ�������ģ̬�Ի���
		jDialog.setSize(220, 150);
		jDialog.setLocation(350,250);
		jDialog.setLayout(new FlowLayout());
		JButton btn3 = new JButton("ȷ��");
		jDialog.add(btn3);//�ڶԻ��������Ӱ�ť
		//Ϊģ̬�Ի���ťbtn1��ӵ���¼�
		btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//�ֶ����öԻ���Ϊģ̬�Ի���
				jDialog.setModal(true);
				//���jDialog������û�����JLabel������Ͱ�JLabel��������
				if(jDialog.getComponents().length == 1){
					jDialog.add(jLabel);
				}
					//�����޸ı�ǩ����
					jLabel.setText("ģʽ�Ի��򣬵��ȷ����ť�ر�");
					jDialog.setVisible(true);
				
			}
		});
		//Ϊģ̬�Ի���ťbtn2��ӵ���¼�
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//���öԻ���Ϊ��ģ̬
				jDialog.setModal(false);
				//���jDialog������û�����JLabel������Ͱ�JLabel��������
				if(jDialog.getComponents().length == 1){
					jDialog.add(jLabel);
				}
					//�����޸ı�ǩ����
					jLabel.setText("��ģʽ�Ի��򣬵��ȷ����ť�ر�");
					jDialog.setVisible(true);
				
			}
			
		});
		//Ϊģ̬�Ի���ťbtn3��ӵ���¼�
		btn3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				jDialog.dispose();
			}
		
		
		});
	}
}
