
package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PhoneSupportTest {

private PhoneSupport phoneSupport;
	
	@BeforeEach
	public void before() {
		phoneSupport = new PhoneSupport();
	}
	
	@Test
	public void decorateTest() {
		this.before();
		assertEquals(" and has a PhoneSupport for your GPS ",phoneSupport.decorate());
	}
	
	@Test
	public void priceTest() {
		this.before();
		assertEquals(1,phoneSupport.price());
	}
		
}
