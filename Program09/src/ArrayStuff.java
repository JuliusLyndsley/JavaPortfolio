public class ArrayStuff {
	public static void main(String [] args) 
	{
		final int SIZE = 36;
		int deck[] = new int[SIZE];
		System.out.println("\ndeck unshuffled: ");
		initDeck(deck);
		displayDeck(deck);
		shuffleDeck(deck, 1000);
		System.out.println("\nDeck Shuffled");
		System.out.print("-------------------\n");
		displayDeck(deck);

	}
	public static int cardValue(int card) 
	{
		return card % 9 + 1;
	}
	public static String cardSuit(int card) 
	{
		int tmp = card / 9;
		if (tmp == 0) {
			return " club";
		}
		else if (tmp == 1) {
			return " Spade";
		}
		else if (tmp == 2) {
			return " heart";
		}
		else {
			return " diamond";
		}
	}
	public static void displayCard(int card) 
	{
		System.out.print(cardValue(card) + (cardSuit(card)));

	}
	public static void initDeck(int[] deck) 
	{
		for (int i = 0; i < deck.length; ++i) 
		{
			deck[i] = i;
		}
	}
	public static void shuffleDeck(int[] deck, int n) 
	{
		for(int i = 1; i <= n; ++i) {
			int k = (int)(Math.random() * 36);
			int j = (int)(Math.random() * 36);
			int tmp= deck[k];
			deck[k] = deck[j];
			deck[j] = tmp;
		}	
	}
	public static void displayDeck(int[] deck) 
	{
		for (int i = 0; i < deck.length; ++i) 
		{
			displayCard(deck[i]);
			System.out.println();
		}
	}
}
