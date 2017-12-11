package test;

import org.junit.Test;

import pokerFiveHand.CardType;
import pokerFiveHand.CardValue;
import pokerFiveHand.Poker;
import pokerFiveHand.PokerCard;
import pokerFiveHand.PokerHand;

public class PokerTest {
// Error - 4 different types
	//number below 0 and above 12
	@Test
	public void test() {
//PokerCard card = new PokerCard(1, CardType.Club);

		// one pair
		PokerHand hand1 = new PokerHand(new PokerCard(CardValue.Ten, CardType.Diamond),
				new PokerCard(CardValue.Ten, CardType.Club),
				new PokerCard(CardValue.Three, CardType.Diamond),
				new PokerCard(CardValue.King, CardType.Diamond),
				new PokerCard(CardValue.Ace, CardType.Diamond));

		// Flush
		PokerHand hand2 = new PokerHand(new PokerCard(CardValue.Nine, CardType.Diamond),
				new PokerCard(CardValue.Ten, CardType.Diamond),
				new PokerCard(CardValue.Four, CardType.Diamond),
				new PokerCard(CardValue.Three, CardType.Diamond),
				new PokerCard(CardValue.King, CardType.Diamond));

		//0,9,10,11,12
		//PokerHand hand2 = new PokerHand();

		Poker poker = new Poker();
		//hand1.getValueOfHand();
		//System.out.println(hand1.getValueOfHand());
		int winner = poker.compare(hand1, hand2);
		if(winner==0)
			System.out.println("Draw");
		else

		System.out.println("Winner is player" + winner);

		//assertEquals();

	}

}
