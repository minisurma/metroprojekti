package com.metro.objects;

import java.util.ArrayList;
import java.util.List;

public class Metro {
	
	private int id;
	private List<Vaunu> vaunut = new ArrayList<Vaunu>();
	private Reitti reitti;
	
	public Metro(int id, Reitti reitti){
		this.id = id;
		this.reitti = reitti;
		this.luoVaunut(6);
	}
	
	public void luoVaunut(int pituus){
		for(int i = 0; i < pituus; i++){
			this.vaunut.add(new Vaunu());
		}
	}
}
