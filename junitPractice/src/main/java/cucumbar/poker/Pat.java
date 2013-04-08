package cucumbar.poker;

import java.util.HashMap;
import java.util.Map.Entry;

public abstract class Pat {
	public static final Pat NO_PAIR = new NoPair();

	public static Pat make(Hands hands) {
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>(5);
		for (Card card : hands) {
			Integer count = nums.get(card.no);
			if (count == null) count = 0;
			count++;
			nums.put(card.no, count);
		}

		for (Entry<Integer, Integer> entry : nums.entrySet()) {
			if (entry.getValue() == 2) return new OnePair(entry.getKey());
		}

		// TODO 他の役の実装
		return NO_PAIR;
	}

	public static class OnePair extends Pat {
		public final int no;

		OnePair(int no) {
			this.no = no;
		}
	}

	public static class NoPair extends Pat {
	}
}
