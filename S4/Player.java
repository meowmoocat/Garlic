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
	private Boolean accuseGuessed = false;

	Player(String name, Token token) {
		this.name = name;
		this.token = token;
		cards = new Cards();
		viewedCards = new Cards();
	}

	public Boolean getAccuseGuessed()
	{
		return accuseGuessed;
	}

	public Card getCard(String name)
	{
		return cards.isCard(name);
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

	public Cards getViewedCard()
	{
		return viewedCards;
	}

	public void setAccuseGuessed(Boolean guessed)
	{
		this.accuseGuessed = guessed;
	}

	public boolean isViewedCard(String name) {
		return viewedCards.contains(name);
	}

	public void addCards(Cards cards) {
		this.cards = cards;
	}

	public void addViewedCards(Cards cards) {
		this.viewedCards = cards;
	}

	public boolean hasCard(String name) {
		return cards.contains(name);
	}

	@Override
	public String toString() {
		return name + " (" + token.getName() + ")";
	}

}
