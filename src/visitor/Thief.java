package visitor;

import decorator.*;


public class Thief implements AbstractVisitor {
	
	/**
     * Simulates the theft of a ClassicBike by a person.
     *
     * @param classicBike The ClassicBike being stolen.
     * @return Information about the theft of the ClassicBike.
     */
	@Override
	public String visit(ClassicBike classicBike) {
		return "ClassicBike voler par une personne : " + classicBike.toString();
	}
	
	/**
     * Simulates the theft of an ElectricBike by a person.
     *
     * @param electricBike The ElectricBike being stolen.
     * @return Information about the theft of the ElectricBike.
     */
	@Override
	public String visit(ElectricBike electricBike) {
		return "ElectricBike voler par une personne : " + electricBike.toString();
	}
	
	/**
     * Simulates the theft of an ElectricScooter by a person.
     *
     * @param electricScooter The ElectricScooter being stolen.
     * @return Information about the theft of the ElectricScooter.
     */
	@Override
	public String visit(ElectricScooter electricScooter) {
		return "ElectricScooter voler par une personne : " + electricScooter.toString();
	}
	
	/**
     * Simulates the theft of a FoldingClassicBike by a person.
     *
     * @param foldingClassicBike The FoldingClassicBike being stolen.
     * @return Information about the theft of the FoldingClassicBike.
     */
	@Override
	public String visit(FoldingClassicBike foldingClassicBike) {
		return "ClassicBike pliant voler par une personne : " + foldingClassicBike.toString();
	}
	
	/**
     * Simulates the theft of a FoldingElectricBike by a person.
     *
     * @param foldingElectricBike The FoldingElectricBike being stolen.
     * @return Information about the theft of the FoldingElectricBike.
     */
	@Override
	public String visit(FoldingElectricBike foldingElectricBike) {
		return "ElectricBike pliant voler par une personne : " + foldingElectricBike.toString();
	}
	
}
