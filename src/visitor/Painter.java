package visitor;

import decorator.*;

public class Painter implements AbstractVisitor {
	
	/**
     * Simulates a painter's intervention on a ClassicBike.
     *
     * @param classicBike The ClassicBike undergoing painting.
     * @return Information about the painter's intervention on the ClassicBike.
     */
	@Override
	public String visit(ClassicBike classicBike) {
		return "Intervention d'un peintre sur un ClassicBike : " + classicBike.toString();
	}
	
	/**
     * Simulates a painter's intervention on an ElectricBike.
     *
     * @param electricBike The ElectricBike undergoing painting.
     * @return Information about the painter's intervention on the ElectricBike.
     */
	@Override
	public String visit(ElectricBike electricBike) {
		return "Intervention d'un peintre sur un ElectricBike : " + electricBike.toString();
	}
	
	/**
     * Simulates a painter's intervention on an ElectricScooter.
     *
     * @param electricScooter The ElectricScooter undergoing painting.
     * @return Information about the painter's intervention on the ElectricScooter.
     */
	@Override
	public String visit(ElectricScooter electricScooter) {
		return "Intervention d'un peintre sur un ElectricScooter : " + electricScooter.toString();
	}
	
	/**
     * Simulates a painter's intervention on a FoldingClassicBike.
     *
     * @param foldingClassicBike The FoldingClassicBike undergoing painting.
     * @return Information about the painter's intervention on the FoldingClassicBike.
     */
	@Override
	public String visit(FoldingClassicBike foldingClassicBike) {
		return "Intervention d'un peintre sur un ClassicBike pliant : " + foldingClassicBike.toString();
	}
	
	/**
     * Simulates a painter's intervention on a FoldingElectricBike.
     *
     * @param foldingElectricBike The FoldingElectricBike undergoing painting.
     * @return Information about the painter's intervention on the FoldingElectricBike.
     */
	@Override
	public String visit(FoldingElectricBike foldingElectricBike) {
		return "Intervention d'un peintre sur un ElectricBike pliant : " + foldingElectricBike.toString();
	}
	
}
