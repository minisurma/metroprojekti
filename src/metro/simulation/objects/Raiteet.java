package metro.simulation.objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import metro.simulation.main.Main;

public class Raiteet {

	public static BufferedImage raiteet;
	
	public static void loadRails(){
		try {
			raiteet = ImageIO.read(Main.class.getResource("/resource/mapdata/rails.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
