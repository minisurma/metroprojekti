package com.metro.main;

import com.metro.objects.Asema;
import com.metro.objects.Metro;
import com.metro.objects.Reitti;

public class Main {

	public static void main(String[] args) {
		Metro metro = new Metro(0, new Reitti(Asema.Kontula, Asema.Mellunmaki));
	}

}
