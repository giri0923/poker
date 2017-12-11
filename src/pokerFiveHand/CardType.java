package pokerFiveHand;

/**
 * @author girish
 * Enum Type for CardType
 */

public enum CardType {
	Diamond(0),
	Heart(1),
	Club(2),
	Spade(3);

	private int cardType;

	/**
	 * @param val
	 */
	private CardType(int val)
	{
		cardType = val;
	}

	/**
	 * @return
	 */
	public int getType() {
		return this.cardType;
	}

	/**
	 * @param val
	 * @return
	 */
	public static CardType getCardType(int val) {
		switch(val) {
			case 0:
				return CardType.Diamond;
			case 1:
				return CardType.Heart;
			case 2:
				return CardType.Club;
			case 3:
				return CardType.Spade;
			default:
					return null;
		}
	}
}
