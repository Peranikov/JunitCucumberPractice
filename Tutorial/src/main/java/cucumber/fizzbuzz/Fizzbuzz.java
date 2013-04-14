package cucumber.fizzbuzz;

public class Fizzbuzz {
	
	private int _val;
	public static String FIZZ = "Fizz";
	public static String BUZZ = "Buzz";
	public static String FIZZ_BUZZ = "FizzBuzz";
	
	public Fizzbuzz(int val) {
		_val = val;
	}
	
	public String result() {
		if (isFizzBuzz(this._val)) return FIZZ_BUZZ;
		if (isFizz(this._val)) return FIZZ;
		if (isBuzz(this._val)) return BUZZ;
		
		return String.format("%d", this._val);
	}
	
	public static boolean isFizz(int val) {
		return val % 3 == 0 ? true : false;
	}

	public static boolean isBuzz(int val) {
		return val % 5 == 0 ? true : false;
	}

	public static boolean isFizzBuzz(int val) {
		return val % 3 == 0 && val % 5 == 0 ? true : false;
	}
}
