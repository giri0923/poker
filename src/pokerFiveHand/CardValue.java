package pokerFiveHand;

/**
 * @author girish
 * Enum Type for CardValue
 *
 */

public enum CardValue {
	//Ace(0),
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(11),
	Queen(12),
	King(13),
	Ace(14);

	private int cardValue;

	/**
	 * @param val
	 */
	private CardValue(int val)
	{
		this.cardValue = val;
	}

	/**
	 * @return
	 */
	public int getValue() {
		return this.cardValue;
	}

	/**
	 * @param val
	 * @return
	 */
	public static CardValue getCardValue(int val) {
		switch(val) {
			case 0:
				return CardValue.Ace;
			case 1:
				return CardValue.Two;
			case 2:
				return CardValue.Three;
			case 3:
				return CardValue.Four;
			case 4:
				return CardValue.Five;
			case 5:
				return CardValue.Six;
			case 6:
				return CardValue.Seven;
			case 7:
				return CardValue.Eight;
			case 8:
				return CardValue.Nine;
			case 9:
				return CardValue.Ten;
			case 10:
					return CardValue.Jack;
			case 11:
					return CardValue.Queen;
			case 12:
				return CardValue.King;
			default:
					return null;
		}
	}

}
