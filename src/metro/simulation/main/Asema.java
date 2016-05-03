package com.metro.objects;

public class Asema {

	private int id;
	private String nimi;
	
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
	
	public Asema(){
		
	}
	
	public Asema(int id, String nimi){
		this.id = id;
		this.nimi = nimi;
	}
}
