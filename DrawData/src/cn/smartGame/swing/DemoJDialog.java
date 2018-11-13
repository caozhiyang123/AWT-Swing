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
		//建立两个按钮
		JButton btn1 = new JButton("模态对话框");
		JButton btn2 = new JButton("非模态对话框");
		JFrame f = new JFrame("DemoJDialog");
		f.setSize(300, 250);
		f.setLocation(300,200);
		f.setLayout(new FlowLayout());
		//添加按钮
		f.add(btn1);
		f.add(btn2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置点击关闭按钮默认窗口
		f.setVisible(true);
		final JLabel jLabel = new JLabel();
		final JDialog jDialog = new JDialog(f,"jDialog");//创建指定标题的模态对话框
		jDialog.setSize(220, 150);
		jDialog.setLocation(350,250);
		jDialog.setLayout(new FlowLayout());
		JButton btn3 = new JButton("确定");
		jDialog.add(btn3);//在对话框面板添加按钮
		//为模态对话框按钮btn1添加点击事件
		btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//手动设置对话框为模态对话框
				jDialog.setModal(true);
				//如果jDialog窗口中没有添加JLabel组件，就把JLabel组件添加上
				if(jDialog.getComponents().length == 1){
					jDialog.add(jLabel);
				}
					//否则修改标签内容
					jLabel.setText("模式对话框，点击确定按钮关闭");
					jDialog.setVisible(true);
				
			}
		});
		//为模态对话框按钮btn2添加点击事件
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//设置对话框为非模态
				jDialog.setModal(false);
				//如果jDialog窗口中没有添加JLabel组件，就把JLabel组件添加上
				if(jDialog.getComponents().length == 1){
					jDialog.add(jLabel);
				}
					//否则修改标签内容
					jLabel.setText("非模式对话框，点击确定按钮关闭");
					jDialog.setVisible(true);
				
			}
			
		});
		//为模态对话框按钮btn3添加点击事件
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
