package visitor;

import decorator.*;
import java.util.TimerTask;

public class ReparationTask extends TimerTask {
	
	private Mechanic mechano;
	private UrbanTravel ut;
		
	public ReparationTask(UrbanTravel urbanTravel , Mechanic mechanic) {
		this.mechano = mechanic;
		this.ut=urbanTravel;
	}
		
	public void run() {
		System.out.println(ut.accept(new Mechanic()) );
	}
		
}


