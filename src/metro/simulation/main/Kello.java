package com.metro.objects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.Timer;


public class Kello {
	
	public static void main (String [] args) {
		
		ClockLabel aika = new ClockLabel("time");
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame k = new JFrame("Kello");
		k.setSize(600, 300);
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.setLayout(new GridLayout(1, 1));
		
		k.add(aika);
		
		k.getContentPane().setBackground(Color.BLACK);
		
		k.setVisible(true);
		
	}
}
	
	class ClockLabel extends JLabel implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -3603220456071497075L;
		String type;
		SimpleDateFormat sdf;
		
		public ClockLabel (String type) {
			this.type = type;
			setForeground(new Color(255,69,0));
			
			switch (type) {
			
				case "time" : sdf = new SimpleDateFormat("hh:mm:ss");
							  setFont(new Font("sans-serif", Font.ITALIC, 100));
							  setHorizontalAlignment(SwingConstants.CENTER);
							  break;
				
				default		: sdf = new SimpleDateFormat();
							  break;
			
			}
			
			Timer t = new Timer(1000, (ActionListener) this);
			t.start();
		}

		public void actionPerformed(ActionEvent ae) {
			Date d = new Date();
			setText(sdf.format(d));
			
			
		}

	}

