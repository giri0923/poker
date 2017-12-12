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
 * Creates PockerHand objects of various combinations (including poker hand types)
 * There are 2 types of test cases:
 * 1. Cases that focus on hand evaluation (checks if the hand is correctly evaluated)
 * 2. Tests that compare two given hands.
 *
 */
public class PokerTest {

	Poker poker = new Poker(); // to call the compare method in Poker.java

	//High Card King
	PokerHand HighCard_King =
			new PokerHand(new PokerCard(CardValue.Ten, CardType.Diamond),
			new PokerCard(CardValue.Two, CardType.Club),
			new PokerCard(CardValue.Three, CardType.Diamond),
			new PokerCard(CardValue.King, CardType.Diamond),
			new PokerCard(CardValue.Jack, CardType.Diamond));

	//High card - King
	PokerHand HighCard_King2 =
			new PokerHand(new PokerCard(CardValue.Ten, CardType.Diamond),
			new PokerCard(CardValue.Two, CardType.Club),
			new PokerCard(CardValue.Three, CardType.Diamond),
			new PokerCard(CardValue.King, CardType.Heart),
			new PokerCard(CardValue.Four, CardType.Diamond));

	// pair of 6's ,High card Five
	PokerHand PairOfSix =
	    	new PokerHand(new PokerCard(CardValue.Two, CardType.Spade),
			new PokerCard(CardValue.Five, CardType.Heart),
			new PokerCard(CardValue.Four, CardType.Diamond),
			new PokerCard(CardValue.Six, CardType.Heart),
			new PokerCard(CardValue.Six, CardType.Club));

	PokerHand PairOfSix_2 =
	    	new PokerHand(new PokerCard(CardValue.Two, CardType.Spade),
			new PokerCard(CardValue.Five, CardType.Heart),
			new PokerCard(CardValue.Eight, CardType.Diamond),
			new PokerCard(CardValue.Six, CardType.Heart),
			new PokerCard(CardValue.Six, CardType.Club));

	//A pair of 2's
	      PokerHand PairOfTwo =
		  	new PokerHand(new PokerCard(CardValue.Jack, CardType.Spade),
			new PokerCard(CardValue.Two, CardType.Diamond),
			new PokerCard(CardValue.Two, CardType.Club),
			new PokerCard(CardValue.Five, CardType.Diamond),
			new PokerCard(CardValue.Ten, CardType.Heart));

   // Two pairs - 5 and Ace
	 PokerHand TwoPair_Ace_Five =
	    	new PokerHand(new PokerCard(CardValue.Jack, CardType.Spade),
			new PokerCard(CardValue.Five, CardType.Diamond),
			new PokerCard(CardValue.Ace, CardType.Club),
			new PokerCard(CardValue.Five, CardType.Heart),
			new PokerCard(CardValue.Ace, CardType.Spade));

   // three of a kind - 6s
	 PokerHand ThreeOfAKind_Six =
		   	new PokerHand(new PokerCard(CardValue.Six, CardType.Spade),
			new PokerCard(CardValue.Ace, CardType.Club),
			new PokerCard(CardValue.Six, CardType.Club),
			new PokerCard(CardValue.Six, CardType.Heart),
			new PokerCard(CardValue.Seven, CardType.Club));

	// three of a kind -10s
	 PokerHand ThreeOfAKind_Ten =
	    	new PokerHand(new PokerCard(CardValue.Ten, CardType.Spade),
			new PokerCard(CardValue.Ace, CardType.Club),
			new PokerCard(CardValue.Ten, CardType.Club),
			new PokerCard(CardValue.Ten, CardType.Heart),
			new PokerCard(CardValue.Three, CardType.Club));

	//Straight - starting at 8
	PokerHand Straight_From_Eight =
		   	new PokerHand(new PokerCard(CardValue.Ten, CardType.Club),
			new PokerCard(CardValue.Eight, CardType.Spade),
			new PokerCard(CardValue.Queen, CardType.Spade),
			new PokerCard(CardValue.Jack, CardType.Heart),
			new PokerCard(CardValue.Nine, CardType.Spade));


	//Straight - starting at three
	PokerHand Straight_From_Three =
		   	new PokerHand(new PokerCard(CardValue.Five, CardType.Club),
			new PokerCard(CardValue.Three, CardType.Spade),
			new PokerCard(CardValue.Six, CardType.Spade),
			new PokerCard(CardValue.Seven, CardType.Heart),
			new PokerCard(CardValue.Four, CardType.Spade));


	//Straight - considering Ace as lower bound
	PokerHand Straight_With_Low_Ace =
		   	new PokerHand(new PokerCard(CardValue.Five, CardType.Club),
			new PokerCard(CardValue.Three, CardType.Spade),
			new PokerCard(CardValue.Ace, CardType.Spade),
			new PokerCard(CardValue.Two, CardType.Heart),
			new PokerCard(CardValue.Four, CardType.Spade));


