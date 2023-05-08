import java.util.Scanner;
public class DiceGame 
{
	public static void main (String[] args) 
	{
		int d1;
		int d2;
		int d3;
		int d4;
		int wins = 0;
		int losses = 0;
		String play;
		String pa;
		boolean done = false;
		System.out.println("Welcome to Computer Dice!");
		System.out.println("--------------------------");
		System.out.println("you will first roll your dice\n");
		System.out.println("Next the outcome of your roll will be determined:\n");
		System.out.println("Any Quad and you Win");
		System.out.println("Any Triple and you Win");
		System.out.println("Any TwoPair and you Win");
		System.out.println("Anything else and you lose");
		System.out.println("----------------------------");
		Scanner stdin= new Scanner(System.in);
		System.out.print("Would you like to play? [y,n]: ");
		play = stdin.next();
		do 
		{
			if (play.equals("n")) 
			{
				break;
			}
			d1 = (int)(Math.random() * 4) + 1;
			d2 = (int)(Math.random() * 4) + 1;
			d3 = (int)(Math.random() * 4) + 1;
			d4 = (int)(Math.random() * 4) + 1;
			System.out.println("  Player ");
			System.out.println("----------");
			System.out.print(d1 + "  " + d2 + "  " + d3 + "  " + d4);
			System.out.print("\n\n");
			if (d1 == d2 && d2 == d3 && d3 == d4) 
			{
				System.out.println("Quad, you win!\n");
				wins += 1;
			}
			else if ((d1==d2 && d2 == d3 && d3 != d4) || (d1 == d2 && d2 != d3 && d2 == d4) || (d1 != d2 && d1 == d3 && d3 == d4) || (d1 != d2 && d2 == d3 && d3 == d4)) 
			{
				System.out.println("Triple, you win!\n");
				wins += 1;
			}
			else if ((d1 == d2 && d3 == d4) || (d1 == d4 && d2 == d3) || (d1 == d3 && d2 == d4)) 
			{
				System.out.println("Two Pair, you win!\n");
				wins += 1;
			}
			else if ((d1 == 4 && d2 == 4) || (d3 == 4 && d4 == 4) || (d2 == 4 && d3 == 4) || (d1 == 4 && d4 == 4) || (d1 == 4 && d3 == 4) || (d2 == 4 && d4 == 4)) 
			{
				System.out.println("High Pair, you win!\n");
				wins += 1;
			}
			else 
			{
				System.out.println("sorry, you lose!\n");
				losses += 1;
			}
			System.out.print("Would you like to play again? [y,n]: ");
			pa = stdin.next();
			System.out.println("---------------------------------------\n");
			if (pa.equals("n")) 
			{
				done = true;
			}
		}
		while (!done); 
		System.out.println("Done so soon? Here's your cumulative stats:");
		System.out.println("total games played: " + (wins+losses));
		System.out.println("total wins: " + wins);
		System.out.println("total losses: " + losses);
		stdin.close();
	}
}