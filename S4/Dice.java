package S4;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Dice {

	private static final int NUM_DICE = 2;

	private final int[] dice   = new int[NUM_DICE];

	public void roll() {
		for (int i=0; i<NUM_DICE; i++) {
			dice[i] = 1 + (int)(Math.random() * 6);
		}
	}

	public int getTotal() {
		return (dice[0] + dice[1]);
	}

	public String toString() {
		return dice[0] + " " + dice[1];
	}

}
