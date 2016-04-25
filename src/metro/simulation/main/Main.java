package metro.simulation.main;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame{

	public static Screen screen;
	private static final long serialVersionUID = 5206780620600966935L;

	public Main(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-getHeight()/2);
		setTitle("Metro simulaatio");
		setResizable(true);
		screen = new Screen(this);
		add(screen);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
}
