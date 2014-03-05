package upgrade;

import java.util.ArrayList;
import java.util.List;
public class Player {
	public boolean[][] cards;
	public boolean[][] pairs;
	public int[] numbers;
	public Player() {
		cards = new boolean[5][17];
		pairs = new boolean[5][17];
		numbers = new int[5];
	}
	
	public int receive(Card card, int priority) {
		if (!cards[card.color - 1][card.n - 1] ) {
			cards[card.color - 1][card.n - 1] = true;
		} else {
			pairs[card.color - 1][card.n - 1] = true;
		}
		numbers[card.color - 1]++;
		
		return priority;
	}
	
	public void display() {
		for (int i = 0; i < 5; i++) {
			if (numbers[i] > 0) {
				System.out.print(Card.suite.get(i+1) + ": ");
				for (int j = 0; j < 17; j++) {
					if (cards[i][j]) {
						if (pairs[i][j]) System.out.print(Card.toString(j+1));
					    System.out.print(Card.toString(j+1) + " ");			    
					}
				}
				System.out.println();
			}
		}
	}
	
	public void rearrange(int hardc) {
		
	}
}
