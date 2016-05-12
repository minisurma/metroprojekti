package metro.simulation.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chunk {
	
	public static double zoom = 1.0;
	
	public static int additionx = 0;
	public static int additiony = 0;
	public static int imagewidth;
	
	private int x, y;
	private BufferedImage image;
	
	public Chunk(int x, int y){
		this.x = x;
		this.y = y;
		this.image = getImage(x, y);
		imagewidth = image.getWidth();
	}
	
	public void draw(Graphics g){
		g.drawImage(this.image, (int) (x*zoom*image.getWidth()+additionx), (int) (y*zoom*image.getHeight()+additiony), (int) (zoom*image.getWidth()+1), (int) (zoom*image.getHeight()+1), null);
	}

	private BufferedImage getImage(int x, int y) {
		try {
			return ImageIO.read(Main.class.getResource("/resource/mapdata/" +(x*Screen.height+y) +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void zoom(int direction, int x, int y){
		if(direction == 1){
			additionx = -(int)(((-additionx+x)*(imagewidth/zoom))/(imagewidth/(zoom+0.05))-x);
			additiony = -(int)(((-additiony+y)*(imagewidth/zoom))/(imagewidth/(zoom+0.05))-y);
			zoom += 0.05;
		}
		else{
			if(zoom >= 0.1){
				int newadditionx = -(int)(((-additionx+x)*(imagewidth/zoom))/(imagewidth/(zoom-0.05))-x);
				additionx = newadditionx < 0 ? newadditionx : 0;
				int newadditiony = -(int)(((-additiony+y)*(imagewidth/zoom))/(imagewidth/(zoom-0.05))-y);
				additiony = newadditiony < 0 ? newadditiony : 0;
				zoom -= 0.05;
			}
		}
	}
	
}
