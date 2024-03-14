
import java.util.*;
import decorator.*;
import observer.*;
import strategy.*;
import util.Status;
import observer.*;

public class Main {

	public static void main(String[] args) {
		List<UrbanTravel> urbanTravels = new ArrayList<>();
		List<ToolsForDecorating> toolsForDecorating1 = new ArrayList<>();
		List<ToolsForDecorating> toolsForDecorating2 = new ArrayList<>();
		List<Station> stations = new ArrayList<>();	
		RedistributionStrategy strategy = new RandomStrategy();
		ControlCenter controlCenter = new ControlCenter(1,"LILLE CENTRE",stations,strategy,2);
		
		int idUrbanTravel = 1;
		int idDecoratorUrbanTravel = idUrbanTravel*100;
		int idStation = 1;
		
		Basket basket = new Basket(5);
		LuggageRacks luggageRacks = new LuggageRacks(2);
		PhoneSupport phoneSupport = new PhoneSupport();
		toolsForDecorating1.add(basket);
		toolsForDecorating1.add(luggageRacks);
		
		toolsForDecorating2.add(phoneSupport);
		
		for (int i =0 ; i<3 ; i++) {
			ClassicBike classicBike = new ClassicBike(idUrbanTravel,Status.AVAILABLE);
			ElectricBike electricBike = new ElectricBike(idUrbanTravel+=1,12,Status.AVAILABLE);
			ElectricScooter electricScooter = new ElectricScooter(idUrbanTravel+=1,24,Status.AVAILABLE);
			FoldingClassicBike foldingClassicBike = new FoldingClassicBike(idUrbanTravel+=1,Status.AVAILABLE);
			FoldingElectricBike foldingElectricBike = new FoldingElectricBike(idUrbanTravel+=1,48,Status.AVAILABLE);
			idUrbanTravel+=1;
			
			ClassicBike classicBikeDecorated = new ClassicBike(idDecoratorUrbanTravel,Status.AVAILABLE);
			ElectricBike electricBikeDecorated = new ElectricBike(idDecoratorUrbanTravel+=10,12,Status.AVAILABLE);
			ElectricScooter electricScooterDecorated = new ElectricScooter(idDecoratorUrbanTravel+=10,24,Status.AVAILABLE);
			FoldingClassicBike foldingClassicBikeDecorated = new FoldingClassicBike(idDecoratorUrbanTravel+=10,Status.AVAILABLE);
			FoldingElectricBike foldingElectricBikeDecorated = new FoldingElectricBike(idDecoratorUrbanTravel+=10,48,Status.AVAILABLE);
			idDecoratorUrbanTravel+=100;
			
			urbanTravels.add(classicBike);
			urbanTravels.add(electricBike);
			urbanTravels.add(electricScooter);
			urbanTravels.add(foldingClassicBike);
			urbanTravels.add(foldingElectricBike);
			
			urbanTravels.add(new DecoratorUrbanTravel(classicBikeDecorated,toolsForDecorating1));
			urbanTravels.add(new DecoratorUrbanTravel(electricBikeDecorated,toolsForDecorating1));
			
			urbanTravels.add(new DecoratorUrbanTravel(electricScooterDecorated,toolsForDecorating2));
			urbanTravels.add(new DecoratorUrbanTravel(foldingClassicBikeDecorated,toolsForDecorating2));
			urbanTravels.add(new DecoratorUrbanTravel(foldingElectricBikeDecorated,toolsForDecorating2));
	
		}
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Creation des UrbanTravel basic et aussi des urbanTravel decores avec des panier ou bien des portes bagages ou des support telephone ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		for(UrbanTravel urb : urbanTravels) {
			System.out.println(urb);
		}
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Le nombre des urbanTravel crees est " + urbanTravels.size());
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		for (int i=0 ; i<5 ; i++) {
			Station station = new Station(idStation,"Station "+ idStation);
			stations.add(station);
			station.addObserver(controlCenter);
			idStation+=1;
		}
					
		int stationIndex = 0;
		Collections.shuffle(urbanTravels);
		for (UrbanTravel urbanTravel : urbanTravels) {
			Station station = stations.get(stationIndex);
			station.addUrbanTravel(urbanTravel);
			stationIndex = (stationIndex+1)%stations.size();
		}
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Creation de 6 stations dont une qui reste vide et qui seront observe par un centre de controle et les remplir manuellement avec les urbanTravels crees juste avant suivi des notification apres chaque ajout d'un urbanTravel dans une station ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		Station station6 = new Station(2,"station 6");
		station6.addObserver(controlCenter);
		stations.add(station6);
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		for (Station station : stations) {
			System.out.println(station.getName() + " a : " + station.getCapacity() + " emplacements et le nombre de places occupees pour l'instant est : " + station.getOccupedSpaceCount()  + ". la liste des urbantravel : " + station.getUrbanTravels());
		}
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Modification du status de l'ensemble des urbanTravels de la premiere station en UNAVAILABLE de " + stations.get(0).getName() + " , suivi d'une tentative de location d'un urbanTravel et qui nous affiche une phrase nous indique qu'on peut pas louer un urbanTravel vu que tous les urbanTravel dans cette station sont tous UNAVAILABLE ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		for (UrbanTravel urb : stations.get(0).getUrbanTravels()) {
			urb.setStatus(Status.OUT_OF_SERVICE);
		}
		stations.get(0).rent();
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Tentative de location d'un urbanTravel de la deuxieme station " + stations.get(1).getName() + " qui a au moins un urbanTravel AVAILABLE et donc le centre de controle sera notifie vu que y 'a bien un rent et donc le nombre d'urbanTravel dans cette station diminue de 1");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		stations.get(1).rent();
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Tentative de location d'un urbanTravel dans la derniere station : " + stations.get(5).getName() + " qui est vide (cette station n'etait pas concerne par la distribution des urbanTravel au debut ) et donc on aura une phrase qui nous indique que cette station est vide ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		stations.get(5).rent();
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Ajout d'un urbanTravel à la dernière station, suivi de 6 tentatives de location de cet urbanTravel (afin de tester qu'un urbanTravel ne peut pas être loué au-delà de son nombre maximal de locations) en plus de ça on aura 5 redistribution des urbanTravel parce que a chaque rent la station reste vide est cela declenche une distributuion automatique 5 fois ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		System.out.println(" Chaque rent : la station reste vide et cela declenche une distributuion automatique et comme on a rent 5 fois le meme urbanTravel donc on aura 5 redistribution par le centre de controle ");
		System.out.println("************************************************************************************************************************************************************************************************************************************************");
		
		ClassicBike classic = new ClassicBike(5,Status.AVAILABLE);
		stations.get(5).addUrbanTravel(classic);
		System.out.println("1ER LOCATION");
		stations.get(5).rent();
		stations.get(5).addUrbanTravel(classic);
		System.out.println("2EME LOCATION");
		stations.get(5).rent();
		stations.get(5).addUrbanTravel(classic);
		System.out.println("3EME LOCATION");
		stations.get(5).rent();
		stations.get(5).addUrbanTravel(classic);
		System.out.println("4EME LOCATION");
		stations.get(5).rent();
		stations.get(5).addUrbanTravel(classic);
		System.out.println("5EME LOCATION");
		stations.get(5).rent();
		stations.get(5).addUrbanTravel(classic);
		System.out.println("TENTATIVE d'UNE 6EME LOCATION DONC ON AURA UN MECHANICIEN QUI VA INTERVENIR ");
		stations.get(5).rent();		
	}

}