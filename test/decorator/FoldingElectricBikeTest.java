package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

public class FoldingElectricBikeTest {

	private FoldingElectricBike foldingElectricBike;
	
	@BeforeEach
	public void before() {
		foldingElectricBike = new FoldingElectricBike(7,72,Status.OUT_OF_SERVICE);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(7,foldingElectricBike.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(7,foldingElectricBike.getId());
		foldingElectricBike.setId(8);
		assertEquals(8,foldingElectricBike.getId());
	}
	
	@Test
	public void getStatusTest() {
		this.before();
		assertEquals(Status.OUT_OF_SERVICE,foldingElectricBike.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		assertEquals(Status.OUT_OF_SERVICE,foldingElectricBike.getStatus());
		foldingElectricBike.setStatus(Status.AVAILABLE);
		assertEquals(Status.AVAILABLE,foldingElectricBike.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		assertEquals(0,foldingElectricBike.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		assertEquals(5,foldingElectricBike.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		assertTrue(foldingElectricBike.checkUrbanTravelAvailability());
	}
	
	@Test
	public void getBatteryLifeTest() {
		this.before();
		assertEquals(72,foldingElectricBike.getBatteryLife());
	}
	
	@Test
	public void setBatteryLifeTest() {
		this.before();
		assertEquals(72,foldingElectricBike.getBatteryLife());
		foldingElectricBike.setBatteryLife(100);
		assertEquals(100,foldingElectricBike.getBatteryLife());
	}
	
	@Test
	public void toStringTest() {
		this.before();
		assertEquals("this ElectricBike has the id : 7 , his status is : OUT_OF_SERVICE and his autonomy is 72 hours  (the difference between this type of bike and a electric bike is that it is folding) ",foldingElectricBike.toString());
	}
	@Test
	public void priceTest() {
		this.before();
		assertEquals(3.5,foldingElectricBike.price());
	}
	
	/*
	@Test
	public void decorateFoldingElectricBikeWithLuggageRacksAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new LuggageRacks(foldingElectricBike,2);
		assertEquals(6,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ElectricBike has the id : 7 , his status is : OUT_OF_SERVICE and has a battery which has a life of 72 hours  (the difference between this type of bike and a electric bike is that it is folding)  and has 2 luggageRacks where you can store your things for example ");
	}
	*/
}
