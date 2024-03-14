package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

public class ElectricScooterTest {

	private ElectricScooter scooter;
	
	@BeforeEach
	public void before() {
		scooter = new ElectricScooter(10,12,Status.UNAVAILABLE);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(10,scooter.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(10,scooter.getId());
		this.scooter.setId(8);
		assertEquals(8,scooter.getId());
	}
	
	
	@Test
	public void getStatusTest() {
		this.before();
		assertEquals(Status.UNAVAILABLE,scooter.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		assertEquals(Status.UNAVAILABLE,scooter.getStatus());
		scooter.setStatus(Status.OUT_OF_SERVICE);
		assertEquals(Status.OUT_OF_SERVICE,scooter.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		assertEquals(0,scooter.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		assertEquals(5,scooter.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		assertTrue(scooter.checkUrbanTravelAvailability());
	}
	
	@Test
	public void getBatteryLifeTest() {
		this.before();
		assertEquals(12,scooter.getBatteryLife());
	}
	
	@Test
	public void setBatteryLife() {
		this.before();
		assertEquals(12,scooter.getBatteryLife());
		scooter.setBatteryLife(20);
		assertEquals(20,scooter.getBatteryLife());
	}
	
	@Test
	public void toStringTest() {
		this.before();
		assertEquals("this ElectricScooter(trotinette) has the id : 10 , his status is : UNAVAILABLE and his autonomy is 12 hours ",scooter.toString());
	}
	@Test
	public void priceTest() {
		this.before();
		assertEquals(4,scooter.price());
	}
	
	/*
	@Test
	public void decorateScooterWithPhoneSupportAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new PhoneSupport(scooter);
		assertEquals(5,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ElectricScooter(trotinette) has the id : 10 , his status is : UNAVAILABLE and has a battery which has a life of 12 hours  and has a PhoneSupport for your GPS ");
	}
	*/
}
