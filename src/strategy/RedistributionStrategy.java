package strategy;

import observer.*;
import java.util.*;

public interface RedistributionStrategy {
	
	public void redistributeUrbanTravel(Station src , Station dst);
	public void redistribute(List<Station> stations);
}
