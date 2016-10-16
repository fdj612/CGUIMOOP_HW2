import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID: B0444249
 * Name: 張德芳
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// check your output, make sure that you print all cards on your screen
		deck.printDeck(nDeck);

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/*
 * Description: 定義每張牌的花色及大小，並印出每張牌
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// 1.implement the printCard method
	public void printCard() {

		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
		System.out.println("(" + getSuit() + "," + getRank() + ")");
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}

/*
 * Description: 將n副排放入ArrayList中，然後印出ArrayList每一張牌的花色大小
 */
class Deck {
	private ArrayList<Card> cards; // 宣告變數cards-->型態:Card型態的ArrayList

	// implement the constructor
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();

		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		for (int i = 0; i < nDeck; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 13; k++) {

					card(j, k);
				}

			}

		}

	}

	private Object card(int j, int k) {

		// Auto-generated method stub
		Card cardAdd = new Card(j, k);
		cards.add(cardAdd);
		return null;
	}

	// implement the method to print all cards on screen
	public void printDeck(int nDeck) {
		Card card = new Card(0, 0);
		// Hint: print all items in ArrayList<Card> cards,
		// please implement and reuse printCard method in Card class
		for (Card c : cards) {
			c.printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}