	//Straight - considering Ace as higher bound
	PokerHand Straight_With_High_Ace =
		   	new PokerHand(new PokerCard(CardValue.Ace, CardType.Club),
			new PokerCard(CardValue.Queen, CardType.Spade),
			new PokerCard(CardValue.Jack, CardType.Spade),
			new PokerCard(CardValue.King, CardType.Heart),
			new PokerCard(CardValue.Ten, CardType.Spade));

	 //Flush
	PokerHand Flush =
		    new PokerHand(new PokerCard(CardValue.Three, CardType.Spade),
			new PokerCard(CardValue.Nine, CardType.Spade),
			new PokerCard(CardValue.Queen, CardType.Spade),
			new PokerCard(CardValue.Four, CardType.Spade),
			new PokerCard(CardValue.King, CardType.Spade));


	//Full House Seven & King - triplet at begin
	PokerHand FullHouse_seven_king=
		  	new PokerHand(new PokerCard(CardValue.Seven, CardType.Club),
			new PokerCard(CardValue.Seven, CardType.Spade),
			new PokerCard(CardValue.King, CardType.Spade),
			new PokerCard(CardValue.Seven, CardType.Heart),
			new PokerCard(CardValue.King, CardType.Club));

	//Full House Seven & King - triplet at end
	PokerHand FullHouse_six_Queen=
		  	new PokerHand(new PokerCard(CardValue.Queen, CardType.Club),
			new PokerCard(CardValue.Queen, CardType.Spade),
			new PokerCard(CardValue.Six, CardType.Spade),
			new PokerCard(CardValue.Queen, CardType.Heart),
			new PokerCard(CardValue.Six, CardType.Club));

	// Four of a kind - 6s
	PokerHand FourOfAKind_Sixes =
		    new PokerHand(new PokerCard(CardValue.Six, CardType.Spade),
			new PokerCard(CardValue.Two, CardType.Club),
			new PokerCard(CardValue.Six, CardType.Club),
			new PokerCard(CardValue.Six, CardType.Heart),
			new PokerCard(CardValue.Six, CardType.Diamond));

	// Four of a kind -9s
	PokerHand FourOfAKind_Nines =
		    new PokerHand(new PokerCard(CardValue.Nine, CardType.Heart),
			new PokerCard(CardValue.Ace, CardType.Heart),
			new PokerCard(CardValue.Nine, CardType.Club),
			new PokerCard(CardValue.Nine, CardType.Heart),
			new PokerCard(CardValue.Nine, CardType.Diamond));

	 //straight Flush
	PokerHand StraightFlush =
		    new PokerHand(new PokerCard(CardValue.Three, CardType.Spade),
			new PokerCard(CardValue.Five, CardType.Spade),
			new PokerCard(CardValue.Six, CardType.Spade),
			new PokerCard(CardValue.Four, CardType.Spade),
			new PokerCard(CardValue.Two, CardType.Spade));

	 //staight Flush - low Ace
	PokerHand StraightFlush_withLowACe =
		   	new PokerHand(new PokerCard(CardValue.Three, CardType.Spade),
			new PokerCard(CardValue.Five, CardType.Spade),
			new PokerCard(CardValue.Ace, CardType.Spade),
			new PokerCard(CardValue.Four, CardType.Spade),
			new PokerCard(CardValue.Two, CardType.Spade));

	 //staight Flush - high ace
	PokerHand StraightFlush_HighAce=
		   	new PokerHand(new PokerCard(CardValue.Nine, CardType.Diamond),
			new PokerCard(CardValue.King, CardType.Diamond),
			new PokerCard(CardValue.Jack, CardType.Diamond),
			new PokerCard(CardValue.Queen, CardType.Diamond),
			new PokerCard(CardValue.Ten, CardType.Diamond));

	//RoyalFlush diamond
	PokerHand Royal_Flush_Diamond =
		    new PokerHand(new PokerCard(CardValue.Jack, CardType.Diamond),
			new PokerCard(CardValue.Queen, CardType.Diamond),
			new PokerCard(CardValue.Ace, CardType.Diamond),
			new PokerCard(CardValue.King, CardType.Diamond),
			new PokerCard(CardValue.Ten, CardType.Diamond));

	//RoyalFlush spade
	PokerHand RoyalFlush_Spade =
		    new PokerHand(new PokerCard(CardValue.Jack, CardType.Spade),
			new PokerCard(CardValue.King, CardType.Spade),
			new PokerCard(CardValue.Ten, CardType.Spade),
			new PokerCard(CardValue.Ace, CardType.Spade),
			new PokerCard(CardValue.Queen, CardType.Spade));

	/*
  	 * Test Hand Evaluation
  	 * Computes the hand and then compares with the desired result.
  	 */
  	@Test
  	public void testHandValue_HighCard() {
  		HighCard_King.computeValueOfHand();
  		assertEquals(PokerHandType.HighCard, HighCard_King.getHandType());
  	}

