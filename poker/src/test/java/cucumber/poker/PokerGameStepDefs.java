package cucumber.poker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;
import cucumber.poker.Card.Suit;

public class PokerGameStepDefs {

	PokerGame sut;

	@前提("^手札に([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)が配られた$")
	public void 手札にカードが配られた(
			char suit1, int no1,
			char suit2, int no2,
			char suit3, int no3,
			char suit4, int no4,
			char suit5, int no5) throws Throwable {
		sut = new PokerGame();
		sut.setUp(
				Card.get(suit1, no1),
				Card.get(suit2, no2),
				Card.get(suit3, no3),
				Card.get(suit4, no4),
				Card.get(suit5, no5)
				);
	}

	@もし("^チェンジしない$")
	public void チェンジしない() {
		sut.noChange();
	}

	@ならば("^ノーペアであるべき$")
	public void ノーペアであるべき() {
		assertThat(sut.pat(), equalTo(Pat.NO_PAIR));
	}

	@ならば("^([SHDC])のフラッシュであるべき$")
	public void フラッシュであるべき(char arg) {
		
		Card.Suit suit;
		
		switch (arg) {
		case 'D' :
			suit = Suit.DIAMONDS;
			break;
		case 'S' :
			suit = Suit.SPADES;
			break;
		case 'H' :
			suit = Suit.HEARTS;
			break;
		case 'C' :
			suit = Suit.CLUBS;
			break;
		default :
			throw new IllegalArgumentException();
		}
		Pat expected = new Pat.Flash(suit);
		assertThat(sut.pat(), equalTo(expected));
	}

	@ならば("^(\\d+)のワンペアであるべき$")
	public void ワンペアであるべき(int no) {
		Pat expected = new Pat.OnePair(no);
		assertThat(sut.pat(), equalTo(expected));
	}

	@ならば("^(\\d+)のスリーカードであるべき$")
	public void スリーカードであるべき(int no) {
		Pat expected = new Pat.ThreeCard(no);
		assertThat(sut.pat(), equalTo(expected));
	}
}
