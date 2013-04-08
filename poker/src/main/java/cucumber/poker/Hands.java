package cucumber.poker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hands implements Iterable<Card>{

	private static final int SIZE = 5;
	final Set<Card> cards = new HashSet<Card>(SIZE);

	public Hands(Card... cards) {
		if (cards.length != SIZE) throw new IllegalArgumentException();
		for (Card card : cards) {
			this.cards.add(card);
		}
	}

	public Iterator<Card> iterator() {
		return cards.iterator();
	}
}
