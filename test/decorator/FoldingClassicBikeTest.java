package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

public class FoldingClassicBikeTest {

	private FoldingClassicBike foldingClassicBike;
	
	@BeforeEach
	public void before() {
		foldingClassicBike = new FoldingClassicBike(4,Status.OUT_OF_SERVICE);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(4,foldingClassicBike.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(4,foldingClassicBike.getId());
		foldingClassicBike.setId(8);
		assertEquals(8,foldingClassicBike.getId());
	}
	
	@Test
	public void getStatusTest() {
		this.before();
		assertEquals(Status.OUT_OF_SERVICE,foldingClassicBike.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		assertEquals(Status.OUT_OF_SERVICE,foldingClassicBike.getStatus());
		foldingClassicBike.setStatus(Status.AVAILABLE);
		assertEquals(Status.AVAILABLE,foldingClassicBike.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		assertEquals(0,foldingClassicBike.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		assertEquals(5,foldingClassicBike.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		assertTrue(foldingClassicBike.checkUrbanTravelAvailability());
	}
	
	@Test
	public void toStringTest() {
		this.before();
		assertEquals("this ClassicBike has the id : 4 , his status is : OUT_OF_SERVICE (the difference between this type of bike and a classic bike is that it is folding) ",foldingClassicBike.toString());
	}
	@Test
	public void priceTest() {
		this.before();
		assertEquals(2.5,foldingClassicBike.price());
	}
	
	/*
	@Test
	public void decorateFoldingBikeWithBasketAndPriceTest() {
		this.before();
		UrbanTravel urbanTravel = new Basket(foldingClassicBike,3);
		assertEquals(3,urbanTravel.price());
		assertEquals(urbanTravel.decorate(),"this ClassicBike has the id : 4 , his status is : OUT_OF_SERVICE (the difference between this type of bike and a classic bike is that it is folding)  and has a basket which resist until 3 KG ");
	}
	*/
}
