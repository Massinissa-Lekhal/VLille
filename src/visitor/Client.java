package visitor;

import decorator.*;

public class Client implements AbstractVisitor {
	
	/**
     * Generates rental information for a ClassicBike.
     *
     * @param classicBike The ClassicBike to generate rental information for.
     * @return Rental information for a ClassicBike.
     */
	@Override
	public String visit(ClassicBike classicBike) {
		return "Rent un ClassicBike pour un client : " + classicBike.toString();
	}
	
	/**
     * Generates rental information for an ElectricBike.
     *
     * @param electricBike The ElectricBike to generate rental information for.
     * @return Rental information for an ElectricBike.
     */
	@Override
	public String visit(ElectricBike electricBike) {
		return "Rent un ElectricBike pour un client : " + electricBike.toString();
	}
	
	/**
     * Generates rental information for an ElectricScooter.
     *
     * @param electricScooter The ElectricScooter to generate rental information for.
     * @return Rental information for an ElectricScooter.
     */
	@Override
	public String visit(ElectricScooter electricScooter) {
		return "Rent un ElectricScooter pour un client : " + electricScooter.toString();
	}
	
	/**
     * Generates rental information for a FoldingClassicBike.
     *
     * @param foldingClassicBike The FoldingClassicBike to generate rental information for.
     * @return Rental information for a FoldingClassicBike.
     */
	@Override
	public String visit(FoldingClassicBike foldingClassicBike) {
		return "Rent un ClassicBike pliant pour un client : " + foldingClassicBike.toString();
	}
	
	/**
     * Generates rental information for a FoldingElectricBike.
     *
     * @param foldingElectricBike The FoldingElectricBike to generate rental information for.
     * @return Rental information for a FoldingElectricBike.
     */
	@Override
	public String visit(FoldingElectricBike foldingElectricBike) {
		return "Rent un ElectricBike pliant pour un client : " + foldingElectricBike.toString();
	}
	
}
