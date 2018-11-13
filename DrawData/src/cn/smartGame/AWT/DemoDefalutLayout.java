package cn.smartGame.AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DemoDefalutLayout
{
	public static void main(String[] args)
	{
		Frame frame = new Frame("hello");
		frame.setLayout(null);
		frame.setSize(300, 200);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				e.getWindow().dispose();
			}
		});
		Button btn1 = new Button("press");
		Button btn2 = new Button("pop");
//		btn1.setSize(40,60);
//		btn1.setLocation(100, 30);
		btn1.setBounds(40,60,100,30);
		btn2.setBounds(140,90,100,30);
		frame.add(btn1);
		frame.add(btn2);
		frame.setVisible(true);
	}
}