  	@Test
  	public void testHandValue_OnePair() {
  		PairOfSix.computeValueOfHand();
  		assertEquals(PokerHandType.OnePair, PairOfSix.getHandType());
  	}

  	@Test
  	public void testHandValue_TwoPair() {
  		TwoPair_Ace_Five.computeValueOfHand();
  		assertEquals(PokerHandType.TwoPair, TwoPair_Ace_Five.getHandType());
  	}

  	@Test
  	public void testHandValue_threeOfAKind() {
  		ThreeOfAKind_Ten.computeValueOfHand();
  		assertEquals(PokerHandType.ThreeOfAKind, ThreeOfAKind_Ten.getHandType());
  	}

  	@Test
  	public void testHandValue_Straight() {
  		Straight_From_Eight.computeValueOfHand();
  		assertEquals(PokerHandType.Straight, Straight_From_Eight.getHandType());
  	}

  	@Test
  	public void testHandValue_Flush() {
  		Flush.computeValueOfHand();
  		assertEquals(PokerHandType.Flush, Flush.getHandType());
  	}

  	@Test
  	public void testHandValue_FullHouse() {
  		FullHouse_seven_king.computeValueOfHand();
  		assertEquals(PokerHandType.FullHouse, FullHouse_seven_king.getHandType());
  	}

  	@Test
  	public void testHandValue_FourOfAKind() {
  		FourOfAKind_Nines.computeValueOfHand();
  		assertEquals(PokerHandType.FourOfAKind, FourOfAKind_Nines.getHandType());
  	}

  	@Test
  	public void testHandValue_StraightFlush() {
  		StraightFlush.computeValueOfHand();
  		assertEquals(PokerHandType.StraightFlush, StraightFlush.getHandType());
  	}

  	@Test
  	public void testHandValue_RoyalFlush() {
  		Royal_Flush_Diamond.computeValueOfHand();
  		assertEquals(PokerHandType.RoyalFlush, Royal_Flush_Diamond.getHandType());
  	}

  	/*
  	 * Test Game Winner - Compare 2 hands test cases
  	 * Calls the compare method in Poker.java with 2 hands. The two hands are evaluated, compared and then winner is determined.
  	 */
	@Test
	public void testTwoHighCard() {
		assertEquals(HighCard_King, poker.compare(HighCard_King	, HighCard_King2));
	}

	@Test
	public void testHighCardAndPair() {
		assertEquals(PairOfSix, poker.compare(HighCard_King	, PairOfSix));
	}

	@Test
	public void testTwoEqualPairs() {
		assertEquals(PairOfSix_2, poker.compare(PairOfSix	, PairOfSix_2));
	}

	@Test
	public void testPairVsTwoPair() {
		assertEquals(TwoPair_Ace_Five, poker.compare(PairOfSix	, TwoPair_Ace_Five));
	}

	@Test
	public void testThreeOfAKindVsStraight() {
		assertEquals(Straight_From_Eight, poker.compare(Straight_From_Eight, ThreeOfAKind_Ten));
	}

	@Test
	public void test_2_ThreeOfAKind() {
		ThreeOfAKind_Six.computeValueOfHand();
		assertEquals(ThreeOfAKind_Ten, poker.compare(ThreeOfAKind_Six, ThreeOfAKind_Ten));
	}

	@Test
	public void testFlushVsFullHouse() {
		assertEquals(FullHouse_seven_king, poker.compare(Flush, FullHouse_seven_king));
	}

	@Test
	public void test_2_FullHouse() {
		assertEquals(FullHouse_six_Queen, poker.compare(FullHouse_six_Queen, FullHouse_seven_king));
	}

	@Test
	public void testStraightWithAce() {
		assertEquals(Straight_With_High_Ace, poker.compare(Straight_With_High_Ace, Straight_With_Low_Ace));
	}

	@Test
	public void testFourOAKindVsStraightFlush() {
		assertEquals(FourOfAKind_Nines, poker.compare(Straight_From_Eight, FourOfAKind_Nines));
	}

	@Test
	public void test_2_FourOAKinds() {
		assertEquals(FourOfAKind_Nines, poker.compare(FourOfAKind_Sixes, FourOfAKind_Nines));
	}

	@Test
	public void test_2_Straight() {
		assertEquals(Straight_From_Eight, poker.compare(Straight_From_Eight, Straight_From_Three));
	}

	@Test
	public void test_2_StraightFlush_withAce() {
		assertEquals(StraightFlush_HighAce, poker.compare(StraightFlush_HighAce, StraightFlush_withLowACe));
	}

	@Test
	public void testRoyalFlushVsStraightFlush() {
		assertEquals(Royal_Flush_Diamond, poker.compare(Royal_Flush_Diamond, StraightFlush));
	}

	@Test
	public void testRoyalFlushVsRoyalFlush() {

		assertEquals(null, poker.compare(Royal_Flush_Diamond, RoyalFlush_Spade));
	}

}