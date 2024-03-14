package decorator;


public class LuggageRacks implements ToolsForDecorating {
	
	private int numberOfLuggageRacks ;
	
	/**
     * Constructs a LuggageRacks with the specified number of luggage racks.
     *
     * @param numberOfLuggageRacks The number of luggage racks on the urban travel.
     */
	public LuggageRacks(int numberOfLuggageRacks) {
		this.numberOfLuggageRacks = numberOfLuggageRacks;
	}
	
	/**
     * Gets the number of luggage racks on the urban travel.
     *
     * @return The number of luggage racks.
     */
	public int getNumberOfLuggageRacks() {
		return this.numberOfLuggageRacks;
	}
	
	/**
     * Sets a new number of luggage racks for the urban travel.
     *
     * @param newNumberOfLuggageRacks The new number of luggage racks.
     */
	public void setNumberOfLuggageRacks(int newNumberOfLuggageRacks) {
		this.numberOfLuggageRacks = newNumberOfLuggageRacks;
	}
	
	/**
     * Decorates the urban travel with information about the number of luggage racks.
     *
     * @return A string describing the number of luggage racks on the urban travel.
     */
	@Override
	public String decorate() {
		return " and has " + this.numberOfLuggageRacks + " luggageRacks where you can store your things for example ";
	}
	
	/**
     * Calculates the price associated with the luggage racks.
     *
     * @return The total price of the luggage racks based on the number of racks.
     */
	@Override
	public double price() {
		return numberOfLuggageRacks * 1.5 ;
	}
	
}
