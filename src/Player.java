import java.util.ArrayList;

public class Player {
	// resource cards
	private ArrayList<Resource> resourceCardsList = new ArrayList<Resource>();
	// TODO: knight cards
	// TODO: special cards
	
	// settlements
	private ArrayList<Settlement> settlementList = new ArrayList<Settlement>();
	
	// Coord[] roads;
	// road pieces
	// settlement pieces
	// city pieces
	// points
	// available settlement locations
	
	// trade
	
	public void addResource(Resource resource) {
		resourceCardsList.add(resource);
	}
}
