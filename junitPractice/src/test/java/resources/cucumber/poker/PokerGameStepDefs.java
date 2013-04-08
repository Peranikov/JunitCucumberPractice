package cucumber.poker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import cucumbar.poker.PokerGame;
import cucumber.api.java.en.*;

public class PokerGameStepDefs {

	PokerGame sut;

	@Given("^hands,([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)dealt$")
	public void 手札にカードが配られた(char suit1, int no1, char suit2, int no2,
			char suit3, int no3, char suit4, int no4, char suit5, int no5) {
		// Express the Regexp above with the code you wish you had
		sut = new PokerGame();
		sut.setUp(
				Card.get(suit1, no1),
				Card.get(suit2, no2),
				Card.get(suit3, no3),
				Card.get(suit4, no4),
				Card.get(suit5, no5));
	}

	@When("^NoChange$")
	public void チェンジしない() throws Throwable {
		sut.noChange();
	}

	@Then("^NoPair$")
	public void NoPair() {
		Pat result = sut.pat();
		assertThat(result, is(Pat.NO_PAIR));
	}

	@Then("^OnePairFor(\\d+)$")
	public void OnePair(int no) {
		Pat expected = new Pat.NoPair();
		assertThat(sut.pat(), is(expected));
	}
}
