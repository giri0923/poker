package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import pokerFiveHand.CardType;
import pokerFiveHand.CardValue;
import pokerFiveHand.Poker;
import pokerFiveHand.PokerCard;
import pokerFiveHand.PokerHand;
import pokerFiveHand.PokerHandType;

/**
 * @author girish
 *
 */
public class PokerTest {

	Poker poker = new Poker();

	@Test
	public void testHandValue_OnePair() {
		// one pair
		PokerHand hand1 = new PokerHand(new PokerCard(CardValue.Ten, CardType.Diamond),
				new PokerCard(CardValue.Ten, CardType.Club),
				new PokerCard(CardValue.Three, CardType.Diamond),
				new PokerCard(CardValue.King, CardType.Diamond),
				new PokerCard(CardValue.Ace, CardType.Diamond));

		hand1.computeValueOfHand();
		assertEquals(PokerHandType.OnePair, hand1.getHandType());
	}

	@Test
	public void testHandValue_TwoPair() {
		// one pair
		PokerHand hand1 = new PokerHand(new PokerCard(CardValue.Ten, CardType.Diamond),
				new PokerCard(CardValue.Ten, CardType.Club),
				new PokerCard(CardValue.Three, CardType.Diamond),
				new PokerCard(CardValue.King, CardType.Diamond),
				new PokerCard(CardValue.Ace, CardType.Diamond));

		hand1.computeValueOfHand();
		assertEquals(PokerHandType.TwoPair, hand1.getHandType());
	}

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

		assertEquals(hand2, poker.compare(hand1, hand2));
		assertEquals(PokerHandType.Flush, hand2.getHandType());
		assertEquals(PokerHandType.OnePair, hand1.getHandType());
	}

}
