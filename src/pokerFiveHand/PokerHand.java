package pokerFiveHand;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author girish
 * Type for Poker Hand
 */

public class PokerHand{
	private PokerCard[] hand = new PokerCard[5];
	private PokerHandType handType;
	private int[] final_value = new int[hand.length + 1];
	private int pokerHandType = 0;
	private int firstPairIndex = 0;
	private int thirdIndex = 0;
	public PokerHand(PokerCard[] hand) {
		this.hand = hand;
	}

	/**
	 * @param pokerCard1
	 * @param pokerCard2
	 * @param pokerCard3
	 * @param pokerCard4
	 * @param pokerCard5
	 */
	public PokerHand(PokerCard pokerCard1, PokerCard pokerCard2, PokerCard pokerCard3, PokerCard pokerCard4,
			PokerCard pokerCard5) {
		hand[0]=pokerCard1;
		hand[1]=pokerCard2;
		hand[2]=pokerCard3;
		hand[3]=pokerCard4;
		hand[4]=pokerCard5;
	}

	/**
	 * @return
	 */
	public PokerCard[] getHand() {
		return this.hand;
	}

	/**
	 * @return the handType
	 */
	public PokerHandType getHandType() {
		return handType;
	}

	/**
	 * Computes the value of the hand
	 * @return
	 */
	public int[] getValueOfHand() {
		Arrays.sort(hand,new Comparator<PokerCard>() {
			@Override
			public int compare(PokerCard o1, PokerCard o2) {
				return o1.getCardValue().getValue() - o2.getCardValue().getValue();
			}
		});

		if(doesContainOnePair()) {
			pokerHandType = 1;
		}

		if(pokerHandType == 1 && doesContainTwoPairs())
			pokerHandType = 2;

		if(doesContainThreeOfKind())
			pokerHandType = 3;

		if(pokerHandType == 0) {
			if(doesContainStraight())
				pokerHandType = 4;
		}

		if(pokerHandType == 3 && doesContainFullHouse(thirdIndex))
			pokerHandType = 6;

		if((pokerHandType == 0 || pokerHandType == 4)) {
			System.out.println("bef"+pokerHandType);
			pokerHandType = doesContainFlushOrStraightFlush(pokerHandType);
			System.out.println(pokerHandType);
		}

		if(doesContainFourOfKind())
			pokerHandType = 7;

		if(pokerHandType == 8 && doesContainRoyalFlush())
			pokerHandType = 9;

		final_value[0] = pokerHandType;

		for (int i=0; i<final_value.length; i++) {
			System.out.println(" result "+ final_value[i]);
		}

		return final_value;
	}

	/**
	 * Helper functions to evaluate the hand
	 * @return
	 */
	public boolean doesContainOnePair() {
		int k = 1;
		for (int i=0; i<hand.length-1;i++) {
			if (hand[i].getCardValue().getValue() == hand[i+1].getCardValue().getValue()) {
				firstPairIndex = i;
				final_value[k++] = hand[i].getCardValue().getValue();
				break;
			}
		}
		if (k > 1)
		for (int i=hand.length-1; i>=0; i--) {
			if (hand[i].getCardValue().getValue() != final_value[1])
				final_value[k++] = hand[i].getCardValue().getValue();
		}

		return k>1; // returns true if it has one pair
	}

	/**
	 * Helper functions to evaluate the hand
	 * @return
	 */
	public boolean doesContainTwoPairs() {
		int k = 2;
		for(int i = firstPairIndex+2; i<hand.length - 1; i++) {
			if(hand[i].getCardValue().getValue()==hand[i+1].getCardValue().getValue()) {
				if(hand[i].getCardValue().getValue() < final_value[1])
					final_value[k++] = hand[i].getCardValue().getValue();
				else {
					final_value[2] = final_value[1];
					final_value[1] = hand[i].getCardValue().getValue();
					k++;
				}
				break;
			}
		}

		// save high rank cards for two pair
		if (k > 2)
		for (int i=hand.length-1; i>=0; i--) {
			int current = hand[i].getCardValue().getValue() ;
			if (current != final_value[1] && current != final_value[2]) {
				final_value[k++] = current;
				break;
			}
		}

		return k>2; // returns true if it has two pair
	}

