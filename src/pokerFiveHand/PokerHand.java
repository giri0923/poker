package pokerFiveHand;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author girish
 * Determine the type of the current poker hand e.g one of royalFlush,straight,flush etc.
 */
public class PokerHand{
	//Array of PokerCards to store the hand.
	private PokerCard[] hand = new PokerCard[5];
	private PokerHandType handType;
	//Array used in comparing the hands. Array is populated based on the type of poker hand.
	private int[] final_value = new int[hand.length + 1];
	private int pokerHandType = 0;	//Global variable that determines the final type of the poker hand
	private int firstPairIndex = 0; // When this is set, it means , we can skip these elements while checking for 2nd pair
	private int thirdIndex = 0;  //to store the starting index of the 3 pair if it exists. Used in checking for full house.
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
	 * Computes the value of the hand according to poker rules
	 * @return
	 */
	public int[] computeValueOfHand() {
		//Sort the hand in increasing order according to card value/face value.
		Arrays.sort(hand,new Comparator<PokerCard>() {
			@Override
			public int compare(PokerCard o1, PokerCard o2) {
				return o1.getCardValue().getValue() - o2.getCardValue().getValue();
			}
		});

		// Check if a single pair exist
		if(doesContainOnePair()) {
			pokerHandType = 1;
		}

		// Check if two pairs exist only when atleast a single pair is present
		if(pokerHandType == 1 && doesContainTwoPairs())
			pokerHandType = 2;

		// check for 3 of a kind in the hand.
		if(doesContainThreeOfKind())
			pokerHandType = 3;

		// Check for straight if none of the above cases exist i.e no one pair,
		// no 2 pair and no 3 of a kind as if any of these cases is true, we cannot have a straight
		if(pokerHandType == 0) {
			if(doesContainStraight())
				pokerHandType = 4;
		}

		// Check for full house only when he have a 3 pair in the hand. Pass the thirdIndex parameter to keep track of start index of triplet.
		if(pokerHandType == 3 && doesContainFullHouse(thirdIndex))
			pokerHandType = 6;

		//Check for Flush or StraightFlush only when you have a straight or if none of the above cases are true
		// as if we have a pair,2 pair or 3 of a kind, we cannot have flush . i.e there cannot be 2 clubs of 10 in the deck.
		if((pokerHandType == 0 || pokerHandType == 4)) {
			pokerHandType = doesContainFlushOrStraightFlush(pokerHandType);
		}

		//Check for four of kind in the hand.
		if(doesContainFourOfKind())
			pokerHandType = 7;

		// RoyalFlush is only possible if the hand is a StraightFlush
		if(pokerHandType == 8 && doesContainRoyalFlush())
			pokerHandType = 9;

		// If pokerHandType is still 0 , it means its highcard
		if(pokerHandType == 0)
			doesContainHighCard();

		final_value[0] = pokerHandType;// Store the type of pokerHand in first index of the array .Used for evaluation.
		this.handType = PokerHandType.getPokerHandType(final_value[0]);// Retrieves the hand type name from enum. for e.g if input is 5 , returns Flush
		return final_value;
	}

	/**
	 * Helper function to evaluate the hand to check if one pair exist
	 * For single pair, we need to store the value of the pair first and then the remaining 3 cards in decreasing order of values
	 *
	 * @return
	 */
	public boolean doesContainOnePair() {

		int k = 1;
		for (int i=0; i<hand.length-1;i++) {
			// Check 2 consecutive cards for same value
			if (hand[i].getCardValue().getValue() == hand[i+1].getCardValue().getValue()) {
				firstPairIndex = i; // if found store the index of start of pair. used to skip the elements while checking for 2nd pair
				final_value[k++] = hand[i].getCardValue().getValue(); // Put the pair's value in 1st position of array
				break;
			}
		}
		if (k > 1) // if pair found
		for (int i=hand.length-1; i>=0; i--) {
			// Iterate in decreasing order and populate the rest of the final_value indices with the next high card after the pair.
			if (hand[i].getCardValue().getValue() != final_value[1])   // skip the pair value
				final_value[k++] = hand[i].getCardValue().getValue();
		}

		return k>1; // returns true if it has one pair at least else false.
	}

