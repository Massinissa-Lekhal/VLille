package observer;

import java.util.*;
import decorator.*;

import strategy.RedistributionStrategy;
import visitor.Mechanic;
import visitor.ReparationTask;

public class ControlCenter implements Observer {
	private int id;
	private String name;
	private List<Station> stations;
	private RedistributionStrategy redistributionStrategy;
	private Timer timer ;
	private long delay;
	private TimerTask timerTask;
	
	/**
     * Constructs a ControlCenter with the specified ID, name, stations, redistribution strategy, and delay.
     *
     * @param id                    The unique identifier for the control center.
     * @param name                  The name of the control center.
     * @param stations              The list of stations monitored by the control center.
     * @param redistributionStrategy The redistribution strategy used by the control center.
     * @param delay                 The delay for scheduling tasks in the control center.
     */
	public ControlCenter(int id, String name , List<Station> stations , RedistributionStrategy redistributionStrategy , long delay) {
		this.id = id;
		this.name = name;
		this.stations = stations;
		this.redistributionStrategy = redistributionStrategy;
		this.delay = delay*2000;
		this.timer = new Timer("timer");
		this.timerTask = new DistributeTask(this);
		
	}
	
	/**
     * Gets the unique identifier of the control center.
     *
     * @return The ID of the control center.
     */
	public int getId() {
		return this.id;
	}
	
	/**
     * Sets a new ID for the control center.
     *
     * @param newId The new ID for the control center.
     */
	public void setId(int newId) {
		this.id= newId;
	}
	
	/**
     * Gets the name of the control center.
     *
     * @return The name of the control center.
     */
	public String getName() {
		return this.name;
	}
	
	/**
     * Sets a new name for the control center.
     *
     * @param newName The new name for the control center.
     */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
     * Gets the list of stations monitored by the control center.
     *
     * @return The list of stations.
     */
	public List<Station> getStations() {
		return this.stations;
	}
	
	/**
     * Gets the redistribution strategy used by the control center.
     *
     * @return The redistribution strategy.
     */
	public RedistributionStrategy getRedistributionStrategy() {
		return this.redistributionStrategy;
	}
	
	/**
     * Sets a new redistribution strategy for the control center.
     *
     * @param newRedistributionStrategy The new redistribution strategy.
     */
	public void setRedistributionStrategy(RedistributionStrategy newRedistributionStrategy) {
		this.redistributionStrategy = newRedistributionStrategy;
	}
	
	/**
     * Initiates the redistribution of urban travels based on the assigned redistribution strategy.
     */
	public void needRedistribution() {
		redistributionStrategy.redistribute(stations);
	}
	
	 /**
     * Updates the control center when notified by a station.
     *
     * @param station The station that has been updated.
     */
	@Override
	public void update(Station station) {
		
		System.out.println("Centre de controle " + this.name + " notifié : la station " + station.getName() + " a ete mise a jour . Nouveau nombre de velos dans cette station est " + station.getOccupedSpaceCount());
		if(station.getOccupedSpaceCount()==0 || station.getOccupedSpaceCount()==station.getCapacity()) {
			this.timer.schedule(new DistributeTask(this), this.delay);
		}
	}
	
}
