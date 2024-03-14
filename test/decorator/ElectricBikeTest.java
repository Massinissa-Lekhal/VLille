package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

public class ElectricBikeTest  {
	
	private ElectricBike electricBike;
	
	/*
	@Override
	public UrbanTravel createUrbanTravel() {
		return new ElectricBike(1,24,Status.AVAILABLE);
	}
	
	@Test
	public void getBatteryLifeTest() {
		UrbanTravel urbanTravel = this.createUrbanTravel();
		assertEquals(24,urbanTravel.getBatteryLife());
	}
	*/
	
	@BeforeEach
	public void before() {
		electricBike = new ElectricBike(3,7,Status.UNAVAILABLE);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(3,this.electricBike.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(3,this.electricBike.getId());
		this.electricBike.setId(45);
		assertEquals(45,this.electricBike.getId());
	}
	
	
	@Test
	public void getStatusTest() {
		this.before();
		assertEquals(Status.UNAVAILABLE,electricBike.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		assertEquals(Status.UNAVAILABLE,electricBike.getStatus());
		electricBike.setStatus(Status.AVAILABLE);
		assertEquals(Status.AVAILABLE,electricBike.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		assertEquals(0,electricBike.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		assertEquals(5,electricBike.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		assertTrue(electricBike.checkUrbanTravelAvailability());
	}
	
	@Test
	public void getBatteryLifeTest() {
		this.before();
		assertEquals(7,this.electricBike.getBatteryLife());
	}
	
	@Test
	public void setBatteryLife() {
		this.before();
		assertEquals(7,this.electricBike.getBatteryLife());
		this.electricBike.setBatteryLife(10);
		assertEquals(10,this.electricBike.getBatteryLife());
	}
	
	@Test
	public void toStringTest() {
		this.before();
		assertEquals("this ElectricBike has the id : 3 , his status is : UNAVAILABLE and his autonomy is 7 hours ",electricBike.toString());
	}
	@Test
	public void priceTest() {
		this.before();
		assertEquals(3,electricBike.price());
	}
	
	/*
	@Test
	public void decorateElectricBikeWithLuggageRacksAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new LuggageRacks(electricBike,2);
		assertEquals(6,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ElectricBike has the id : 3 , his status is : UNAVAILABLE and has a battery which has a life of 7 hours  and has 2 luggageRacks where you can store your things for example ");
	}
	
	@Test
	public void decorateElectricBikeWithBasketAndPhoneSupportAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new PhoneSupport(new Basket(electricBike,10));
		assertEquals(4.5,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ElectricBike has the id : 3 , his status is : UNAVAILABLE and has a battery which has a life of 7 hours  and has a basket which resist until 10 KG  and has a PhoneSupport for your GPS ");
	}
	*/
}
