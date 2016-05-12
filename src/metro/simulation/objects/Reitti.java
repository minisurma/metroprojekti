package metro.simulation.objects;

import java.util.List;

public class Reitti{

	private Asema[] asemat;
	
	private static Reitti MR = new Reitti(Asema.Mellunmaki, Asema.Ruoholahti);
	private static Reitti VR = new Reitti(Asema.Vuosaari, Asema.Ruoholahti);
	private static Reitti RM = new Reitti(Asema.Ruoholahti, Asema.Mellunmaki);
	private static Reitti RV = new Reitti(Asema.Ruoholahti, Asema.Vuosaari);
	private static Reitti IM = new Reitti(Asema.Itakeskus, Asema.Mellunmaki);
	private static Reitti IV = new Reitti(Asema.Itakeskus, Asema.Vuosaari);
	private static Reitti IR = new Reitti(Asema.Itakeskus, Asema.Ruoholahti);
	
	public Reitti(Asema... asemat){
		this.asemat = asemat;
	}
	
	public Reitti(List<Asema> asemat){
		this.asemat = asemat.toArray(new Asema[asemat.size()]);
	}

	public Asema start() {
		return asemat[0];
	}
	
	public Asema end(){
		return asemat[asemat.length-1];
	}

	public static Reitti getReitti(String s) {
		switch(s){
		case "MR":
			return MR;
		case "VR":
			return VR;
		case "RM":
			return RM;
		case "RV":
			return RV;
		case "IM":
			return IM;
		case "IV":
			return IV;
		case "IR":
			return IR;
		}
		return null;
	}
	
}
