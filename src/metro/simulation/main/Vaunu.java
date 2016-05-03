package com.metro.objects;

import javafx.scene.paint.Color;

public class Vaunu {

	private static int vaununumerot = 0;
	
	private int vaununumero;
	private Color c;
	
	public Vaunu(int vaununumero, Color c){
		this.vaununumero = vaununumero;
		this.c = c;
	}
	
	public Vaunu(){
		this.vaununumero = vaununumerot++;
		this.c = Color.ORANGE;
	}
}
