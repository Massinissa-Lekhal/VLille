package decorator;

import util.Status;
import visitor.AbstractVisitor;

public class FoldingClassicBike extends ClassicBike{
	
	/**
     * Constructs a FoldingClassicBike with the specified ID and status.
     *
     * @param id     The unique identifier for the folding classic bike.
     * @param status The status of the folding classic bike.
     */
	public FoldingClassicBike(int id , Status status) {
		super(id,status);
	}
	
	/**
     * Returns a string representation of the folding classic bike.
     *
     * @return A string with information about the folding classic bike's ID, status, and its folding feature.
     */
	@Override
	public String toString() {
		return 	super.toString() + " (the difference between this type of bike and a classic bike is that it is folding) ";
	}
	
	/**
     * Returns the price associated with the folding classic bike.
     *
     * @return The price of the folding classic bike.
     */
	@Override
	public double price() {
		return 2.5 ;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the folding classic bike.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the folding classic bike.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		return abstractVisitor.visit(this);
	}
}
