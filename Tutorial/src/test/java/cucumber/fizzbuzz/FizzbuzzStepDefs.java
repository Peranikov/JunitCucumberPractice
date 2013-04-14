package cucumber.fizzbuzz;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.前提;

public class FizzbuzzStepDefs {
	
	private Fizzbuzz _fizzbuzz;
	
	@前提("^(\\d+)の場合$")
	public void nの場合(int n) throws Throwable {
		_fizzbuzz = new Fizzbuzz(n);
	}

	@ならば("^(\\d+)であるべき$")
	public void nであるべき(int val) throws Throwable {
		Assert.assertThat(_fizzbuzz.result(), CoreMatchers.equalTo(String.format("%d", val)));
	}

	@ならば("Fizzであるべき$")
	public void Fizzであるべき() throws Throwable {
		Assert.assertThat(_fizzbuzz.result(), CoreMatchers.equalTo("Fizz"));
	}

	@ならば("Buzzであるべき$")
	public void Buzzであるべき() throws Throwable {
		Assert.assertThat(_fizzbuzz.result(), CoreMatchers.equalTo("Buzz"));
	}

	@ならば("FizzBuzzであるべき$")
	public void FizzBuzzであるべき() throws Throwable {
		Assert.assertThat(_fizzbuzz.result(), CoreMatchers.equalTo("FizzBuzz"));
	}
}
