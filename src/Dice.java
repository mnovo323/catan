import java.util.Random;

public class Dice {
	// private random obj
	private static Random rand;
	
	public static int roll() {
		// roll 2 dice and return their addition
		return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
	}
}
