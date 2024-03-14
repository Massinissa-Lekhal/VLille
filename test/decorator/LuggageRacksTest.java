package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LuggageRacksTest {

	private LuggageRacks luggageRacks;
	
	@BeforeEach
	public void before() {
		luggageRacks = new LuggageRacks(3);
	}

	@Test
	public void getNumberOfLuggageRacksTest() {
		this.before();
		assertEquals(3,luggageRacks.getNumberOfLuggageRacks());
	}
	
	@Test
	public void setNumberOfLuggageRacksTest() {
		this.before();
		assertEquals(3,luggageRacks.getNumberOfLuggageRacks());
		luggageRacks.setNumberOfLuggageRacks(4);
		assertEquals(4,luggageRacks.getNumberOfLuggageRacks());
	}
	
	@Test
	public void decorateTest() {
	this.before();
	assertEquals(" and has 3 luggageRacks where you can store your things for example ",luggageRacks.decorate());
	}
	
	@Test
	public void priceTest() {
		this.before();
		assertEquals(4.5,luggageRacks.price());
	}
}
