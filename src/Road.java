
public class Road {
	private Coord a;
	private Coord b;
	
	public Road(Coord x, Coord y) {
		if (x.isLessThan(y)) {
			a = x;
			b = y;
		} else {
			a = y;
			b = x;
		}
	}
}

// Need a graph for road networks and to do path finding for AI