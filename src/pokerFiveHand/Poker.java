package pokerFiveHand;

/**
 * @author girish
 *
 */
public class Poker {

	/**
	 * Method to compare two poker hands
	 * Logic:
	 * 1. Compute the value of hand1 and store the evaluated_hand_array1
	 * 2. Compute the value of hand2 and return the evaluated_hand_array2
	 * 3. Iterate the hands and start comparing from first index of the evaluated_hand_array1 and evaluated_hand_array2
	 * 4. Keep iterating if both the values are equal (Might lead to a draw).In this case return null.
	 * 5. If one of the values in the index is higher than the other, then return the higher valued hand as the winner hand.
	 * @param hand1
	 * @param hand2
	 * @return
	 */
	public PokerHand compare(PokerHand hand1, PokerHand hand2) {
		int[] hand1_finalVal = hand1.computeValueOfHand();
		int[] hand2_finalVal = hand2.computeValueOfHand();

		for(int i=0;i<hand1_finalVal.length;i++) {
			if(hand1_finalVal[i]>hand2_finalVal[i])
				return hand1;
			if(hand1_finalVal[i]<hand2_finalVal[i])
				return hand2;
		}
		return null;
	}


}
