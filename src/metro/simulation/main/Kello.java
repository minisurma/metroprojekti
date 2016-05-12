package metro.simulation.main;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import metro.simulation.objects.Metro;
import metro.simulation.objects.Reitti;

public class Kello extends Thread{

	private int hour, min, sec;
	
	private long lastFrame;
	
	public Kello(){
		this.hour = LocalDateTime.now().getHour();
		this.min = LocalDateTime.now().getMinute();
		this.sec = LocalDateTime.now().getSecond();
		this.start();
	}
	
	public void draw(Graphics g){
		g.drawString((hour < 10 ? ("0"+hour) : hour) +" : " +(min < 10 ? ("0"+min) : min) +" : " +(sec < 10 ? ("0"+sec) : sec), 10, 20);
	}
	
	@Override
	public void run(){
		while(true){
			try{
				lastFrame = System.currentTimeMillis();
				if(this.sec >= 59){
					this.sec = 0;
					luoMetrot();
					if(this.min >= 59){
						this.min = 0;
						if(this.hour >= 23){
							this.hour = 0;
						}
						else{
							this.hour++;
						}
					}
					else{
						this.min++;
					}
				}
				else{
					this.sec++;
				}
				long aika = 1000-(System.currentTimeMillis()-lastFrame);
				Thread.sleep(aika > 0 ? aika : 10);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	private void luoMetrot() {
		String[] tiedostot = new String[]{"MR", "VR", "RM", "RV", "IM", "IV", "IR"};
		for(String s : tiedostot){
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/resource/other/" +s +".txt")));
				for(String line = reader.readLine(); line != null; line = reader.readLine()){
					if(line.contains((hour < 10 ? ("0"+hour) : hour) +"." +(min < 10 ? ("0"+min) : min))){
						Screen.lisättävät.add(new Metro(Reitti.getReitti(s)));
					}
				}
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
