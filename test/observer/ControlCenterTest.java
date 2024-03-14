package observer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decorator.ElectricBike;
import decorator.ElectricScooter;
import decorator.UrbanTravel;
import strategy.*;
import util.Status;

class ControlCenterTest {
	
	private ControlCenter controlCenter;
	private List<Station> stations;
	private Station station1; 
	private Station station2;
	
	@BeforeEach
	public void before() {
		station1 = new Station(34,"wazzems");
		station2 = new Station(34,"gambetta");
		stations = new ArrayList<>();
		stations.add(station1);
		stations.add(station2);
		controlCenter = new ControlCenter(1,"lille sud",stations,new ClassicStrategy(),2);
	}
	
	@Test
	public void getIdTest() {
		this.before();
		assertEquals(1,controlCenter.getId());
	}
	
	@Test
	public void setIdTest() {
		this.before();
		assertEquals(1,controlCenter.getId());
		controlCenter.setId(2);
		assertEquals(2,controlCenter.getId());
	}
	
	@Test
	public void getNameTest() {
		this.before();
		assertEquals("lille sud",controlCenter.getName());
	}
	
	@Test
	public void setNameTest() {
		this.before();
		assertEquals("lille sud",controlCenter.getName());
		controlCenter.setName("lille");
		assertEquals("lille",controlCenter.getName());
	}
	
	@Test
	public void getRedistributionStrategyTest() {
		this.before();
		assertTrue(controlCenter.getRedistributionStrategy() instanceof ClassicStrategy);
	}
	
	@Test
	public void setRedistributionStrategyTest() {
		this.before();
		assertTrue(controlCenter.getRedistributionStrategy() instanceof ClassicStrategy);
		controlCenter.setRedistributionStrategy(new RandomStrategy());
		assertTrue(controlCenter.getRedistributionStrategy() instanceof RandomStrategy);
	}
	
	
}
