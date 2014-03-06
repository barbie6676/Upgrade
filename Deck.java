package upgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> cards;
	private boolean validDeck;
	
	public static final int N_DECKS = 2;
	public static final int N_ONEDECK = 13;
	public static final int N_COLORS = 4;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for (int k = 0 ; k < N_DECKS; k++){
			for (int i = 0; i < N_ONEDECK; i++){
				for (int j = 0; j < N_COLORS; j++){
					cards.add(new Card(i + 2, j));
				}
			}
			cards.add(new Card(17, N_COLORS));
			cards.add(new Card(18, N_COLORS));
		}
		validDeck = true;
	}
	
	public Deck(List<Card> cards) {
		this.cards = cards;
		validDeck = isValid();
	}
	
	public boolean isValid() {			
		return cards.size() == 108;
	}
	
	public void shuffle() {
		
		long seed = new Random().nextLong();
		Random rand = new Random(seed);
		for (int i = 106; i >= 1; i--) {
			int idx = rand.nextInt(i);
			Card temp = cards.get(idx);
			cards.set(idx,cards.get(i+1));
			cards.set(i+1, temp);
		}
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void display() {
		if (isValid()) {
			for (Card card: cards) {
				System.out.println(card.toString());
			}
		}
	}
	
}