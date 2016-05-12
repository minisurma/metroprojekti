package metro.simulation.objects;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import metro.simulation.main.Main;

public class Asema {

	private int id;
	private String nimi;
	private Point east, west;
	
	public static final Asema Mellunmaki = new Asema(0, "Mellunmäki");
	public static final Asema Kontula = new Asema(1, "Kontula");
	public static final Asema Myllypuro = new Asema(2, "Myllypuro");
	public static final Asema Itakeskus = new Asema(3, "Itäkeskus");
	public static final Asema Siilitie = new Asema(4, "Siilitie");
	public static final Asema Herttoniemi = new Asema(5, "Herttoniemi");
	public static final Asema Kulosaari = new Asema(6, "Kulosaari");
	public static final Asema Kalasatama = new Asema(7, "Kalasatama");
	public static final Asema Sornainen = new Asema(8, "Sörnäinen");
	public static final Asema Hakaniemi = new Asema(9, "Hakaniemi");
	public static final Asema Helsingin_Yliopisto = new Asema(10, "Helsingin Yliopisto");
	public static final Asema Rautatieasema = new Asema(11, "Rautatieasema");
	public static final Asema Kamppi = new Asema(12, "Kamppi");
	public static final Asema Ruoholahti = new Asema(13, "Ruoholahti");
	public static final Asema Puotila = new Asema(14, "Puotila");
	public static final Asema Rastila = new Asema(15, "Rastila");
	public static final Asema Vuosaari = new Asema(16, "Vuosaari");
	
	public static final Asema[] asemat = new Asema[]{
		Mellunmaki, Kontula, Myllypuro, Itakeskus, Siilitie, Herttoniemi, Kulosaari, Kalasatama, Sornainen, 
		Hakaniemi, Helsingin_Yliopisto, Rautatieasema, Kamppi, Ruoholahti, Puotila, Rastila, Vuosaari
	};
	
	public Asema(){
		
	}
	
	public Asema(int id, String nimi){
		this.id = id;
		this.nimi = nimi;
		this.east = getEastPoint();
		this.west = getWestPoint();
	}

	private Point getEastPoint() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/resource/other/asemat.txt")));
			for(String line = reader.readLine(); line != null; line = reader.readLine()){
				if(line.startsWith(String.valueOf(this.id +" "))){
					int x = Integer.parseInt((line.split(", ")[0]).split(" ")[1]);
					int y = Integer.parseInt((line.split(", ")[1]).split(" ")[0]);
					return new Point(x, y);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Point getWestPoint() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/resource/other/asemat.txt")));
			for(String line = reader.readLine(); line != null; line = reader.readLine()){
				if(line.startsWith(String.valueOf(this.id +" "))){
					int x = Integer.parseInt((line.split(", ")[1]).split(" ")[1]);
					int y = Integer.parseInt((line.split(", ")[2]).split(" ")[0]);
					return new Point(x, y);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean sijaitsee(Point point) {
		if(this.east.equals(point) || this.west.equals(point)){
			return true;
		}
		return false;
	}
	
	public Point getLocation(){
		switch(id){
		case 0:
			return west;
		case 1:
			return east;
		case 2:
			return west;
		case 3:
			return east;
		case 13:
			return east;
		case 16: 
			return west;
		}
		return null;
	}

	public String getName() {
		return this.nimi;
	}
	
}
