package metro.simulation.objects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import metro.simulation.main.Screen;

public class Metro extends Thread{
	
	private List<Vaunu> vaunut = new ArrayList<Vaunu>();
	private Reitti reitti;
	
	private long begin;
	private double fps = 0.066;
	private boolean delete = false;
	
	public Metro(Reitti reitti){
		this.reitti = reitti;
		this.luoVaunut(reitti.start().getLocation().x, reitti.start().getLocation().y, 20);
		this.start();
	}
	
	public void luoVaunut(int x, int y, int pituus){
		int vaunux = x;
		int vaunuy = y;
		for(int i = 0; i < pituus; i++){
			Vaunu vaunu = new Vaunu(vaunux, vaunuy, this);
			this.vaunut.add(vaunu);
			vaunux = vaunu.getX();
			vaunuy = vaunu.getY();
		}
	}
	
	public void draw(Graphics g){
		for(Vaunu vaunu : vaunut){
			vaunu.draw(g);
		}
	}

	public void move() {
		for(Vaunu vaunu : vaunut){
			vaunu.move();
		}
	}
	
	private void updateSpeed() {
		Asema asema = this.vaunut.get(this.vaunut.size()-1).onStation();
		if(asema != null){
			if(this.reitti.end() == asema){
				delete = true;
			}
			this.fps = 0.066;
		}
		else{
			this.fps = 10;
		}
	}
	
	@Override
	public void run(){
		while(!delete){
			try{
				begin = System.currentTimeMillis();
				move();
				long delay = (long)((1000/fps)-(System.currentTimeMillis()-begin));
				Thread.sleep(delay > 0 ? delay : 15);
				updateSpeed();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		Screen.metrot.remove(this);
		this.interrupt();
	}

	public boolean toPurple() {
		if(this.reitti.end().equals(Asema.Vuosaari)){
			return true;
		}
		return false;
	}
}
