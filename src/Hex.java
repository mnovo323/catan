
/**
 * Represents a single hexagon tile in Catan.
 * @author michael novotny
 *
 */
public class Hex {
	public Coord coordinates;
	public Resource type;
	public int hitNumber;
	private Coord[] vertices;
	public boolean bandit;
	
	public Hex(Coord coord, Resource resource, int number) {
		coordinates = coord;
		type = resource;
		
		if (resource == Resource.desert) {
			bandit = true;
		} else {
			bandit = false;
		}
		
		vertices = new Coord[6];
		
		int x = coord.getX();
		int y = coord.getY();
		int z = coord.getZ();
		
		// hard-coding this in cause I don't want to think about it
		vertices[0] = new Coord(x + 1, y, z);
		vertices[1] = new Coord(x, y + 1, z);
		vertices[2] = new Coord(x, y, z + 1);
		vertices[3] = new Coord(x + 1, y + 1, z);
		vertices[4] = new Coord(x + 1, y, z + 1);
		vertices[5] = new Coord(x, y + 1, z + 1);
		
		hitNumber = number;
		
	}
	
	/**
	 * @return An array of Coord objects for each vertex of the hex
	 */
	public Coord[] getVertices() {
		return vertices;
	}
}
