/*
package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import util.Status;

public abstract class UrbanTravelTest {
	
	protected UrbanTravel urbanTravel;
	
	public abstract UrbanTravel createUrbanTravel();
	
	@BeforeEach
	public void before() {
		this.urbanTravel = createUrbanTravel();
		
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(1,urbanTravel.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(1,urbanTravel.getId());
		urbanTravel.setId(2);
		assertEquals(2,urbanTravel.getId());
	}
	
	@Test
	public void getStatus() {
		this.before();
		assertEquals(Status.AVAILABLE,urbanTravel.getStatus());
	}
	
}
*/
