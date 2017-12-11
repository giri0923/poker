# Poker Hand Comparison Implementation
1. Junit test case file - src/test/PokerTest.java
 Creates hand objects of different combinations of cards.
 Test cases cover both single hand evaluation as well as two hand comparison (determine winner / draw)
 
2. Hand Evaluation Logic - src/pokerFiveHand/PokerHand.java
Evaluates the hand for all possible poker hand types.

3. Hand Comparison logic - src/pokerFiveHand/Poker.java
Compares the two evaluated hand arrays and determines the winner. 
Possible results - Hand 1 win,Hand 2 win or draw

4.Poker card - src/pokerFiveHand/PokerCard.java

5.Enums:
src/pokerFiveHand/CardType.java  - For different face types - Diamond,club,heart and spade
src/pokerFiveHand/CardValue.java - For face values - 2 to 14 (Ace - 14 , King - 13, Queen - 12, Jack -11)
src/pokerFiveHand/PokerHandType.java - For single hand evaluation test cases.

 
