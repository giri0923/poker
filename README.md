# Five Hand Poker Java Project

# Compiling instructions:
 1. Clone the project from https://github.com/giri0923/poker to local.
 2. Import the project in Eclipse . File -> Import -> General -> Existing projects into workspace.
 3. For JUnit , right click Project -> Build Path -> Configure Build Path -> Add Library -> Junit -> Junit 4 and click Finish.
 4. Run the src/test/PokerTest.java to run the test cases.

# Poker Hand Comparison Implementation Details
1. Junit test case file - src/test/PokerTest.java
   Creates hand objects of different combinations of cards.
   Test cases cover both single hand evaluation as well as two hand comparison (determine winner / draw)
 
2. Hand Evaluation Logic - src/pokerFiveHand/PokerHand.java
   Evaluates the hand for all possible poker hand types.

3. Hand Comparison logic - src/pokerFiveHand/Poker.java
   Compares the two evaluated hand arrays and determines the winner. 
   Possible results - Hand 1 win,Hand 2 win or draw

4. Poker card - src/pokerFiveHand/PokerCard.java

5. Enums:
   src/pokerFiveHand/CardType.java  - For different face types - Diamond,club,heart and spade
   src/pokerFiveHand/CardValue.java - For face values - 2 to 14 (Ace - 14 , King - 13, Queen - 12, Jack -11)
   src/pokerFiveHand/PokerHandType.java - For single hand evaluation test cases.

# Please note:
Considering the scope of the assessment, I assume that the hand will always be valid i.e an invalid hand is one with 5 7 value cards 

