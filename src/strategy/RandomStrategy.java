package strategy;

import observer.*;
import java.util.*;

import decorator.UrbanTravel;

public class RandomStrategy implements RedistributionStrategy {
	
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
     * Gets a random station from a list of stations, excluding a specified station.
     *
     * @param stations The list of stations.
     * @param exclude  The station to exclude.
     * @return A random station from the list (excluding the specified station).
     */
	public Station getRandomStation(List<Station> stations , Station exclude) {
		List<Station> availableStations = new ArrayList<>(stations);
		availableStations.remove(exclude);
		return availableStations.get(new Random().nextInt(availableStations.size()));
	}
	
	/**
     * Redistributes urban travels among a list of stations using the random strategy.
     *
     * @param stations The list of stations to redistribute urban travels.
     */
	@Override
	public void redistribute(List<Station> stations) {
		Collections.shuffle(stations);
		for (Station src : stations) {
			Station dst = getRandomStation(stations,src);
			redistributeUrbanTravel(src,dst);
		}
	}
	
}
