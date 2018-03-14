package S3;

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

//	public Player getCurrentPlayer(int i) {
//		return getTurn(i);
//	}


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
