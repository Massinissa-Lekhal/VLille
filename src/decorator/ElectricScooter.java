package decorator;

import util.Status;
import visitor.AbstractVisitor;

public class ElectricScooter implements UrbanTravel{
	
	private int id;
	private int batteryLife;
	private Status status;
	protected int nbUsed = 0;
	protected static final int maxNbUsed=5;
	
	/**
     * Constructs an ElectricScooter with the specified ID, battery life, and status.
     *
     * @param id           The unique identifier for the electric scooter.
     * @param batteryLife  The remaining battery life of the electric scooter.
     * @param status       The status of the electric scooter.
     */
	public ElectricScooter(int id , int batteryLife , Status status) {
		this.id = id;
		this.batteryLife = batteryLife;
		this.status = status;
	}
	
	/**
     * Gets the unique identifier of the electric scooter.
     *
     * @return The ID of the electric scooter.
     */
	public int getId() {
		return this.id;
	}
	
	/**
     * Sets a new ID for the electric scooter.
     *
     * @param newId The new ID for the electric scooter.
     */
	public void setId(int newId) {
		this.id = newId;
	}
	
	/**
     * Gets the status of the electric scooter.
     *
     * @return The status of the electric scooter.
     */
	public Status getStatus() {
		return this.status;
	}
	
	/**
     * Sets a new status for the electric scooter.
     *
     * @param newStatus The new status for the electric scooter.
     */
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	/**
     * Gets the remaining battery life of the electric scooter.
     *
     * @return The remaining battery life in hours.
     */
	public int getBatteryLife() {
		return this.batteryLife;
	}
	
	/**
     * Sets a new battery life for the electric scooter.
     *
     * @param newBatteryLife The new battery life in hours.
     */
	public void setBatteryLife(int newBatteryLife) {
		this.batteryLife = newBatteryLife;
	}
	
	/**
     * Gets the number of times the electric scooter has been used.
     *
     * @return The number of times the electric scooter has been used.
     */
	public int getNbUsed() {
		return this.nbUsed;
	}
	
	/**
     * Increments the number of times the electric scooter has been used.
     */
	public void setNbUsed() {
		this.nbUsed+=1;
	}
	
	/**
     * Resets the number of times the electric scooter has been used to zero.
     */
	public void setNbUsedToZero() {
		this.nbUsed = 0;
	}
	
	/**
     * Checks the availability of the electric scooter based on the maximum number of uses.
     *
     * @return True if the electric scooter is available, false otherwise.
     */
	public boolean checkUrbanTravelAvailability() {
		return (getNbUsed() < getMaxNbUsed());
	}
	
	/**
     * Gets the maximum number of times the electric scooter can be used before maintenance.
     *
     * @return The maximum number of times the electric scooter can be used.
     */
	public int getMaxNbUsed() {
		return this.maxNbUsed;
	}
	
	/**
     * Returns a string representation of the electric scooter.
     *
     * @return A string with information about the electric scooter's ID, status, and battery life.
     */
	@Override
	public String toString() {
		return "this ElectricScooter(trotinette) has the id : " + this.id + " , his status is : " + this.status + " and his autonomy is " + this.batteryLife + " hours ";
	}
	
	/**
     * Returns the price associated with the electric scooter.
     *
     * @return The price of the electric scooter.
     */
	@Override
	public double price() {
		return 4 ;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the electric scooter.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the electric scooter.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		return abstractVisitor.visit(this);
	}
	
}
