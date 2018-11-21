package cn.smartGame.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.layout.Border;

public class DemoJLabel extends JFrame
{
	public DemoJLabel(){
		this.setLayout(new BorderLayout());
		this.setTitle("JLabel");
		JLabel jLabel = new JLabel("view");
		this.add(jLabel,BorderLayout.CENTER);
		JButton jButton = new JButton("change label text");
		this.add(jButton,BorderLayout.EAST);
		jButton.addActionListener(new ActionListener()
		{
			int i = 0;
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jLabel.setText("view"+ i++);
			}
		});
		this.setVisible(true);
		this.setSize(400, 300);
		this.setLocation(400, 300);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args)
	{
		new DemoJLabel();
	}
}
