package visitor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decorator.*;
import util.Status;

class ThiefTest {

	private Thief thief;
	private ClassicBike classicBike;
	private ElectricBike electricBike;
	private ElectricScooter electricScooter;
	private FoldingClassicBike foldingClassicBike;
	private FoldingElectricBike foldingElectricBike;
	
	@BeforeEach
	public void before() {
		thief = new Thief();
		classicBike = new ClassicBike(45,Status.UNAVAILABLE);
		electricBike = new ElectricBike(39,24,Status.AVAILABLE);
		electricScooter = new ElectricScooter(90,48,Status.AVAILABLE);
		foldingClassicBike = new FoldingClassicBike(4,Status.OUT_OF_SERVICE);
		foldingElectricBike = new FoldingElectricBike(2,60,Status.UNAVAILABLE);
	}
	
	@Test
	public void visitTest() {
		this.before();
		assertEquals("ClassicBike voler par une personne : this ClassicBike has the id : 45 , his status is : UNAVAILABLE",classicBike.accept(thief));
		assertEquals("ElectricBike voler par une personne : this ElectricBike has the id : 39 , his status is : AVAILABLE and his autonomy is 24 hours ",electricBike.accept(thief));
		assertEquals("ElectricScooter voler par une personne : this ElectricScooter(trotinette) has the id : 90 , his status is : AVAILABLE and his autonomy is 48 hours ",electricScooter.accept(thief));
		assertEquals("ClassicBike pliant voler par une personne : this ClassicBike has the id : 4 , his status is : OUT_OF_SERVICE (the difference between this type of bike and a classic bike is that it is folding) ",foldingClassicBike.accept(thief));
		assertEquals("ElectricBike pliant voler par une personne : this ElectricBike has the id : 2 , his status is : UNAVAILABLE and his autonomy is 60 hours  (the difference between this type of bike and a electric bike is that it is folding) ",foldingElectricBike.accept(thief));
		
		List<ToolsForDecorating> tools = new ArrayList<>();
		Basket basket = new Basket(6);
		PhoneSupport phoneSupport = new PhoneSupport();
		tools.add(basket);
		tools.add(phoneSupport);
		
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike,tools);
		assertEquals("ClassicBike voler par une personne : this ClassicBike has the id : 45 , his status is : UNAVAILABLE and has a basket which resist until 6 KG  and has a PhoneSupport for your GPS ",urb.accept(thief));
	}

}
