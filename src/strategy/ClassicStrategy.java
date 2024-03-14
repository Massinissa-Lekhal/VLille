package strategy;

import decorator.*;
import observer.*;
import java.util.*;

public class ClassicStrategy implements RedistributionStrategy {
	
	/**
     * Redistributes an urban travel from the source station to the destination station.
     * If the source station has more than 3 urban travels, one is moved to the destination station.
     *
     * @param src The source station.
     * @param dst The destination station.
     */
	@Override
	public void redistributeUrbanTravel(Station src , Station dst) {
		if (src.getOccupedSpaceCount()>3) {
			UrbanTravel urbanTravel = src.getUrbanTravels().get(0);
			src.removeUrbanTravel(urbanTravel);
			dst.addUrbanTravel(urbanTravel);
		}
		else {
			System.out.println("La station " + src.getName()  + " ne contient pas trop d'urbanTravel (il faut minimum 4 urbanTravel dans la station)");
		}
	}
	
	/**
     * Redistributes urban travels among a list of stations using the classic strategy.
     *
     * @param stations The list of stations to redistribute urban travels.
     */
	@Override
	public void redistribute(List<Station> stations) {
		int currentIndex = 0;
		for (Station station : stations) {
			redistributeUrbanTravel(station,stations.get(currentIndex));
			currentIndex = (currentIndex+1)%stations.size();
		}
	}
}
