package decorator;

import util.Status;
import visitor.*;
import java.util.*;

public class DecoratorUrbanTravel implements UrbanTravel{
	
	protected UrbanTravel urbanTravel;
	protected List<ToolsForDecorating> toolsForDecorating;
	
	/**
     * Constructs a DecoratorUrbanTravel with the specified base UrbanTravel and a list of decorating tools.
     *
     * @param urbanTravel         The base UrbanTravel to be decorated.
     * @param toolsForDecorating  The list of tools for decorating the UrbanTravel.
     */
	public DecoratorUrbanTravel(UrbanTravel urbanTravel , List<ToolsForDecorating> toolsForDecorating) {
		this.urbanTravel = urbanTravel;
		this.toolsForDecorating = toolsForDecorating;
	}
	
	/**
     * Adds a new tool for decorating the UrbanTravel.
     *
     * @param toolForDecorating The tool to be added for decorating.
     */
	public void addToolsForDecorating(ToolsForDecorating toolForDecorating) {
		this.toolsForDecorating.add(toolForDecorating);
	}
	
	/**
     * Gets the unique identifier of the decorated UrbanTravel.
     *
     * @return The ID of the decorated UrbanTravel.
     */
	@Override
	public int getId() {
		return urbanTravel.getId();
	}
	
	/**
     * Sets a new identifier for the decorated UrbanTravel.
     *
     * @param newId The new identifier for the decorated UrbanTravel.
     */
	@Override
	public void setId(int newId) {
		urbanTravel.setId(newId);
	}
	
	/**
     * Gets the status of the decorated UrbanTravel.
     *
     * @return The status of the decorated UrbanTravel.
     */
	@Override
	public Status getStatus() {
		return urbanTravel.getStatus();
	}
	
	/**
     * Sets a new status for the decorated UrbanTravel.
     *
     * @param newStatus The new status for the decorated UrbanTravel.
     */
	public void setStatus(Status newStatus) {
		urbanTravel.setStatus(newStatus);
	}
	
	/**
     * Gets the number of times the decorated UrbanTravel has been used.
     *
     * @return The number of times the decorated UrbanTravel has been used.
     */
	public int getNbUsed() {
		return urbanTravel.getNbUsed();
	}
	
	/**
     * Increments the number of times the decorated UrbanTravel has been used.
     */
	public void setNbUsed() {
		urbanTravel.setNbUsed();
	}
	
	/**
     * Resets the number of times the decorated UrbanTravel has been used to zero.
     */
	public void setNbUsedToZero() {
		urbanTravel.setNbUsedToZero();
	}
	
	/**
    * Checks the availability of the decorated UrbanTravel based on the maximum number of uses.
    *
    * @return True if the decorated UrbanTravel is available, false otherwise.
    */
	public boolean checkUrbanTravelAvailability() {
		return urbanTravel.checkUrbanTravelAvailability();
	}
	
	/**
     * Gets the maximum number of times the decorated UrbanTravel can be used before maintenance.
     *
     * @return The maximum number of times the decorated UrbanTravel can be used.
     */
	public int getMaxNbUsed() {
		return urbanTravel.getMaxNbUsed();
	}
	
	/**
     * Returns a string representation of the decorated UrbanTravel with information about the decorating tools.
     *
     * @return A string with information about the decorated UrbanTravel and its decorating tools.
     */
	@Override
	public String toString() {
		String result = "";
		for (ToolsForDecorating tool : toolsForDecorating) {
			result+= tool.decorate();
		}
		return urbanTravel.toString() + result ;
	}
	
	/**
     * Returns the total price associated with the decorated UrbanTravel, including the price of decorating tools.
     *
     * @return The total price of the decorated UrbanTravel.
     */
	@Override
	public double price() {
		double result = 0;
		for (ToolsForDecorating tool : toolsForDecorating) {
			result+= tool.price();
		}
		return urbanTravel.price() + result ;
	}
	
	/**
     * Accepts a visitor for performing operations specific to the decorated UrbanTravel.
     *
     * @param abstractVisitor The visitor to accept.
     * @return The result of the visitor's operation on the decorated UrbanTravel.
     */
	@Override
	public String accept(AbstractVisitor abstractVisitor) {
		String result = "";
		for (ToolsForDecorating tools : toolsForDecorating) {
			result += tools.decorate();
		}
		return urbanTravel.accept(abstractVisitor) + result ;
	}
	
	
}
