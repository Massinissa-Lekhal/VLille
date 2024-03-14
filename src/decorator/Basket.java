
	package decorator;
	
	
	public class Basket implements ToolsForDecorating{
		
		private int weightMaximum;
		
		/**
	     * Constructs a Basket with the specified maximum weight.
	     *
	     * @param weightMaximum The maximum weight the basket can resist.
	     */
		public Basket(int weightMaximum) {
			this.weightMaximum = weightMaximum;
		}
		
		/**
	     * Gets the maximum weight the basket can resist.
	     *
	     * @return The maximum weight the basket can resist.
	     */
		public int getWeightMaximum() {
			return this.weightMaximum;
		}
		
		/**
	     * Sets a new maximum weight for the basket.
	     *
	     * @param newWeightMaximum The new maximum weight for the basket.
	     */
		public void setWeightMaximum(int newWeightMaximum) {
			this.weightMaximum = newWeightMaximum ;
		}
		
		/**
	     * Decorates the UrbanTravel with information about the basket's resistance.
	     *
	     * @return A String describing the basket's resistance.
	     */
		public String decorate() {
			return " and has a basket which resist until " + this.weightMaximum + " KG "; 
		}
		
		/**
	     * Returns the price for adding a basket decoration.
	     *
	     * @return The price for adding a basket decoration.
	     */
		@Override
		public double price() {
			return 0.5 ;
		}
		
	}
