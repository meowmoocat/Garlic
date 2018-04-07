package S4;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Card {

	private final String name;

	Card(String name) {
		this.name = name;
	}

	public boolean hasName(String name) {
		return (this.name.toLowerCase().trim().equals(name.toLowerCase().trim()));
	}

	public String toString() {
		return name;
	}
}
