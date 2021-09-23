
public class Coord {
	private int x, y, z;
	
	public Coord(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public boolean equals(Coord coord) {
		if (x == coord.getX() && y == coord.getY() && z == coord.getZ()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int h = 0;
		if (x < 0) {
			x *= -4;
		} if (y < 0 ) {
			y *= -4;
		} if (z < 0) {
			z *= -4;
		}
		
		h = (x * 100) + (y * 10) + z;
		
		return h;
	}
	
	public boolean isLessThan(Coord coord) {
		if (x < coord.getX()) {
			return true;
		} else if (y < coord.getY()) {
			return true;
		} else if (z < coord.getZ()) {
			return true;
		}
	}
}
