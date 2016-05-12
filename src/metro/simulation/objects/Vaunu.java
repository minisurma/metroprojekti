package metro.simulation.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import metro.simulation.main.Chunk;
import metro.simulation.main.Main;

public class Vaunu {
	
	private static BufferedImage vaunu;
	
	private static final Color blue = new Color(0, 0, 255);
	private static final Color red = new Color(255, 0, 0);
	private static final Color purple = new Color(255, 0, 255);
	private static final Color green = new Color(0, 255, 0);
	
	private int x, y;
	private Metro metro;
	
	public Vaunu(int x, int y){
		if(vaunu == null){
			try{
				vaunu = ImageIO.read(Main.class.getResource("/resource/other/metro.png"));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(vaunu, (int) (this.x*Chunk.zoom+Chunk.additionx), (int) (this.y*Chunk.zoom-vaunu.getHeight()/2+Chunk.additiony), (int) ((Chunk.zoom > 1 ? Chunk.zoom : 1)*vaunu.getWidth()+1), (int) ((Chunk.zoom > 1 ? Chunk.zoom : 1)*vaunu.getHeight()), null);
	}
	
	public Vaunu(int x, int y, Metro metro){
		this(spawn(x, y).x, spawn(x, y).y);
		this.metro = metro;
	}

	public void move() {
		BufferedImage raiteet = Raiteet.raiteet;
		Color c = new Color(raiteet.getRGB(this.x, this.y));
		if(c.equals(blue)){
			if(this.x == 8660 && this.y == 2852 && this.metro.toPurple()){
				this.x++;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y-1)).equals(blue)){ //NE
				this.x++;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y-1)).equals(blue)){//N
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y)).equals(blue)){//E
				this.x++;
			}
			else if(new Color(raiteet.getRGB(this.x-1, this.y-1)).equals(blue)){//NW
				this.x--;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y+1)).equals(blue)){//SE
				this.x++;
				this.y++;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y+1)).equals(blue)){//S
				this.y++;
			}
		}
		else if(c.equals(red)){
			if(new Color(raiteet.getRGB(x-1, y+1)).equals(red)){ //SW
				this.x--;
				this.y++;
			}
			else if(new Color(raiteet.getRGB(x-1, y)).equals(red)){ //W
				this.x--;
			}
			else if(new Color(raiteet.getRGB(x, y+1)).equals(red)){ //S
				this.y++;
			}
			else if(new Color(raiteet.getRGB(x+1, y+1)).equals(red)){ //SE
				this.x++;
				this.y++;
			}
			else if(new Color(raiteet.getRGB(x-1, y-1)).equals(red)){ //NW
				this.x--;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(x+1, y)).equals(red)){ //E
				this.x++;
			}
		}
		else if(c.equals(purple)){
			if(this.x == 8660 && this.y == 2852){
				this.x++;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y+1)).equals(purple)){//SE
				this.x++;
				this.y++;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y-1)).equals(purple)){ //NE
				this.x++;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y+1)).equals(purple)){//S
				this.y++;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y)).equals(purple)){//E
				this.x++;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y-1)).equals(purple)){//N
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x-1, this.y-1)).equals(purple)){//NW
				this.x--;
				this.y--;
			}
		}
		else if(c.equals(green)){
			if(this.x == 8646 && this.y == 2847){
				this.x--;
			}
			else if(new Color(raiteet.getRGB(this.x-1, this.y+1)).equals(green)){//SW
				this.x--;
				this.y++;
			}
			else if(new Color(raiteet.getRGB(this.x-1, this.y)).equals(green)){//W
				this.x--;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y-1)).equals(green)){//N
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x-1, this.y-1)).equals(green)){//NW
				this.x--;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y-1)).equals(green)){ //NE
				this.x++;
				this.y--;
			}
			else if(new Color(raiteet.getRGB(this.x, this.y+1)).equals(green)){//S
				this.y++;
			}
			else if(new Color(raiteet.getRGB(this.x+1, this.y)).equals(green)){//E
				this.x++;
			}
		}
	}
	
	public static Point spawn(int x, int y) {
		BufferedImage raiteet = Raiteet.raiteet;
		Color c = new Color(raiteet.getRGB(x, y));
		if(c.equals(blue)){
			if(new Color(raiteet.getRGB(x+1, y-1)).equals(blue)){ //NE
				return new Point(x+1, y-1);
			}
			else if(new Color(raiteet.getRGB(x, y-1)).equals(blue)){//N
				return new Point(x, y-1);
			}
			else if(new Color(raiteet.getRGB(x+1, y)).equals(blue)){//E
				return new Point(x+1, y);
			}
			else if(new Color(raiteet.getRGB(x-1, y-1)).equals(blue)){//NW
				return new Point(x-1, y-1);
			}
			else if(new Color(raiteet.getRGB(x+1, y+1)).equals(blue)){//SE
				return new Point(x+1, y+1);
			}
			else if(new Color(raiteet.getRGB(x, y+1)).equals(blue)){//S
				return new Point(x, y+1);
			}
			
		}
		else if(c.equals(red)){
			if(new Color(raiteet.getRGB(x-1, y+1)).equals(red)){ //SW
				return new Point(x-1, y+1);
			}
			else if(new Color(raiteet.getRGB(x-1, y)).equals(red)){ //W
				return new Point(x-1, y);
			}
			else if(new Color(raiteet.getRGB(x, y+1)).equals(red)){ //S
				return new Point(x, y+1);
			}
		}
		else if(c.equals(green)){
			if(new Color(raiteet.getRGB(x-1, y+1)).equals(green)){
				return new Point(x-1, y+1);
			}
			else if(new Color(raiteet.getRGB(x-1, y)).equals(green)){ //W
				return new Point(x-1, y);
			}
			else if(new Color(raiteet.getRGB(x, y+1)).equals(green)){ //S
				return new Point(x, y+1);
			}
		}
		System.out.println(x +", " +y);
		return null;
	}

	public Asema onStation() {
		for(Asema asema : Asema.asemat){
			if(asema.sijaitsee(new Point(this.x, this.y))){
				return asema;
			}
		}
		return null;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
