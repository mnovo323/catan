import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	public static HashMap<Coord, ArrayList<Hex>> vertexToAdjacentHexes = new HashMap<Coord, ArrayList<Hex>>();
	
	//making this static so that I can access it easily in each player object to compare road vertices to possible settlement hexes.
	public static HashMap<Coord, Boolean> vertexPossibleSettlement = new HashMap<Coord, Boolean>();
	
	// need every Coord array to be sorted.
	public ArrayList<Coord[]> currRoadLocations;
	
	private Coord[] hexCoords = {new Coord(0,2,-2), new Coord(1,1,-2), new Coord(2,0,-2), 
			new Coord(-1,2,-1), new Coord(0,1,-1), new Coord(1,0,-1), new Coord(2,-1,-1), 
			new Coord(-2,2,0), new Coord(-1,1,0), new Coord(0,0,0), new Coord(1,-1,0), new Coord(2,-2,0), 
			new Coord(-2,1,1), new Coord(-1,0,1), new Coord(0,-1,1), new Coord(1,-2,1), 
			new Coord(-2,0,2), new Coord(-1,-1,2), new Coord(0,-2,2)};
	
	public Hex[] tiles;
	
	public Board() {
		
		// I mean this would be brain dead easy in Python
		// I have no clue if this is hacky or not...
		ArrayList<Integer> numbers= new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(3);
		numbers.add(4);
		numbers.add(4);
		numbers.add(5);
		numbers.add(5);
		numbers.add(6);
		numbers.add(6);
		numbers.add(8);
		numbers.add(8);
		numbers.add(9);
		numbers.add(9);
		numbers.add(10);
		numbers.add(10);
		numbers.add(11);
		numbers.add(11);
		numbers.add(12);
		
		Collections.shuffle(numbers);
		
		tiles = new Hex[19];
		
		ArrayList<Resource> tileResources = new ArrayList<Resource>();
		
		tileResources.add(Resource.wheat);
		tileResources.add(Resource.wheat);
		tileResources.add(Resource.wheat);
		tileResources.add(Resource.wheat);
		tileResources.add(Resource.lumber);
		tileResources.add(Resource.lumber);
		tileResources.add(Resource.lumber);
		tileResources.add(Resource.lumber);
		tileResources.add(Resource.wool);
		tileResources.add(Resource.wool);
		tileResources.add(Resource.wool);
		tileResources.add(Resource.wool);
		tileResources.add(Resource.ore);
		tileResources.add(Resource.ore);
		tileResources.add(Resource.ore);
		tileResources.add(Resource.brick);
		tileResources.add(Resource.brick);
		tileResources.add(Resource.brick);
		tileResources.add(Resource.desert);
		
		Collections.shuffle(tileResources);
		
		for(int i = 0; i < 19; i++) {
			if (tileResources.get(i) != Resource.desert) {
				tiles[i] = new Hex(hexCoords[i], tileResources.get(i), numbers.remove(0));
			} else {
				tiles[i] = new Hex(hexCoords[i], tileResources.get(i), 0);
			}
		}
		
		for(int i = 0; i < 19; i++) {
			Hex hex = tiles[i];
			
			Coord[] vertices = hex.getVertices();
			
			for (int j = 0; j < vertices.length; j++) {
				if (vertexToAdjacentHexes.containsKey(vertices[j])) {
					vertexToAdjacentHexes.get(vertices[j]).add(hex);
				} else {
					ArrayList<Hex> hexList = new ArrayList<Hex>();
					hexList.add(hex);
					vertexToAdjacentHexes.put(vertices[j], hexList);
				}
				
				vertexPossibleSettlement.putIfAbsent(vertices[j], true);
			}
		}
		
		currRoadLocations = new ArrayList<Coord[]>();
		
		
	}
	
	public static ArrayList<Hex> getAdjacentHexes(Coord coord) {
		return vertexToAdjacentHexes.get(coord);
	}
}
