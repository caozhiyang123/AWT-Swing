package cn.smartGame.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DemoTextArea extends JFrame
{
	JButton btn;
	JTextField inputField;
	JTextArea chatContent;
	public DemoTextArea(){
		this.setLayout(new BorderLayout());
		chatContent = new JTextArea();
		JScrollPane showPanel = new JScrollPane(chatContent);//����������岢���ı�����Ϊ����ʾ���
		chatContent.setEditable(false);//�����ı��򲻿ɱ༭
		JPanel inputPanel = new JPanel();//����һ�����
		inputField = new JTextField(20);//����һ���ı���
		btn = new JButton("send");//�������Ͱ�ť
		//Ϊ��ť����¼�
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = inputField.getText();
				if(text !=null && !text.trim().equals("")){
					//�����Ϊ�գ�������׷�ӵ����촰��
					chatContent.append(text+"\n");
				}else{
					//��ʾ������Ϣ����Ϊ��
					chatContent.append("����Ϊ��"+"\n");
				}
				inputField.setText("");//�������ı�����������Ϊ��
			}
		});
		JLabel jLabel = new JLabel("������Ϣ");
		inputPanel.add(jLabel);//����ǩ��ӵ��������
		inputPanel.add(inputField);//���ı�����ӵ��������
		inputPanel.add(btn);//�����Ͱ�ť��ӵ��������
		//�������������������ӵ�����
		this.add(showPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setTitle("chat we");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new DemoTextArea();
	}
}
