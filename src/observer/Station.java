package observer;

import java.util.*;
import decorator.*;
import util.Status;
import visitor.*;

public class Station {
	
	protected int id;
	protected String name;
	protected int capacity;
	protected List<UrbanTravel> urbanTravels;
	protected List<Observer> observers;
	protected static final int MIN_CAPACITY = 10;
	protected static final int MAX_CAPACITY = 20;
	private Timer timer ;
	private long delay;
	
	/**
     * Constructs a Station with the specified ID and name.
     *
     * @param id   The unique identifier for the station.
     * @param name The name of the station.
     */
	public Station (int id , String name ) {
		this.id = id;
		this.name = name;
		this.capacity = generateRandom();
		this.urbanTravels = new ArrayList<>();
		this.observers = new ArrayList<>();
		this.delay = delay*2000;
		this.timer = new Timer("timer");
		
	}
	
	/**
     * Generates a random capacity for the station within the specified range.
     *
     * @return The randomly generated capacity.
     */
	public int generateRandom() {
		Random random = new Random();
		return (MIN_CAPACITY + random.nextInt(MAX_CAPACITY - MIN_CAPACITY + 1));
	}
	
	/**
     * Gets the unique identifier of the station.
     *
     * @return The ID of the station.
     */
	public int getId() {
		return this.id;
	}
	
	/**
     * Sets a new ID for the station.
     *
     * @param newId The new ID for the station.
     */
	public void setId(int newId) {
		this.id = newId;
	}
	
	/**
     * Gets the name of the station.
     *
     * @return The name of the station.
     */
	public String getName() {
		return this.name;
	}
	
	/**
     * Sets a new name for the station.
     *
     * @param newName The new name for the station.
     */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
     * Gets the list of urban travels in the station.
     *
     * @return The list of urban travels.
     */
	public List<UrbanTravel> getUrbanTravels() {
		return this.urbanTravels;
	}
	
	/**
     * Gets the maximum capacity of the station.
     *
     * @return The maximum capacity of the station.
     */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
     * Sets a new capacity for the station.
     *
     * @param newCapacity The new capacity for the station.
     */
	public void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
	
	/**
     * Gets the number of occupied spaces in the station.
     *
     * @return The number of occupied spaces.
     */
	public int getOccupedSpaceCount() {
		return urbanTravels.size();
	}
	
	/**
     * Adds an urban travel to the station if there is available space.
     *
     * @param urbanTravel The urban travel to add.
     */
	public void addUrbanTravel(UrbanTravel urbanTravel) {
		if (getOccupedSpaceCount()<getCapacity()) {
			this.urbanTravels.add(urbanTravel);
			urbanTravel.setStatus(Status.AVAILABLE);
			notifyObserver();
		}
		else {
			System.out.println("Seul " + getCapacity() + " urvabTravels ont ete rajoute avec succes vu que la station est pleine !!!");		
		}
	}
	
	/**
     * Removes an urban travel from the station.
     *
     * @param urbanTravel The urban travel to remove.
     */
	public void removeUrbanTravel(UrbanTravel urbanTravel) {
		this.urbanTravels.remove(urbanTravel);
		urbanTravel.setStatus(Status.UNAVAILABLE);
		notifyObserver();
	}
	
	/**
     * Rents an urban travel from the station if available.
     */
	public void rent() {
		boolean found = false;
		if (getOccupedSpaceCount() > 0) {
			for (UrbanTravel urbanTravel : urbanTravels) {
				if (!urbanTravel.checkUrbanTravelAvailability()) {
					this.timer.schedule(new ReparationTask(urbanTravel,new Mechanic()), this.delay);
				}
				else if (urbanTravel.getStatus() == Status.AVAILABLE  && urbanTravel.checkUrbanTravelAvailability() ) {
					urbanTravel.setNbUsed();
					this.urbanTravels.remove(urbanTravel);
					notifyObserver();
					found = true;
					System.out.println(getName() + " : " + urbanTravel.accept(new Client()));
					break;
				}
			}
			if (!found) {
				System.out.println("Rent urbanTravel impossible : Pas d'urbanTravel disponible dans la " + getName() );
			}
		}
		else {
			System.out.println("Rent urbanTravel impossible : la " + getName() + " est vide ");
		}
		
	}
	
	/**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to add.
     */
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	/**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to remove.
     */
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	/**
     * Notifies all observers that the station has been updated.
     */
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
}
 