package org.leetcode.problems;

/*In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.



Example 1:

Input: [17,13,11,2,3,5,7]   [17,13,11,10,12,2,3,5,7,6]
        [2,3,5,7,11,13,17]  [2,3,5,6,7,10,11,12,13,17]
Output: [2,13,3,11,5,17,7]  [2,10,3,17,5,11,6,13,7,12]
        [2,,,,,,]                   [2,,3,,5,,6,,7,]
        [2,,3,,,,]
        [2,,3,,5,,]                   [2,10,3,,5,,6,,7,]
        [2,,3,,5,,7]                   [2,10,3,,5,11,6,,7,]
        [2,,3,11,5,,7]                   [2,10,3,,5,11,6,,7,12]
        [2,13,3,11,5,,7]                   [2,10,3,,5,11,6,13,7,12]
        [2,13,3,11,5,17,7]                   [2,10,3,17,5,11,6,13,7,12]

Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.


Note:

1 <= A.length <= 1000
1 <= A[i] <= 10^6
A[i] != A[j] for all i != j
*/

import java.util.Arrays;

public class RevealCardsInIncreasingOrder {


    public static void main(String[] args) {
        for (int i: deckRevealedIncreasing(new int[]{17,13,11,10,12,2,3,5,7,6})) {
            System.out.println(i);
        }
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] output = new int[deck.length];

        Arrays.sort(deck);
        output[0] = deck[0];
        int j = 1;

        for (int i = 1; i < deck.length; i++) {

            int count = 0;

            while (count != 2) {
                if(output[j] == 0) {
                    if(count == 1) {
                        output[j] = deck[i];
                        count = 2;
                    } else {
                        count ++;
                    }
                }

                j++;

                if(j == output.length) {
                    j = 1;
                }
            }
        }

        return output;
    }
}
