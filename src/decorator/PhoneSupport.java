package decorator;


public class PhoneSupport implements ToolsForDecorating {
	
	/**
     * Constructs a PhoneSupport.
     */
	public PhoneSupport() {
	}
	
	/**
     * Decorates the urban travel with information about the phone support.
     *
     * @return A string indicating the urban travel has a phone support for GPS.
     */
	@Override
	public String decorate() {
		return " and has a PhoneSupport for your GPS ";
	}
	
	/**
     * Calculates the price associated with the phone support.
     *
     * @return The price of the phone support.
     */
	@Override
	public double price() {
		return 1 ;
	}
	
}
