package decorator;

import util.Status;
import visitor.*;

public interface UrbanTravel {
	
	public int getId();
	public void setId(int newId);
	public double price();
	public Status getStatus();
	public void setStatus(Status newStatus);
	public int getNbUsed();
	public void setNbUsed();
	public void setNbUsedToZero();
	public int getMaxNbUsed();
	public boolean checkUrbanTravelAvailability();
	public String accept(AbstractVisitor abstractVisitor);
	public String toString();
}
