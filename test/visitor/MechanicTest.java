package visitor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decorator.*;
import util.Status;

class MechanicTest {
	
	private Mechanic mechanic;
	private ClassicBike classicBike;
	private ElectricBike electricBike;
	private ElectricScooter electricScooter;
	private FoldingClassicBike foldingClassicBike;
	private FoldingElectricBike foldingElectricBike;
	
	@BeforeEach
	public void before() {
		mechanic = new Mechanic();
		classicBike = new ClassicBike(45,Status.UNAVAILABLE);
		electricBike = new ElectricBike(39,24,Status.AVAILABLE);
		electricScooter = new ElectricScooter(90,48,Status.AVAILABLE);
		foldingClassicBike = new FoldingClassicBike(4,Status.OUT_OF_SERVICE);
		foldingElectricBike = new FoldingElectricBike(2,60,Status.UNAVAILABLE);
	}
	
	@Test
	public void visitTest() {
		this.before();
		assertEquals("Intervention d'un mechanicien sur un ClassicBike : this ClassicBike has the id : 45 , his status is : AVAILABLE",classicBike.accept(mechanic));
		assertEquals("Intervention d'un mechanicien sur un ElectricBike : this ElectricBike has the id : 39 , his status is : AVAILABLE and his autonomy is 24 hours ",electricBike.accept(mechanic));
		assertEquals("Intervention d'un mechanicien sur un ElectricScooter : this ElectricScooter(trotinette) has the id : 90 , his status is : AVAILABLE and his autonomy is 48 hours ",electricScooter.accept(mechanic));
		assertEquals("Intervention d'un mechanicien sur un ClassicBike pliant : this ClassicBike has the id : 4 , his status is : AVAILABLE (the difference between this type of bike and a classic bike is that it is folding) ",foldingClassicBike.accept(mechanic));
		assertEquals("Intervention d'un mechanicien sur un ElectricBike pliant : this ElectricBike has the id : 2 , his status is : AVAILABLE and his autonomy is 60 hours  (the difference between this type of bike and a electric bike is that it is folding) ",foldingElectricBike.accept(mechanic));
		
		List<ToolsForDecorating> tools = new ArrayList<>();
		Basket basket = new Basket(6);
		PhoneSupport phoneSupport = new PhoneSupport();
		tools.add(basket);
		tools.add(phoneSupport);
		
		DecoratorUrbanTravel urb = new DecoratorUrbanTravel(classicBike,tools);
		assertEquals("Intervention d'un mechanicien sur un ClassicBike : this ClassicBike has the id : 45 , his status is : AVAILABLE and has a basket which resist until 6 KG  and has a PhoneSupport for your GPS ",urb.accept(mechanic));
	}

}
