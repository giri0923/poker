package pokerFiveHand;

/**
 * @author girish
 * Type for PokerCard
 */

public class PokerCard{
	private CardValue cardValue;
	private CardType cardType;

	/**
	 * @param value
	 * @param type
	 */
	public PokerCard(CardValue value, CardType type)
	{
		this.cardValue = value;
		this.cardType = type;
	}

	/**
	 * @return
	 */
	public CardValue getCardValue() {
		return cardValue;
	}

	/**
	 * @return
	 */
	public CardType getCardType() {
		return cardType;
	}

	@Override
	public String toString() {
		return this.cardType + " " + this.cardValue;
	}

}
