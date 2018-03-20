package S3;

* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.util.ArrayList;
import java.util.Iterator;


public class Players implements Iterable<Player>, Iterator<Player> {

	private final ArrayList<Player> players = new ArrayList<>();
	public boolean hasBeenReordered = false;
	private Iterator<Player> iterator;

		
	//loops through all characters and returns characters name
	public Player getPlayer(String name)
	{
		for (Player player : players)
		{
			if (player.hasName(name))
			{
				return player;
			}
		}
		return null;
	}
	
	public void add(Player player) {
		players.add(player);
	}

	//checks if player name has already been entered or not
	public boolean contains(String name) {
		for (Player player : players) {
			if (player.hasName(name)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return players.size();
	}

	public Player get(int index) {
		return players.get(index);
	}
	
	public Player getPlayerTurn(int i)
	{
		for (Player player : players)
		{
			if (player.getTurn() == i)
			{
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Player next() {
		return iterator.next();
	}

	@Override
	public Iterator<Player> iterator() {
		iterator = players.iterator();
		return iterator;
	}

}
