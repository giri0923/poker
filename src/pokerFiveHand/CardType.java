package pokerFiveHand;

public enum CardType {
	Diamond(0),
	Heart(1),
	Club(2),
	Spade(3);
	
	private int cardType;
	
	private CardType(int val)
	{
		cardType = val;
	}
	
	public int getType() {
		return this.cardType;
	}
	
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
