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
		JScrollPane showPanel = new JScrollPane(chatContent);//创建滚动面板并将文本域作为其显示组件
		chatContent.setEditable(false);//设置文本域不可编辑
		JPanel inputPanel = new JPanel();//创建一个面板
		inputField = new JTextField(20);//创建一个文本框
		btn = new JButton("send");//创建发送按钮
		//为按钮添加事件
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = inputField.getText();
				if(text !=null && !text.trim().equals("")){
					//如果不为空，将内容追加到聊天窗口
					chatContent.append(text+"\n");
				}else{
					//提示聊天信息不能为空
					chatContent.append("不能为空"+"\n");
				}
				inputField.setText("");//将输入文本框内容设置为空
			}
		});
		JLabel jLabel = new JLabel("聊天信息");
		inputPanel.add(jLabel);//将标签添加到聊天面板
		inputPanel.add(inputField);//将文本框添加到聊天面板
		inputPanel.add(btn);//将发送按钮添加到聊天面板
		//将滚动面板和输入面板添加到窗体
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
