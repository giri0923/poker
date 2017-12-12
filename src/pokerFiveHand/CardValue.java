package pokerFiveHand;
/**
 * @author girish
 * Enum Type for CardValue ranges from 2 to Ace (highest value). Ace can be considered as lowest as well based on the requirements.
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
	 * Return the cardValue for corresponding card number for example returns CardValue.Three
	 */
	public static CardValue getCardValue(int val) {
		switch(val) {

			case 2:
				return CardValue.Two;
			case 3:
				return CardValue.Three;
			case 4:
				return CardValue.Four;
			case 5:
				return CardValue.Five;
			case 6:
				return CardValue.Six;
			case 7:
				return CardValue.Seven;
			case 8:
				return CardValue.Eight;
			case 9:
				return CardValue.Nine;
			case 10:
				return CardValue.Ten;
			case 11:
				return CardValue.Jack;
			case 12:
				return CardValue.Queen;
			case 13:
				return CardValue.King;
			case 14:
				return CardValue.Ace;
			default:
				return null;
		}
	}

}
