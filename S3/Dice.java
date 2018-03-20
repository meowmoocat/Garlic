/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */
package S3;

public class Dice {

	private static final int NUM_DICE = 2;

	private final int[] dice = new int [NUM_DICE];

	// creates 2 dice and sets the value to be a random number between 1 and 6 for each dice
	public void roll() {
		for (int i=0; i<NUM_DICE; i++) {
			dice[i] = 1 + (int)(Math.random() * 6);
		}
	}
	//adds the two dice values to see the amount of moves the player can go
	public int getTotal() {
		return (dice[0] + dice[1]);
	}
	//displays the dic values
	public String toString() {
		return dice[0] + " " + dice[1];
	}

}
