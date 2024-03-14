package visitor;

import decorator.*;
import util.Status;

public class Mechanic implements AbstractVisitor {
	
	/**
     * Repairs a ClassicBike, setting its number of uses to zero and changing its status to AVAILABLE.
     *
     * @param classicBike The ClassicBike to be repaired.
     * @return Information about the mechanic's intervention on the ClassicBike.
     */
	@Override
	public String visit(ClassicBike classicBike) {
		classicBike.setNbUsedToZero();
		classicBike.setStatus(Status.AVAILABLE);
		return "Intervention d'un mechanicien sur un ClassicBike : " + classicBike.toString();
	}
	
	/**
     * Repairs an ElectricBike, setting its number of uses to zero and changing its status to AVAILABLE.
     *
     * @param electricBike The ElectricBike to be repaired.
     * @return Information about the mechanic's intervention on the ElectricBike.
     */
	@Override
	public String visit(ElectricBike electricBike) {
		electricBike.setNbUsedToZero();
		electricBike.setStatus(Status.AVAILABLE);
		return "Intervention d'un mechanicien sur un ElectricBike : " + electricBike.toString();
	}
	
	/**
     * Repairs an ElectricScooter, setting its number of uses to zero and changing its status to AVAILABLE.
     *
     * @param electricScooter The ElectricScooter to be repaired.
     * @return Information about the mechanic's intervention on the ElectricScooter.
     */
	@Override
	public String visit(ElectricScooter electricScooter) {
		electricScooter.setNbUsedToZero();
		electricScooter.setStatus(Status.AVAILABLE);
		return "Intervention d'un mechanicien sur un ElectricScooter : " + electricScooter.toString();
	}
	
	/**
     * Repairs a FoldingClassicBike, setting its number of uses to zero and changing its status to AVAILABLE.
     *
     * @param foldingClassicBike The FoldingClassicBike to be repaired.
     * @return Information about the mechanic's intervention on the FoldingClassicBike.
     */
	@Override
	public String visit(FoldingClassicBike foldingClassicBike) {
		foldingClassicBike.setNbUsedToZero();
		foldingClassicBike.setStatus(Status.AVAILABLE);
		return "Intervention d'un mechanicien sur un ClassicBike pliant : " + foldingClassicBike.toString();
	}
	
	/**
     * Repairs a FoldingElectricBike, setting its number of uses to zero and changing its status to AVAILABLE.
     *
     * @param foldingElectricBike The FoldingElectricBike to be repaired.
     * @return Information about the mechanic's intervention on the FoldingElectricBike.
     */
	@Override
	public String visit(FoldingElectricBike foldingElectricBike) {
		foldingElectricBike.setNbUsedToZero();
		foldingElectricBike.setStatus(Status.AVAILABLE);
		return "Intervention d'un mechanicien sur un ElectricBike pliant : " + foldingElectricBike.toString();
	}
	
}
