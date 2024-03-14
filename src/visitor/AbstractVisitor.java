package visitor;

import decorator.*;

public interface AbstractVisitor {

	public String visit(ClassicBike classicBike);
	public String visit(ElectricBike electricBike);
	public String visit(ElectricScooter electricScooter);
	public String visit(FoldingClassicBike foldingClassicBike);
	public String visit(FoldingElectricBike foldingElectricBike);
}
