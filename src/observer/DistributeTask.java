package observer;

import java.util.TimerTask;

public class DistributeTask extends TimerTask {

	private ControlCenter controlCenter;
	
	public DistributeTask(ControlCenter controlCenter) {
		this.controlCenter = controlCenter;
	}
	
	@Override
	public void run() {
		System.out.println("------------------------- Une distribution est necessaire -------------------------");
		controlCenter.needRedistribution();
		for (Station st : controlCenter.getStations()) {
			System.out.println(st.getName() + " a : " + st.getCapacity() + " emplacements et le nombre de places occupees pour l'instant est : " + st.getOccupedSpaceCount()  + ". la liste des urbantravel : " + st.getUrbanTravels() );
		}
	}
	
}
