package upgrade;

import java.util.HashMap;
import java.util.Map;

public class Card {
	// n 1-17
	// 1-12 = 2-k 13 a 14 little trump 15 big trump 16 joker 17 JOKER
	public int n;
	
	public boolean isTrump; 
	// color 1-5, spade heart club diamond and trump
	public int color; 
	public static final Map<Integer, String> suite 
		                                = new HashMap<Integer, String>() {{
        put(1, "Spade");
        put(2, "Heart");
        put(3, "Club");
        put(4, "Diamond");
        put(5, "Trump");
    }};;
    public static final Map<Integer, String> rank 
                                        = new HashMap<Integer, String>() {{
        put(10, "Jack");
        put(11, "Queen");
        put(12, "King");
        put(13, "Ace");
     }};;
	
	public Card(){}
		
	public Card(int n, int color){
		this.n = n;
		this.color = color;
		isTrump = false;
	}
	
	public boolean isTrump(){
		return color == 5;
	}
		
	public void setTrump(int hardn, int hardc){
		if (color == hardc && n == hardn) {
			color = 5;
			n = 15;
		} else if (n == hardn) {
			color = 5;
			n = 14;
		} else if (color == hardc){
			color = 5;
		}
		
	}
	
	public String toString() {
		String str = "";
		if (n == 16) {
			str = "joker";
		} else if (n == 17) {
			str = "JOKE";
		} else {
			String specialRank = (n + 1) + "";
			if (n >= 10) specialRank = rank.get(n);
			str = suite.get(color) + " " + specialRank; 
		}
		return str;
	}
	
	public static String toString(int n) {
		String str = "";
		if (n == 16) {
			str = "joker";
		} else if (n == 17) {
			str = "JOKE";
		} else {
			str = (n + 1) + "";
			if (n >= 10) str = rank.get(n);
		}
		return str;
	}
	public int compareTo(Card another) {
		if (this.color!=5 && another.color == 5) {
			return -1;
		} else if (this.color==5 && another.color !=5){
			return 1;
		} else {
			return new Integer(n).compareTo(new Integer(another.n));
		}		
	}
	
}