	/**
	 * Helper function to evaluate the hand for 2 pairs
	 * For 2 pairs, we need to store the higher pair value first , the lower pair value and the remaining card
	 * @return
	 */
	public boolean doesContainTwoPairs() {
		int k = 2;
		for(int i = firstPairIndex+2; i<hand.length - 1; i++) { // skip the first pair
			//check for consecutive values of card
			if(hand[i].getCardValue().getValue()==hand[i+1].getCardValue().getValue()) {
				// If second pair is found, we should compare it with the first hand's value and swap the values if needed.
				//i.e first pair may have the lower card value than the 2nd pair.
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

		// save high rank card for two pair
		if (k > 2)
		for (int i=hand.length-1; i>=0; i--) {
			int current = hand[i].getCardValue().getValue() ;
			if (current != final_value[1] && current != final_value[2]) { // skip both first pair and 2nd pair
				final_value[k++] = current; // store the remaining card value alone in the array
				break;
			}
		}
		return k>2; // returns true if it has two pair
	}

	/**
	 * Helper functions to evaluate the hand
	 * For three of a kind, we store the value of the triplet and the remaining 2 cards in decreasing order of high card value
	 * @return
	 */
	public boolean doesContainThreeOfKind() {
		int k = 1;
		for(int i=0;i<hand.length-2;i++) {// only possibilities are 0 1 and 2
			// Check equality for 3 indices
			if ((hand[i].getCardValue().getValue()==hand[i+1].getCardValue().getValue()) &&(hand[i+1].getCardValue().getValue()==hand[i+2].getCardValue().getValue())) {
				thirdIndex = i; // store the index for full house evaluation
				final_value[k++] = hand[i].getCardValue().getValue(); // store the triplet card value
				break;
			}
		}

		// Three of a kind found
		if (k>1)
			for (int i=hand.length-1; i>=0; i--) {
				int current = hand[i].getCardValue().getValue();
				if (current != final_value[1])  { // skip 3 card value and store high card
					final_value[k++] = current;
					break;
				}
			}
		return k>1; // returns true if it has tree of a pair; if not return false;
	}

	/**
	 * Helper function to evaluate the hand for full house
	 * For full house , we check if the hand has a 3 of a kind. Then we store the value of triplet first and then the value of the single pair.
	 * @param third
	 * @return
	 */
	public boolean doesContainFullHouse(int third) {
			/*
			If a triplet and pair exist, triplet can exist only in the beginning or end
			e.g 2 2 2 5 5 or 2 2 5 5 5 (since hand is sorted)
			If triplet index stored in third of kind method is 0, just check if cards at last 2 positions in hand are a pair
			If triplet index stored in third of kind method is 2, just check if cards at first 2 positions in hand are a pair
			*/
			// 2 2 2 7 10
			int i=third;
			if((i==0&&(hand[hand.length-1].getCardValue().getValue()==hand[hand.length-2].getCardValue().getValue()))||
					(i==2 && (hand[0].getCardValue().getValue()==hand[1].getCardValue().getValue())))
			{
				if(i==0) // triplet at beginning
					final_value[2] = hand[hand.length-1].getCardValue().getValue();
				else
					final_value[2] = hand[0].getCardValue().getValue();

				return true;
			}
		return false;
	}

	/**
	 *  Helper function to evaluate the hand for straight
	 *  For straight, we just need to store the highest value of straight. Changes if ace is present in the hand.
	 * @return
	 */
	public boolean doesContainStraight() {
		/*
		 * Cases:
		 * Case 1 : If the cards are in increasing sequence without A - we need to check if the difference in value of first and last card is 4
		 * Case 2: If the cards are in increasing sequence with A considering A as highest value - we need to check if the difference in value of first and last card is 4
		 * Case 3: If cards in hand contain A with A to be lowest for e.g A 2 3 4 5 then in sorted hand it will be 2 3 4 5 A
		 * So just check for difference in cards at position 0 and 3 = 3 and if we have A at the end and if we have 2 at the beginning.
		 */
		if((hand[hand.length-1].getCardValue().getValue() - hand[0].getCardValue().getValue() == 4) ||
				(hand[hand.length-2].getCardValue().getValue()-hand[0].getCardValue().getValue() ==3 &&
				hand[hand.length-1].getCardValue().getValue() == 14 &&hand[0].getCardValue().getValue()==2)) {
			if(hand[hand.length-1].getCardValue().getValue() == 14) {
				//if it is a straight check if A should be treated as highest or lowest. If highest, put 14 else put 5 as the highest card in straight.
				if(hand[0].getCardValue().getValue()==2)
					final_value[1] = 5;
				else
					final_value[1] = 14;
			}
			// Straight not present - Just put the highest card in hand.
			else
				final_value[1] = hand[hand.length-1].getCardValue().getValue();
			return true;
		}

		return false;
	}


	/**
	 * Helper function to evaluate the hand for straightFlush or flush
	 * If it is a flush, store all the values in decreasing order of value.
	 * If it is straight flush, store the highest value of straight - extra condition for Ace present in the hand.
	 * @param currentPokerHandType
	 * @return
	 */
	public int doesContainFlushOrStraightFlush(int currentPokerHandType) {
		int isFlush  = 1;
	    for(int i = 0; i < hand.length-1; i++) {
	    	if(hand[i].getCardType().getType() != hand[i+1].getCardType().getType()) // check for flush and set the boolean
		    isFlush = 0; //not a flush
	    }
	    if((isFlush==1) && currentPokerHandType == 4) { // straight flush
	    	if(hand[hand.length-1].getCardValue().getValue() == 14)  // For ace
			{
				if(hand[0].getCardValue().getValue()==2) // considering ace as lower value
					final_value[1] = 5;
				else  //considering ace as higher value.
					final_value[1] = 14;
			}
	    	else
	    		final_value[1] = hand[hand.length-1].getCardValue().getValue(); //if no ace, just store the highest value of straight.
	    	return 8;
	    }
	    else if (isFlush==1) { // just a flush
	    	int k = 1;
	    	for (int i=hand.length-1; i>=0; i--) { // store all values in decreasing order
			final_value[k++] = hand[i].getCardValue().getValue();;
	    	}
	    	return 5;
	    }
		return currentPokerHandType;
	}

	/**
	 * Helper function to evaluate the hand for four of a kind
	 * possible i values - 0 and 1
	 * For four of kind, store the quadruplet value and the other high card alone.
	 * @return
	 */
	public boolean doesContainFourOfKind() {
		int k = 1;
		for(int i=0;i<2;i++) {
			// Checks 4 consecutive indices
			if((hand[i].getCardValue().getValue() == hand[i+1].getCardValue().getValue()) && (hand[i+1].getCardValue().getValue() == hand[i+2].getCardValue().getValue())
					&& (hand[i+2].getCardValue().getValue() == hand[i+3].getCardValue().getValue())) {
				final_value[k++] = hand[i].getCardValue().getValue(); //store quadruplet value
				if (i==0) {
					//if quadruplet starts at begin
					final_value[k++] = hand[hand.length-1].getCardValue().getValue();
				}
				else {
					//if quadruplet is at end
					final_value[k++] = hand[0].getCardValue().getValue();
				}
 				return true;
			}
		}

		return false;
	}

	/**
	 * Helper function to evaluate the hand for Royal flush
	 * No need to save anything as if 2 hands have royal flush, it just leads to draw and no comparisons.
	 * @return
	 */
	public boolean doesContainRoyalFlush() {
		// check if final card is Ace and starting card is 10 - Face type doesn't matter.
		if(hand[hand.length-1].getCardValue().getValue() == 14 && hand[0].getCardValue().getValue() == 10)
			return true;

		return false;
	}

	/**
	 * Helper function to evaluate the hand for Royal flushhigh card
	 * Store all the cards in decreasing order of value.
	 */
	public void doesContainHighCard() {
		int k = 1;
		for (int i=hand.length-1; i>=0; i--) {
			// Iterate in decreasing order and populate the rest of the final_value indices with the next high card after the pair.
			final_value[k++] = hand[i].getCardValue().getValue();
		}

	}

}
