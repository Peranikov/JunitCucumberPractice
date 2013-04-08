package cucumber.poker;

public class PokerGame {
	private enum Status {
		INIT,
		READY,
		CHANGED
	}

	private Status status = Status.INIT;
	private Hands hands = null;

	public void setUp(Card... cards) {
		if (status != Status.INIT) throw new IllegalArgumentException();
		hands = new Hands(cards);
		this.status = Status.READY;
	}

	public void noChange() {
		if (status != Status.READY) throw new IllegalArgumentException();
		// do nothing
		this.status = Status.CHANGED;
	}

	public Pat pat() {
		if (status != Status.CHANGED) throw new IllegalArgumentException();
		return Pat.make(hands);
	}
}