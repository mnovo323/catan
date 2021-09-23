import java.util.ArrayList;
import java.util.HashMap;

public class Settlement {
	private Coord vertexLocation;
	private Player owner;
	private ArrayList<Hex> adjacentHexes;
	private HashMap<Integer, ArrayList<Resource>> rollToResource;
	
	//TODO: implement port
	
	public Settlement(Coord loc, Player p) {
		vertexLocation = loc;
		owner = p;
		adjacentHexes = Board.getAdjacentHexes(loc);
		
		rollToResource = new HashMap<Integer, ArrayList<Resource>>();
		
		for(int i = 0; i < adjacentHexes.size(); i++) {
			Hex currHex = adjacentHexes.get(i);
			
			if (rollToResource.containsKey(currHex.hitNumber)) {
				rollToResource.get(currHex).add(currHex.type);
			} else {
				ArrayList<Resource> resourceList = new ArrayList<Resource>();
				resourceList.add(currHex.type);
				rollToResource.put(currHex.hitNumber, resourceList);
			}
		}
	}
	
	public void processRoll(int roll) {
		if (rollToResource.containsKey(roll)) {
			for (int i = 0; i < rollToResource.get(roll).size(); i++) {
				owner.addResource(rollToResource.get(roll).get(i));
			}
		}
	}
}
