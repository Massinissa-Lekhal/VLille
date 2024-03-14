package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BasketTest {
	
	private Basket basket;
	
	@BeforeEach
	public void before() {
		basket = new Basket(4);
	}
	
	@Test
	public void getWeightMaximumTest() {
		this.before();
		assertEquals(4,basket.getWeightMaximum());
	}
	
	@Test
	public void setWeightMaximumTest() {
		this.before();
		assertEquals(4,basket.getWeightMaximum());
		basket.setWeightMaximum(8);
		assertEquals(8,basket.getWeightMaximum());
	}
	
	@Test
	public void decorateTest() {
		this.before();
		assertEquals(" and has a basket which resist until 4 KG ",basket.decorate());
	}
	
	@Test
	public void priceTest() {
		this.before();
		assertEquals(0.5,basket.price());
	}
	
}
