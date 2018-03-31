package S4;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Player {

	private final String name;
	private final Token token;
	private Cards cards;
	private Cards viewedCards;
//	private Cards viewedCards;

	Player(String name, Token token) {
		this.name = name;
		this.token = token;
		cards = new Cards();
		viewedCards = new Cards();
	}

	public boolean hasName(String name) {
		return this.name.toLowerCase().trim().equals(name.toLowerCase().trim());
	}

	public String getName() {
		return name;
	}

	public Token getToken() {
		return token;
	}

	public void addCards(Cards cards) {
		this.cards = cards;
	}
	
	public void addViewedCards(Card card) {
		this.viewedCards.add(card);
	}

	public boolean hasCard(String name) {
		return cards.contains(name);
	}

	@Override
	public String toString() {
		return name + " (" + token.getName() + ")";
	}

	public boolean isViewedCard(String cardName) {
		return viewedCards.contains(name);
	}
	
}
