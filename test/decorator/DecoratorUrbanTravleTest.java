package decorator;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Status;

class DecoratorUrbanTravleTest {

	private UrbanTravel classicBike;
	private UrbanTravel electricBike;
	private List<ToolsForDecorating> toolsForDecoratingClassicBike;
	private List<ToolsForDecorating> toolsForDecoratingElectricBike;
	
	@BeforeEach
	public void before() {
		this.classicBike = new ClassicBike(1,Status.AVAILABLE);
		this.electricBike = new ElectricBike(2,24,Status.UNAVAILABLE);
		this.toolsForDecoratingClassicBike = new ArrayList<>();
		this.toolsForDecoratingElectricBike = new ArrayList<>();
	}
	
	@Test
	public void getIdTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(1,urb.getId());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(2,urb1.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(1,urb.getId());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(2,urb1.getId());
		urb.setId(100);
		assertEquals(100,urb.getId());
		urb1.setId(200);
		assertEquals(200,urb1.getId());
	}
	
	@Test
	public void getStatusTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(Status.AVAILABLE,urb.getStatus());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(Status.UNAVAILABLE,urb1.getStatus());
	}
	
	@Test
	public void setStatusTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(Status.AVAILABLE,urb.getStatus());
		urb.setStatus(Status.UNAVAILABLE);
		assertEquals(Status.UNAVAILABLE,urb.getStatus());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(Status.UNAVAILABLE,urb1.getStatus());
		urb1.setStatus(Status.OUT_OF_SERVICE);
		assertEquals(Status.OUT_OF_SERVICE,urb1.getStatus());
	}
	
	@Test
	public void getNbUsedTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(0,urb.getNbUsed());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(0,urb1.getNbUsed());
	}
	
	@Test
	public void getMaxNbUsedTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals(5,urb.getMaxNbUsed());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertEquals(5,urb1.getMaxNbUsed());
	}
	
	@Test
	public void checkUrbanTravelAvailabilityTest() {
		this.before();
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertTrue(urb.checkUrbanTravelAvailability());
		DecoratorUrbanTravel urb1 = new DecoratorUrbanTravel(electricBike, toolsForDecoratingElectricBike);
		assertTrue(urb1.checkUrbanTravelAvailability());
	}
	
	@Test
	public void addToolsForDecoratingTest() {
		this.before();
		assertEquals(0,toolsForDecoratingClassicBike.size());
		Basket basket = new Basket(5);
		this.toolsForDecoratingClassicBike.add(basket);
		assertEquals(1,toolsForDecoratingClassicBike.size());
	}
	
	@Test
	public void decorateClassicBikeWithBasketAndPriceTest() {
		this.before();
		Basket basket = new Basket(5);
		this.toolsForDecoratingClassicBike.add(basket);
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike, toolsForDecoratingClassicBike);
		assertEquals("this ClassicBike has the id : 1 , his status is : AVAILABLE and has a basket which resist until 5 KG ",urb.toString());
		assertEquals(2.5,urb.price());
	}
	
	@Test
	public void decorateClassicBikeWithBasketAndLuggageRacksAndPriceTest() {
		this.before();
		Basket basket = new Basket(7);
		LuggageRacks luggageRacks = new LuggageRacks(2);
		this.toolsForDecoratingClassicBike.add(luggageRacks);
		this.toolsForDecoratingClassicBike.add(basket);
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike,toolsForDecoratingClassicBike);
		assertEquals("this ClassicBike has the id : 1 , his status is : AVAILABLE and has 2 luggageRacks where you can store your things for example  and has a basket which resist until 7 KG ",urb.toString());
		assertEquals(5.5,urb.price());
	}

	@Test
	public void decorateElectricBikeWithPhoneSupportAndLuggageRacksAndPriceTest() {
		this.before();
		LuggageRacks luggageRacks = new LuggageRacks(3);
		PhoneSupport phoneSupport = new PhoneSupport();
		this.toolsForDecoratingElectricBike.add(phoneSupport);
		this.toolsForDecoratingElectricBike.add(luggageRacks);
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(electricBike,toolsForDecoratingElectricBike);
		assertEquals("this ElectricBike has the id : 2 , his status is : UNAVAILABLE and his autonomy is 24 hours  and has a PhoneSupport for your GPS  and has 3 luggageRacks where you can store your things for example ",urb.toString());
		assertEquals(8.5,urb.price());
	}
}
