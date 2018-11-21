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
	Panel cardPanel = new Panel();//定义面板放置卡片
	Panel btnPanel = new Panel();//定义面板放置按钮
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
		cardPanel.setLayout(cardLayout);//设置card面板为卡片布局管理器
		//在card面板添加三个文本标签
		cardPanel.add(new Label("第一个界面", Label.CENTER));
		cardPanel.add(new Label("第二个界面", Label.CENTER));
		cardPanel.add(new Label("第三个界面", Label.CENTER));
		cardPanel.add(DrawRTPLine.jp1);
		cardPanel.add(DrawRTPLine.jp2);
		cardPanel.add(DrawRTPLine.jp3);
		//创建2个按钮对象
		nextBtn = new Button("下一张卡片");
		preBtn = new Button("上一张卡片");
		//为按钮对象注册监听器
		nextBtn.addActionListener(this);
		preBtn.addActionListener(this);
		//将按钮添加到btnPanel中
		btnPanel.add(nextBtn);
		btnPanel.add(preBtn);
		this.add(cardPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
	//下面的代码实现了按钮的监听触发，并对触发事件做出相应的处理
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//如果用户单击nextBtn
		if(e.getSource() == nextBtn){
			//切换cardPanel面板中当前组件之后的一个组件
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
