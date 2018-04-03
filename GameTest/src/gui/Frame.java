package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{
	
	PanelWCR panel=new PanelWCR();
	private static final int HEIGHT = 1080 , WIDTH = 1920 ;
	
	public Frame() {
		this.setVisible(true);
		this.setSize(WIDTH,HEIGHT);
		this.setTitle("FlipperMan v1.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		panel.setVisible(true);
		panel.width=WIDTH;
		panel.height=HEIGHT;
		
		new Thread(panel.returnSketcher()).start();
	}

}
