package pokerFiveHand;

/**
 * @author girish
 *
 */
public class Poker {

	/**
	 * Method to compare two poker hands
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
