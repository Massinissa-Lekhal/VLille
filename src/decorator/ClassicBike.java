package decorator;

import util.Status;
import visitor.*;


public class ClassicBike implements UrbanTravel {
	
	protected int id;
	protected Status status;
	protected int nbUsed = 0;
	protected static final int maxNbUsed=5;
	
	/**
     * Constructs a ClassicBike with the specified ID and status.
     *
     * @param id     The unique identifier for the classic bike.
     * @param status The status of the classic bike.
     */
	public ClassicBike(int id , Status status) {
		this.id = id;
		this.status = status;
	}
	
	/**
     * Gets the unique identifier of the classic bike.
     *
     * @return The ID of the classic bike.
     */
	public int getId() {
		return this.id;
	}
	
	/**
     * Sets a new ID for the classic bike.
     *
     * @param newId The new ID for the classic bike.
     */
	public void setId(int newId) {
		this.id = newId;
	}
	
	/**
     * Gets the status of the classic bike.
     *
     * @return The status of the classic bike.
     */
	public Status getStatus() {
		return this.status;
	}
	
	/**
     * Sets a new status for the classic bike.
     *
     * @param newStatus The new status for the classic bike.
     */
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	/**
     * Gets the number of times the classic bike has been used.
     *
     * @return The number of times the classic bike has been used.
     */
	public int getNbUsed() {
		return this.nbUsed;
	}
	
	/**
     * Increments the number of times the classic bike has been used.
     */
	public void setNbUsed() {
		this.nbUsed+=1;
	}
	
	/**
     * Resets the number of times the classic bike has been used to zero.
     */
	public void setNbUsedToZero() {
		this.nbUsed = 0;
	}
	
	/**
     * Checks the availability of the classic bike based on the maximum number of uses.
     *
     * @return True if the classic bike is available, false otherwise.
     */
	public boolean checkUrbanTravelAvailability() {
		return (getNbUsed() < getMaxNbUsed());
	}
	
	/**
    * Gets the maximum number of times the classic bike can be used before maintenance.
    *
    * @return The maximum number of times the classic bike can be used.
    */
	public int getMaxNbUsed() {
		return this.maxNbUsed;
	}
	
	/**
     * Returns a string representation of the classic bike.
     *
     * @return A string with information about the classic bike's ID and status.
     */
	@Override
	public String toString() {
		return "this ClassicBike has the id : " + this.id + " , his status is : " + this.status ;
	}
	
	/**
     * Returns the price associated with the classic bike.
     *
     * @return The price of the classic bike.
     */
	@Override
	public double price() {
		return 2 ;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the classic bike.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the classic bike.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		return abstractVisitor.visit(this);
	}
	
}
