package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;

public class Tokens implements Iterable<Token>, Iterator<Token> {

	private final HashSet<Token> characters = new HashSet<>();
	private Iterator<Token> iterator;

	//creates instance of character tokens
	Tokens() {
		characters.add(new Token("Scarlett", Color.RED, new Coordinates(7,24), //coordinates starting
				new Coordinates(1,1), new Coordinates(10,6), new Coordinates(20,2), //compsci, O'Reilly, engineering
				new Coordinates(20,10), new Coordinates(18,15), new Coordinates(19,21), //sutherland, Quinn, newman
				new Coordinates(9,19), new Coordinates(2,19), new Coordinates(2,11))); //library, ag sci, OBrien

		characters.add(new Token("Mustard", Color.YELLOW, new Coordinates(0,17), 
				new Coordinates(2,1), new Coordinates(11,6), new Coordinates(21,2), 
				new Coordinates(21,10), new Coordinates(19,15), new Coordinates(20,21), 
				new Coordinates(10,19), new Coordinates(3,19), new Coordinates(3,11)));

		characters.add(new Token("White", Color.WHITE, new Coordinates(9,0), 
				new Coordinates(3,1), new Coordinates(12,6), new Coordinates(22,2), 
				new Coordinates(22,10), new Coordinates(18,16), new Coordinates(21,21), 
				new Coordinates(11,19), new Coordinates(4,19), new Coordinates(4,11)));

		characters.add(new Token("Green", Color.GREEN, new Coordinates(14,0), //green engineering?? weapon covering it
				new Coordinates(1,2), new Coordinates(10,7), new Coordinates(20,3), //obrien under weapon??
				new Coordinates(20,11), new Coordinates(19,16), new Coordinates(19,22), 
				new Coordinates(12,19), new Coordinates(2,20), new Coordinates(2,12)));

		characters.add(new Token("Peacock", new Color(0, 191, 255), new Coordinates(23,6), //peacock ag?? under weapon?
				new Coordinates(2,2), new Coordinates(11,7), new Coordinates(21,3), //peacock comsci same as mustard!! changed
				new Coordinates(21,11), new Coordinates(18,17), new Coordinates(20,22), 
				new Coordinates(13,19), new Coordinates(3,20), new Coordinates(3,12)));

		characters.add(new Token("Plum", new Color(148, 0, 211), new Coordinates(23,19), 
				new Coordinates(3,2), new Coordinates(12,7), new Coordinates(22,3), 
				new Coordinates(22,11), new Coordinates(19,17), new Coordinates(21,22), 
				new Coordinates(14,19), new Coordinates(4,20), new Coordinates(4,12)));
	}

	//loops through all characters and returns its token
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

	//loops through all characters and returns characters name
	public Token getCharacterName(String name)
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
