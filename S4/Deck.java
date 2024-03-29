package S4;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Deck {

	private final Cards suspectCards = new Cards();
	private final Cards weaponCards  = new Cards();
	private final Cards roomCards  = new Cards();
	private final Cards allCards = new Cards();
	private final Cards murderCards = new Cards();
	private Cards sharedCards = new Cards();
	private int numberOfCardsEach;

	Deck() {
		for (String cardName : Names.SUSPECT_NAMES) {
			suspectCards.add(new Card(cardName));
		}
		for (String cardName : Names.WEAPON_NAMES) {
			weaponCards.add(new Card(cardName));
		}
		for (String cardName : Names.ROOM_CARD_NAMES) {
			roomCards.add(new Card(cardName));
		}
	}

	public void selectMurderCards () {
		suspectCards.shuffle();
		murderCards.add(suspectCards.take());
		weaponCards.shuffle();
		murderCards.add(weaponCards.take());
		roomCards.shuffle();
		murderCards.add(roomCards.take());
	}

	public Cards getMurderCards () {
		return murderCards;
	}

	public Cards getAllCards()
	{
		return allCards;
	}

	public void prepareToDeal(int numberOfPlayers) {
		allCards.addAll(suspectCards);
		allCards.addAll(weaponCards);
		allCards.addAll(roomCards);
		allCards.shuffle();
		numberOfCardsEach = allCards.count() / numberOfPlayers;
		int numberOfCardsShared = allCards.count() - numberOfCardsEach*numberOfPlayers;
		sharedCards = new Cards ();
		for (int i=0; i<numberOfCardsShared; i++) {
			sharedCards.add(allCards.take());
		}
	}

	public boolean isSharedCard(String name) {
		return sharedCards.contains(name);
	}

	public Cards dealCards() {
		Cards hand = new Cards();
		for (int i = 0; i<numberOfCardsEach; i++) {
			hand.add(allCards.take());
		}
		return hand;
	}

	public Cards viewedCards(Player player, Card card)
	{
		Cards viewedCards = new Cards();
		try {
			viewedCards.addAll(player.getViewedCard());
		} catch (Exception e) {
			//handle exception
		}
		viewedCards.add(card);
		return viewedCards;
	}

}
