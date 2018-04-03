package S4;

import java.util.ArrayList;
import java.util.Collections;


public class Cards {

    private ArrayList<Card> cards =  new ArrayList<Card>();

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean contains(String name) {
			for (Card card : cards) {
				try {
					if (card.hasName(name)) {
//						System.out.println(num+": "+card.toString());
						return true;
					} 
				} catch (Exception e) {
//					System.out.println(num+": exception "+name);
					// TODO: handle exception
				}
			} 
		return false;
    }
    
    public Card isCard(String name) {
        for (Card card : cards) {
            if (card.hasName(name)) {
                return card;
            }
        }
        return null;
    }

    private ArrayList<Card> asList() {
        return cards;
    }

    public void addAll(Cards cards) {
        this.cards.addAll(cards.asList());
    }

    public Card take() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public int count() {
        return cards.size();
    }

    public String toString() {
        StringBuilder cardNames = new StringBuilder();
        boolean firstCard = true;
        for (Card card : cards) {
            if (firstCard) {
                cardNames = new StringBuilder("" + card);
                firstCard = false;
            } else {
                cardNames.append(", ").append(card);
            }
        }
        return cardNames.toString();
    }
}
