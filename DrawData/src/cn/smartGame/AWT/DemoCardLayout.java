package cn.smartGame.AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;

import cn.smartGame.lastedVersion.DrawRTPLine;

public class DemoCardLayout extends Frame implements ActionListener
{
	Panel cardPanel = new Panel();//���������ÿ�Ƭ
	Panel btnPanel = new Panel();//���������ð�ť
	Button nextBtn,preBtn;
	CardLayout cardLayout = new CardLayout();
	public DemoCardLayout()
	{
		this.setSize(300, 200);
		this.setLocation(400, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		cardPanel.setLayout(cardLayout);//����card���Ϊ��Ƭ���ֹ�����
		//��card�����������ı���ǩ
		cardPanel.add(new Label("��һ������", Label.CENTER));
		cardPanel.add(new Label("�ڶ�������", Label.CENTER));
		cardPanel.add(new Label("����������", Label.CENTER));
		cardPanel.add(DrawRTPLine.jp1);
		cardPanel.add(DrawRTPLine.jp2);
		cardPanel.add(DrawRTPLine.jp3);
		//����2����ť����
		nextBtn = new Button("��һ�ſ�Ƭ");
		preBtn = new Button("��һ�ſ�Ƭ");
		//Ϊ��ť����ע�������
		nextBtn.addActionListener(this);
		preBtn.addActionListener(this);
		//����ť��ӵ�btnPanel��
		btnPanel.add(nextBtn);
		btnPanel.add(preBtn);
		this.add(cardPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
	//����Ĵ���ʵ���˰�ť�ļ������������Դ����¼�������Ӧ�Ĵ���
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//����û�����nextBtn
		if(e.getSource() == nextBtn){
			//�л�cardPanel����е�ǰ���֮���һ�����
			cardLayout.next(cardPanel);
		}else if(e.getSource() == preBtn){
			cardLayout.previous(cardPanel);
		}
	}

	public static void main(String[] args)
	{
		DrawRTPLine.start();
		DemoCardLayout demoCardLayout = new DemoCardLayout();
	}
	
	public void a(){}
	public void b(){}
	

}
