package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;


public class ClassicBikeTest {
	
	private ClassicBike classicBike;
	
	/*
	@Override
	public UrbanTravel createUrbanTravel() {
		return new ClassicBike(1,Status.AVAILABLE);
	}
	
	@Test
	public void priceTest() {
		UrbanTravel urbanTravel = this.createUrbanTravel();
		assertEquals(2,urbanTravel.price());
	}
	
	
	*/
	@BeforeEach
	public void before() {
		classicBike = new ClassicBike(1,Status.AVAILABLE);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(1,this.classicBike.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(1,this.classicBike.getId());
		this.classicBike.setId(2);
		assertEquals(2,this.classicBike.getId());
	}
	
	
	@Test
	public void getStatusTest() {
		this.before();
		assertEquals(Status.AVAILABLE,classicBike.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		assertEquals(Status.AVAILABLE,classicBike.getStatus());
		classicBike.setStatus(Status.UNAVAILABLE);
		assertEquals(Status.UNAVAILABLE,classicBike.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		assertEquals(0,classicBike.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		assertEquals(5,classicBike.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		assertTrue(classicBike.checkUrbanTravelAvailability());
	}
	
	@Test
	public void toStringTest() {
		this.before();
		assertEquals("this ClassicBike has the id : 1 , his status is : AVAILABLE",classicBike.toString());
	}
	@Test
	public void priceTest() {
		this.before();
		assertEquals(2,classicBike.price());
	}
	
	/*
	@Test
	public void decorateClassicBikeWithBasketAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new Basket(classicBike,5);
		assertEquals(2.5,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ClassicBike has the id : 1 , his status is : AVAILABLE and has a basket which resist until 5 KG ");
	}
	
	@Test
	public void decorateClassicBikeWithBasketAndLuggageRacksAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new LuggageRacks(new Basket(classicBike,10),2);
		assertEquals(5.5,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ClassicBike has the id : 1 , his status is : AVAILABLE and has a basket which resist until 10 KG  and has 2 luggageRacks where you can store your things for example ");
	}
	*/

}
