package pokerFiveHand;

public class PokerCard{
	private CardValue cardValue;
	private CardType cardType;
	
	public PokerCard(CardValue value, CardType type)
	{
		this.cardValue = value;
		this.cardType = type;
	}

	public CardValue getCardValue() {
		return cardValue;
	}

	public CardType getCardType() {
		return cardType;
	}

	@Override 
	public String toString() {
		return this.cardType + " " + this.cardValue;
	}

}
