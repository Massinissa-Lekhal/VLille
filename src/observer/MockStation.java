package observer;

import decorator.UrbanTravel;
import util.Status;
import visitor.Client;
import visitor.Mechanic;

public class MockStation extends Station {
	
	public int notifyObserverCalled = 0;
	
	public MockStation(int id, String name) {
		super(id,name);
	}
	
	public void addUrbanTravel(UrbanTravel urbanTravel) {
		if (getOccupedSpaceCount()<getCapacity()) {
			this.urbanTravels.add(urbanTravel);
			notifyObserver();
			this.notifyObserverCalled++;
		}
		else {
			System.out.println("Seul " + getCapacity() + " urvabTravels ont ete rajoute avec succes vu que la station est pleine !!!");		
		}
	}
	
	public void removeUrbanTravel(UrbanTravel urbanTravel) {
		this.urbanTravels.remove(urbanTravel);
		notifyObserver();
		this.notifyObserverCalled++;
	}
	
	public void rent() {
		boolean found = false;
		if (getOccupedSpaceCount() > 0) {
			for (UrbanTravel urbanTravel : urbanTravels) {
				if (urbanTravel.getStatus() == Status.AVAILABLE  && urbanTravel.checkUrbanTravelAvailability() ) {
					this.urbanTravels.remove(urbanTravel);
					urbanTravel.setStatus(Status.UNAVAILABLE);
					urbanTravel.setNbUsed();
					notifyObserver();
					this.notifyObserverCalled++;
					found = true;
					System.out.println(getName() + " : " + urbanTravel.accept(new Client()));
					break;
				}
			}
			if (!found) {
				System.out.println("Rent urbanTravel impossible : Pas d'urbanTravel disponible dans la " + getName() );
			}
		}
		else {
			System.out.println("Rent urbanTravel impossible : la " + getName() + " est vide ");
		}
		
	}
	
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
}
