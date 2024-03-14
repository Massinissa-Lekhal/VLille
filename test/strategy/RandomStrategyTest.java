package strategy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decorator.ClassicBike;
import decorator.ElectricBike;
import decorator.ElectricScooter;
import decorator.FoldingClassicBike;
import decorator.FoldingElectricBike;
import observer.ControlCenter;
import observer.Station;
import util.Status;

class RandomStrategyTest {

	private Station src;
	private Station dst;
	private Station station;
	private List<Station> stations ;
	
	private ClassicBike classicBike;
	private ElectricBike electricBike;
	private ElectricScooter electricScooter;
	private FoldingClassicBike foldingClassicBike;
	private FoldingElectricBike foldingElectricBike;
	
	private RedistributionStrategy redistributionStrategy;
	private ControlCenter controlCenter;
	
	@BeforeEach
	public void before() {
		src = new Station(10,"lille flandre");
		dst = new Station(20,"rihour");
		station = new Station(30,"caulier");
		stations = new ArrayList<>();
		stations.add(src);
		stations.add(dst);
		stations.add(station);
		
		classicBike = new ClassicBike(1,Status.AVAILABLE);
		electricBike = new ElectricBike(2,10,Status.AVAILABLE);
		electricScooter = new ElectricScooter(3,24,Status.AVAILABLE);
		foldingClassicBike = new FoldingClassicBike(4,Status.OUT_OF_SERVICE);
		foldingElectricBike = new FoldingElectricBike(7,72,Status.OUT_OF_SERVICE);
		
		redistributionStrategy = new RandomStrategy();
		
		controlCenter = new ControlCenter(100,"lille centre",stations,redistributionStrategy,2);
	}
	
	@Test
	public void redistributeUrbanTravelTest() {
		this.before();
		src.addUrbanTravel(classicBike);
		src.addUrbanTravel(electricBike);
		src.addUrbanTravel(electricScooter);
		src.addUrbanTravel(foldingClassicBike);
		src.addUrbanTravel(foldingElectricBike);
		
		redistributionStrategy.redistributeUrbanTravel(src,dst);	
		assertEquals(4,src.getOccupedSpaceCount());
		assertEquals(1,dst.getOccupedSpaceCount());
		
		redistributionStrategy.redistributeUrbanTravel(src,dst);	
		assertEquals(3,src.getOccupedSpaceCount());
		assertEquals(2,dst.getOccupedSpaceCount());
		
		redistributionStrategy.redistributeUrbanTravel(src,dst);
		assertEquals(3,src.getOccupedSpaceCount());
		assertEquals(2,dst.getOccupedSpaceCount());
	}
	
	@Test
	public void getRandomStationTest() {
		this.before();
		Station excludeStation = src;
		Station randomStation = new RandomStrategy().getRandomStation(stations, excludeStation);
		assertNotEquals(excludeStation,randomStation);
		assertTrue(stations.contains(randomStation));
	}
	
	@Test
	public void redistributeTest() {
		this.before();
		redistributionStrategy.redistribute(stations);
		
	}

}
