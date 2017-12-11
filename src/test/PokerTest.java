package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import pokerFiveHand.CardType;
import pokerFiveHand.CardValue;
import pokerFiveHand.Poker;
import pokerFiveHand.PokerCard;
import pokerFiveHand.PokerHand;

/**
 * @author girish
 *
 */
public class PokerTest {

	Poker poker = new Poker();

	@Test
	public void test1() {
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

		assertEquals(2, poker.compare(hand1, hand2));
	}

}
