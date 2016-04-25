package metro.simulation.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener, MouseWheelListener, Runnable{

	private static final long serialVersionUID = 817809648486114486L;
	
	public static final int width = 15, height = 10;
	
	private List<Chunk> chunks = new ArrayList<Chunk>();
	
	public Screen(Main frame){
		this.addMouseWheelListener(this);
		frame.addKeyListener(this);
		loadChunks();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Chunk chunk : chunks){
			chunk.draw(g);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Chunk.zoom(e.getWheelRotation() < 0 ? 1 : 2, e.getX(), e.getY());
	}
	
	private void loadChunks(){
		for(int x = 0; x < 15; x++){
			for(int y = 0; y < 10; y++){
				chunks.add(new Chunk(x, y));
			}
		}
	}

	@Override
	public void run() {
		while(true){
			try{
				repaint();
				Thread.sleep(15);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Chunk.additionx -= 10;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Chunk.additionx += ((Chunk.additionx+10) < 0 ? 10 : 0);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Chunk.additiony += ((Chunk.additiony+10) < 0 ? 10 : 0);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Chunk.additiony -= 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
