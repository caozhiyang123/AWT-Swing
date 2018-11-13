package cn.smartGame.AWT;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class DemoDrawLine
{
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		Panel panel = new MyPanel();
		frame.add(panel);
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);//设置窗口居中
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				e.getWindow().dispose();
			}
		});
	}
}
class MyPanel extends Panel{
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		int width = 160;
		int height = 40;
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, height);//填充背景
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width, height);//画边框
		//绘制干扰点
		Random random = new Random();
		for (int i = 0; i < 1000; i++)
		{
			int x = random.nextInt(width)-2;
			int y = random.nextInt(height)-2;
			g.drawOval(x, y, 2, 2);
		}
		//绘制干扰线
		for(int j = 0;j<30;j++){
			g.setColor(Color.YELLOW);
			g.drawLine(random.nextInt(width)-2, random.nextInt(height)-2, random.nextInt(width)-2, random.nextInt(height)-2);
		}
		for(int j = 0;j<30;j++){
			g.setColor(Color.RED);
			g.drawLine(random.nextInt(width)-2, random.nextInt(height)-2, random.nextInt(width)-2, random.nextInt(height)-2);
		}
		g.setFont(new Font("黑体", Font.BOLD, 30));//设置验证码字体
		g.setColor(Color.BLUE);//设置验证码颜色
		//产生随机验证码
		char[] chars = ("23456789abcdefijkmnpqrstuvwxy").toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++)
		{
			int pos = random.nextInt(chars.length);
			char c = chars[pos];
			g.drawString(String.valueOf(c), 20+30*i, 30);
			g.setColor(new Color(19+i*3, 20+i*4, 30+i*5));
		}
		
	}
	
}