	/**
	 * Helper functions to evaluate the hand
	 * @return
	 */
	public boolean doesContainThreeOfKind() {
		int k = 1;
		for(int i=0;i<hand.length-2;i++) {
			if ((hand[i].getCardValue().getValue()==hand[i+1].getCardValue().getValue()) &&(hand[i+1].getCardValue().getValue()==hand[i+2].getCardValue().getValue())) {
				thirdIndex = i;
				final_value[k++] = hand[i].getCardValue().getValue();
				break;
			}
		}

		if (k>1)
			for (int i=hand.length-1; i>=0; i--) {
				int current = hand[i].getCardValue().getValue();
				if (current != final_value[1])  {
					final_value[k++] = current;
					break;
				}
			}

		return k>1; // returns true if it has tree of a pair; if not return false;
	}


	/**
	 * Helper functions to evaluate the hand
	 * @param third
	 * @return
	 */
	public boolean doesContainFullHouse(int third) {
		for(int i=third;i<hand.length-2;i++)
		{
			if((i==0&&(hand[hand.length-1].getCardValue().getValue()==hand[hand.length-2].getCardValue().getValue()))||
					(i==2 && (hand[0].getCardValue().getValue()==hand[1].getCardValue().getValue())))
			{
				if(i==0)
					final_value[2] = hand[hand.length-1].getCardValue().getValue();
				else
					final_value[2] = hand[0].getCardValue().getValue();

				return true;
			}
		}

		return false;
	}

	/**
	 * @return
	 */
	public boolean doesContainStraight() {
		if((hand[hand.length-1].getCardValue().getValue() - hand[0].getCardValue().getValue() == 4) ||
				(hand[hand.length-2].getCardValue().getValue()-hand[0].getCardValue().getValue() ==3 &&
				hand[hand.length-1].getCardValue().getValue() == 14 &&hand[0].getCardValue().getValue()==2)) {
			if(hand[hand.length-1].getCardValue().getValue() == 14) {
				if(hand[0].getCardValue().getValue()==2)
					final_value[1] = 5;
				else
					final_value[1] = 14;
			}
			else
				final_value[1] = hand[hand.length-1].getCardValue().getValue();
			return true;
		}

		return false;
	}


	/**
	 * @param currentPokerHandType
	 * @return
	 */
	public int doesContainFlushOrStraightFlush(int currentPokerHandType) {
		boolean isFlush  = true;
	    for(int i = 0; i < hand.length-1; i++) {
	    	if(hand[i].getCardType().getType() != hand[i+1].getCardType().getType())
		    isFlush = false;
	    }
	    if(isFlush && currentPokerHandType == 4) {
	    	if(hand[hand.length-1].getCardValue().getValue() == 14)
			{
				if(hand[0].getCardValue().getValue()==2)
					final_value[1] = 5;
				else
					final_value[1] = 14;
			}
	    	else
	    		final_value[1] = hand[hand.length-1].getCardValue().getValue();
	    	return 8;
	    }
	    else if (isFlush) { // just a flush
	    	int k = 1;
	    	for (int i=hand.length-1; i>=0; i--) {
			final_value[k++] = hand[i].getCardValue().getValue();;
	    	}
	    	return 5;
	    }

		return currentPokerHandType;
	}

	/**
	 * @return
	 */
	public boolean doesContainFourOfKind() {
		int k = 1;
		for(int i=0;i<2;i++) {
			if((hand[i].getCardValue().getValue() == hand[i+1].getCardValue().getValue()) && (hand[i+1].getCardValue().getValue() == hand[i+2].getCardValue().getValue())
					&& (hand[i+2].getCardValue().getValue() == hand[i+3].getCardValue().getValue())) {
				final_value[k++] = hand[i].getCardValue().getValue();
				if (i==0) {
					final_value[k++] = hand[hand.length-1].getCardValue().getValue();
				}
				else {
					final_value[k++] = hand[0].getCardValue().getValue();
				}
 				return true;
			}
		}

		return false;
	}

	/**
	 * @return
	 */
	public boolean doesContainRoyalFlush() {
		if(hand[hand.length-1].getCardValue().getValue() == 14 && hand[0].getCardValue().getValue() == 10)
			return true;

		return false;
	}

}
