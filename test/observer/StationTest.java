package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

import decorator.*;

class StationTest {
	
	private Station station ;
	
	@BeforeEach
	public void before() {
		station = new Station(1,"Lille Flandre");
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(1,station.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(1,station.getId());
		station.setId(2);
		assertEquals(2,station.getId());
	}
	
	@Test
	public void getNameTest() {
		this.before();
		assertEquals("Lille Flandre",station.getName());
	}
	
	@Test
	public void setNameTest() {
		this.before();
		assertEquals("Lille Flandre",station.getName());
		station.setName("Lille Flandre 1");
		assertEquals("Lille Flandre 1",station.getName());
	}
	
	@Test 
	public void getCapacityTest() {
		this.before();
		assertTrue(station.getCapacity()>=10 && station.getCapacity()<=20);
	}
	
	@Test
	public void setCapacityTest() {
		this.before();
		assertTrue(station.getCapacity()>=10 && station.getCapacity()<=20);
		station.setCapacity(20);
		assertEquals(20,station.getCapacity());
	}
	
	@Test
	public void addUrbanTravelWhenOk() {
		this.before();
		station.setCapacity(2);
		ClassicBike classicBike = new ClassicBike(1,Status.AVAILABLE);
		ElectricBike electricBike = new ElectricBike(2,10,Status.AVAILABLE);
		ElectricScooter electricScooter = new ElectricScooter(3,24,Status.AVAILABLE);
		station.addUrbanTravel(classicBike);
		station.addUrbanTravel(electricBike);
		station.addUrbanTravel(electricScooter);
		assertEquals(2,station.getCapacity());
		
	}
	
	@Test
	public void getOccupedTest() {
		this.before();
		assertEquals(0,station.getOccupedSpaceCount());
		UrbanTravel classicBike = new ClassicBike(4,Status.AVAILABLE);
		station.addUrbanTravel(classicBike);
		assertEquals(1,station.getOccupedSpaceCount());
		station.removeUrbanTravel(classicBike);
		assertEquals(0,station.getOccupedSpaceCount());
	}
	
	@Test
	public void rentTest() {
		this.before();
		UrbanTravel classicBike = new ClassicBike(1,Status.AVAILABLE);
		ElectricBike electricBike = new ElectricBike(2,10,Status.AVAILABLE);
		UrbanTravel electricScooter = new ElectricScooter(3,24,Status.AVAILABLE);
		
		UrbanTravel classicBikeBroken = new ClassicBike(34,Status.OUT_OF_SERVICE);
		
		station.rent();
		
		station.addUrbanTravel(classicBikeBroken);
		station.addUrbanTravel(classicBike);
		station.addUrbanTravel(electricBike);
		station.addUrbanTravel(electricScooter);
		
		station.getUrbanTravels().get(0).setStatus(Status.OUT_OF_SERVICE);
		
		assertEquals(4,station.getOccupedSpaceCount());
		int nbBeforeRent = classicBike.getNbUsed();
		station.rent(); 
		assertTrue(classicBike.getNbUsed() == nbBeforeRent+1);
		assertEquals(3,station.getOccupedSpaceCount());
		int nbBeforeRent1 = electricBike.getNbUsed();
		station.rent();
		assertTrue(electricBike.getNbUsed() == nbBeforeRent1+1);
		assertEquals(2,station.getOccupedSpaceCount());
		int nbBeforeRent2 = electricScooter.getNbUsed();
		station.rent();
		assertTrue(electricScooter.getNbUsed() == nbBeforeRent2+1);
		assertEquals(1,station.getOccupedSpaceCount());
		int nbBeforeRentBroken = classicBikeBroken.getNbUsed();
		station.rent();
		assertEquals(classicBikeBroken.getNbUsed(),nbBeforeRentBroken);
		
		assertTrue(station.getUrbanTravels().get(0) instanceof ClassicBike);
	}
	
	@Test
	public void notifyObserverTest() {
		MockStation mockStation = new MockStation(1,"stationMock");
		mockStation.rent();
		assertEquals(0,mockStation.notifyObserverCalled);
		UrbanTravel electricBike = new ElectricBike(2,10,Status.UNAVAILABLE);
		UrbanTravel electricScooter = new ElectricScooter(3,24,Status.UNAVAILABLE);
		mockStation.addUrbanTravel(electricScooter);
		mockStation.addUrbanTravel(electricBike);
		assertEquals(2,mockStation.notifyObserverCalled);
		mockStation.removeUrbanTravel(electricBike);
		assertEquals(3,mockStation.notifyObserverCalled);
		mockStation.rent();
		assertEquals(3,mockStation.notifyObserverCalled);
		electricScooter.setStatus(Status.AVAILABLE);
		mockStation.rent();
		assertEquals(4,mockStation.notifyObserverCalled);
		mockStation.rent();
		assertEquals(4,mockStation.notifyObserverCalled);
		
	}
	
}
