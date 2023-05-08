import java.util.Scanner;
public class RoulletteSpin {
	public static void main(String [] args)
	{
		int chipsNow = 100;
		Scanner stdIn= new Scanner(System.in);
		int choice;
		welcome();
		do {
		 choice = getMenuChoice(stdIn);
		if (choice == 1) 
		{
			int numChoice = getNumber(stdIn);
			int betChoice = getBet(stdIn, chipsNow);
			System.out.println("\nSpinning the wheel...");
			int spinner = (int)(Math.random()*37);
			System.out.println("spin number: " + spinner);
			String spinColor = determineColor(spinner);
			System.out.println("spin color: " + spinColor);
			if(numChoice == spinner) {
				int winnings = (betChoice*36);
				System.out.println("you won " + winnings + " chips!!");
				chipsNow = winnings + chipsNow; 
				System.out.println("you now have " + betChoice + " chips\n");
			}
			else 
			{
				System.out.println("you lost " + betChoice + " chips!!");
				chipsNow = chipsNow - betChoice;
				System.out.println("you now have " + chipsNow + " chips\n");
			}
		}
		else if (choice == 2) 
		{
			String colChoice = getColor( stdIn);
			int betChoice = getBet(stdIn, chipsNow);
			System.out.println("\nSpinning the wheel...");
			int spinner = (int)(Math.random()*37);
			System.out.println("spin number: " + spinner);
			String spinColor = determineColor(spinner);
			System.out.println("spin color: " + spinColor);
			if(colChoice.equals(spinColor)) {
				int winnings = (betChoice*2);
				System.out.println("you won " + winnings + " chips!!");
				chipsNow = winnings + chipsNow; 
				System.out.println("you now have " + chipsNow + " chips\n");
			}
			else
			{
				System.out.println("you lost " + betChoice + " chips!!");
				chipsNow = chipsNow - betChoice;
				System.out.println("you now have " + chipsNow + " chips\n");
			}
		}
		else if (choice == 3)
			report(chipsNow); 
		}while (choice !=3); 
		stdIn.close();
	}
	public static void welcome() 
	{
		System.out.println("-------------------------");
		System.out.println("  Welcome To Roulette! ");
		System.out.println("-------------------------");
		System.out.println("Number bets payout: 35:1");
		System.out.println("Color bets payout: 1:1");
		System.out.println("-------------------------");
		System.out.println("You have 100 chips\n");
		System.out.println("Good luck!");
		System.out.println("-------------------------\n");
		return;
	}
	public static int getMenuChoice(Scanner stdIn) 
	{
		System.out.println("1. Pick a number to bet on");
		System.out.println("2. Pick a color to bet on");
		System.out.println("3. Cash out\n");
		System.out.print("Enter a choice: ");
		int play = stdIn.nextInt();
		while (play < 1 || play > 3)
		{
			System.out.print("Bad input - please try again: ");
			play = stdIn.nextInt();
		}
		return play;
	}
	public static int getNumber(Scanner stdIn) 
	{
		System.out.print("Enter a number to bet on [1-36]: ");
		int num = stdIn.nextInt();
		while (num < 0 || num > 36)
		{
			System.out.print("Bad input - please try again: ");
			num = stdIn.nextInt();
		}
		return num;
	}
	public static String getColor(Scanner stdIn)
	{
		System.out.print("Please choose a color to bet on [red or black]: ");
		String color = stdIn.nextLine();
		while (!(color.equals("red") || color.equals("black"))) {
			color = stdIn.nextLine();
		}
		return color;
	}
	public static int getBet(Scanner stdIn, int chipsNow) 
	{
		System.out.print("Please enter the number of chips you would like to bet: ");
		int bet = stdIn.nextInt();
		while (bet < 1 || bet > chipsNow)
		{
			System.out.print("Bad input - please try again: ");
			bet = stdIn.nextInt();
		}
		return bet;
	}
	public static String determineColor(int spinNum)
	{
		if( spinNum == 0) {
			return "green";
		}
		else if (spinNum %2==0) {
			return "red";
		}
		else {
			return "black";
		}
	}
	public static void report(int chipsNow) 
	{
		int amount;
		if (chipsNow >= 100) 
		{
			amount = (chipsNow - 100);
			System.out.print("Congratulations! You won a total of " + amount + " chips!");
		}
		else if(chipsNow <= 100) 
		{
			amount = (100 - chipsNow);
			System.out.print("Bummer! You lost a total of " + amount + " chips!");
		}
	}
}
