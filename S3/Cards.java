package S3;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Cards implements Iterable<Card>, Iterator<Card>{

	public final ArrayList<Card> cards = new ArrayList<Card>();
	private Iterator<Card> iterator;

	Cards()
	{
		for(int i=0; i<Names.SUSPECT_NAMES.length; i++)
		{
			cards.add(new Card(Names.SUSPECT_NAMES[i], "tokens"));
		}
		for(int i=0; i<Names.ROOM_NAMES.length; i++)
		{
			cards.add(new Card(Names.ROOM_NAMES[i], "rooms"));
		}
		for(int i=0; i<Names.WEAPON_NAMES.length; i++)
		{
			cards.add(new Card(Names.WEAPON_NAMES[i], "weapons"));
		}
		cards.remove(15);
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Card next() {
		return iterator.next();
	}

	@Override
	public Iterator<Card> iterator() {
		iterator = cards.iterator();
		return iterator;
	}

	public void shuffleCards() {
		Collections.shuffle(cards);
	}

}
