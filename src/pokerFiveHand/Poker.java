package pokerFiveHand;

public class Poker {
	
	
	public int compare(PokerHand hand1, PokerHand hand2) {
		int[] hand1_finalVal = hand1.getValueOfHand();
		int[] hand2_finalVal = hand2.getValueOfHand();
		for(int i=0;i<hand1_finalVal.length;i++)
		{
			if(hand1_finalVal[i]>hand2_finalVal[i])
				return 1;
			if(hand1_finalVal[i]<hand2_finalVal[i])
				return 2;
		}
		return 0;
		}
	

}
