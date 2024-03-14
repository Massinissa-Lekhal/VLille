package decorator;

import util.Status;
import visitor.AbstractVisitor;

public class ElectricBike implements UrbanTravel{
	
	protected int id;
	protected int batteryLife;
	protected Status status;
	protected int nbUsed = 0;
	protected static final int maxNbUsed=5;
	
	/**
     * Constructs an ElectricBike with the specified ID, battery life, and status.
     *
     * @param id           The unique identifier for the electric bike.
     * @param batteryLife  The remaining battery life of the electric bike.
     * @param status       The status of the electric bike.
     */
	public ElectricBike(int id , int batteryLife , Status status) {
		this.id = id;
		this.batteryLife = batteryLife;
		this.status = status;
	}
	
	/**
     * Gets the unique identifier of the electric bike.
     *
     * @return The ID of the electric bike.
     */
	public int getId() {
		return this.id;
	}
	
	/**
     * Sets a new ID for the electric bike.
     *
     * @param newId The new ID for the electric bike.
     */
	public void setId(int newId) {
		this.id = newId;
	}
	
	/**
     * Gets the status of the electric bike.
     *
     * @return The status of the electric bike.
     */
	public Status getStatus() {
		return this.status;
	}
	
	/**
     * Sets a new status for the electric bike.
     *
     * @param newStatus The new status for the electric bike.
     */
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	/**
     * Gets the remaining battery life of the electric bike.
     *
     * @return The remaining battery life in hours.
     */
	public int getBatteryLife() {
		return this.batteryLife;
	}
	
	/**
     * Sets a new battery life for the electric bike.
     *
     * @param newBatteryLife The new battery life in hours.
     */
	public void setBatteryLife(int newBatteryLife) {
		this.batteryLife = newBatteryLife;
	}
	
	/**
     * Gets the number of times the electric bike has been used.
     *
     * @return The number of times the electric bike has been used.
     */
	public int getNbUsed() {
		return this.nbUsed;
	}
	
	/**
     * Increments the number of times the electric bike has been used.
     */
	public void setNbUsed() {
		this.nbUsed+=1;
	}
	
	/**
     * Resets the number of times the electric bike has been used to zero.
     */
	public void setNbUsedToZero() {
		this.nbUsed = 0;
	}
	
	/**
     * Checks the availability of the electric bike based on the maximum number of uses.
     *
     * @return True if the electric bike is available, false otherwise.
     */
	public boolean checkUrbanTravelAvailability() {
		return (getNbUsed() < getMaxNbUsed());
	}
	
	/**
     * Gets the maximum number of times the electric bike can be used before maintenance.
     *
     * @return The maximum number of times the electric bike can be used.
     */
	public int getMaxNbUsed() {
		return this.maxNbUsed;
	}
	
	/**
     * Returns a string representation of the electric bike.
     *
     * @return A string with information about the electric bike's ID, status, and battery life.
     */
	@Override
	public String toString() {
		return "this ElectricBike has the id : " + this.id + " , his status is : " + this.status + " and his autonomy is " + this.batteryLife + " hours ";
	}
	
	/**
     * Returns the price associated with the electric bike.
     *
     * @return The price of the electric bike.
     */
	@Override
	public double price() {
		return 3 ;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the electric bike.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the electric bike.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		return abstractVisitor.visit(this);
	}
	
}
