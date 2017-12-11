package pokerFiveHand;

/**
 * @author girish
 * Enum for PokerHandType
 */

public enum PokerHandType {
	Bust(0),
	OnePair(1),
	TwoPair(2),
	ThreeOfAKind(3),
	Straight(4),
	Flush(5),
	FullHouse(6),
	FourOfAKind(7),
	StraightFlush(8),
	RoyalFlush(9);

	private int pokerHandType;

	/**
	 * @param val
	 */
	private PokerHandType(int val) {
		this.pokerHandType = val;
	}

	/**
	 * @return
	 */
	public int getPokerHandType() {
		return this.pokerHandType;
	}

	/**
	 * @param val
	 * @return
	 */
	public static PokerHandType getPokerHandType(int val) {
		switch(val) {
			case 0:
			  return PokerHandType.Bust;
			case 1:
			  return PokerHandType.OnePair;
			case 2:
			  return PokerHandType.TwoPair;
			case 3:
			  return PokerHandType.ThreeOfAKind;
			case 4:
			  return PokerHandType.Straight;
			case 5:
			  return PokerHandType.Flush;
			case 6:
			  return PokerHandType.FullHouse;
			case 7:
			  return PokerHandType.FourOfAKind;
			case 8:
			  return PokerHandType.StraightFlush;
			case 9:
			  return PokerHandType.RoyalFlush;
			default:
			  return null;
		}
	}
}
