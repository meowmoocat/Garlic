package garlic;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;

public class Tokens implements Iterable<Token>, Iterator<Token> {

	private final HashSet<Token> characters = new HashSet<>();
	private Iterator<Token> iterator;

	Tokens() {
		characters.add(new Token("Scarlett", Color.RED, new Coordinates(7,24)));
		characters.add(new Token("Mustard", Color.YELLOW, new Coordinates(0,17)));
		characters.add(new Token("White", Color.WHITE, new Coordinates(9,0)));
		characters.add(new Token("Green", Color.GREEN, new Coordinates(14,0)));
		characters.add(new Token("Peacock", new Color(0, 191, 255), new Coordinates(23,6)));
		characters.add(new Token("Plum", new Color(148, 0, 211), new Coordinates(23,19)));
	}

	public Token get(int i)
	{
		for (Token character : characters)
		{
			if (character.getTurn() == i)
			{
				return character;
			}
		}
		return null;
	}
	
	public Token getName(String name)
	{
		for (Token character : characters)
		{
			if (character.hasName(name))
			{
				return character;
			}
		}
		return null;
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public Token next() {
		return iterator.next();
	}

	public Iterator<Token> iterator() {
		iterator = characters.iterator();
		return iterator;
	}

}
