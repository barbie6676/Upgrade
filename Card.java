package upgrade;

import java.util.HashMap;
import java.util.Map;

public class Card {
	// n 2-18
	// 2-14 = 2-a 15: little trump 16: big trump 17: joker 18: JOKER
	public int n;
	
	public boolean isTrump; 
	// color 0-4, spade heart club diamond and trump
	public int color; 
	public static final Map<Integer, String> suite 
		                                = new HashMap<Integer, String>() {{
        put(0, "Spade");
        put(1, "Heart");
        put(2, "Club");
        put(3, "Diamond");
        put(4, "Trump");
    }};;
    public static final Map<Integer, String> rank 
                                        = new HashMap<Integer, String>() {{
        put(11, "Jack");
        put(12, "Queen");
        put(13, "King");
        put(14, "Ace");
        put(15, "minor");
        put(16, "MAJOR");
        put(17, "joker");
        put(18, "JOKER");
     }};;
	
	public Card(){}
		
	public Card(int n, int color){
		this.n = n;
		this.color = color;
		isTrump = false;
	}
	
	public boolean isTrump(){
		return color == 4;
	}
		
	public void setTrump(int rank, int hardc){
		if (color == hardc && n == rank) {
			color = 4;
			n = 16;
		} else if (n == rank) {
			color = 4;
			n = 15;
		} else if (color == hardc){
			color = 4;
		}
		
	}
	
	public String toString() {
		String str = "";
		if (n > 10) {
			str = rank.get(n);
		} else {
			str = n + "";
		}
		
		if (n < 15) {
			str = suite.get(color) + "-" + str;
		}
		return str;
	}
	
	public int compareTo(Card another) {
		if (this.color != 4 && another.color == 4) {
			return -1;
		} else if (this.color == 4 && another.color != 4){
			return 1;
		} else {
			return new Integer(n).compareTo(new Integer(another.n));
		}		
	}
	
}
