package decorator;

import util.Status;
import visitor.AbstractVisitor;

public class FoldingElectricBike extends ElectricBike{
	
	/**
     * Constructs a FoldingElectricBike with the specified ID, battery life, and status.
     *
     * @param id          The unique identifier for the folding electric bike.
     * @param batteryLife The remaining battery life of the folding electric bike.
     * @param status      The status of the folding electric bike.
     */
	public FoldingElectricBike(int id , int batteryLife , Status status) {
		super(id,batteryLife,status);
	}
	
	/**
     * Returns a string representation of the folding electric bike.
     *
     * @return A string with information about the folding electric bike's ID, status, battery life, and its folding feature.
     */
	@Override
	public String toString() {
		return super.toString() + " (the difference between this type of bike and a electric bike is that it is folding) ";
	}
	
	/**
     * Returns the price associated with the folding electric bike.
     *
     * @return The price of the folding electric bike.
     */
	@Override
	public double price() {
		return 3.5;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the folding electric bike.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the folding electric bike.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		return abstractVisitor.visit(this);
	}
}
