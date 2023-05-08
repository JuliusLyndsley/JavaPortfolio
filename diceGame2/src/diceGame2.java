import java.util.Scanner;
public class diceGame2 
{
	public static void main(String[] args) 
	{
		int d1;
		int d2;
		int d3;
		int d4;
		int d5;
		int d6;
		int wins = 0;
		int losses = 0;
		int ties = 0;
		String play;
		String pa;
		boolean done = false;
		System.out.println("Welcome to Opponent Dice!");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("you will be playing against the opponent\n");
		System.out.println("Triples beat Pairs and Junk");
		System.out.println("Pairs beat Junk");
		System.out.println("In the case of two identical triples/pairs - high card decides");
		System.out.println("in the case of two Junks - its a tie");
		System.out.println("-------------------------------------------------------------------");
		Scanner stdin= new Scanner(System.in);
		System.out.print("Would you like to play? [y,n]: ");
		play = stdin.next();
		do 
		{
			if (play.equals("n")) 
			{
				break;
			}
			d1 = (int)(Math.random() * 6) + 1;
			d2 = (int)(Math.random() * 6) + 1;
			d3 = (int)(Math.random() * 6) + 1;
			d4 = (int)(Math.random() * 6) + 1;
			d5 = (int)(Math.random() * 6) + 1;
			d6 = (int)(Math.random() * 6) + 1;
			System.out.println("  Player ");
			System.out.println("----------");
			System.out.print(d1 + "  " + d2 + "  " + d3);
			System.out.print("\n\n");
			System.out.println("  opponent ");
			System.out.println("----------");
			System.out.print(d4 + "  " + d5 + "  " + d6);
			System.out.print("\n");
			if (d1==d2 && d2==d3 && d3==d4 && d5==d6) // exact match
			{
				System.out.println("2 triples, it's a tie!\n");
				ties+=1;
			}else if(d1==d2 && d2==d3) // user triple win vs junk/pair 
			{
				System.out.println("User triple, you win!\n");
				wins+=1;
			}else if(d4==d5 && d5==d6) // AI triple win vs junk/pair
			{
				System.out.println("Opponent triple, you lose!\n");
				losses+=1;
			}else if((d1==d2 && d2==d3 && d4==d5 && d5==d6) && d1>d4) // User high-triple win
			{
				System.out.println("User high-triple, you win!\n");
				wins+=1;
			}else if((d1==d2 && d2==d3 && d4==d5 && d5==d6) && d1<d4) // opponent high-triple win
			{
				System.out.println("Opponent high-triple, you lose!\n");
				losses+=1;
			}else if((d1!=d2 && d2==d3 && d4!=d5 && d5==d6 && d2>d5) || (d1!=d2 && d2==d3 && d4!=d5 && d5==d6 && d2==d5 && d1>d4)) // User High-pair/uncommon win in position1
			{
				System.out.println("User pair, you win!\n");
				wins+=1;
			}else if((d1!=d2 && d2==d3 && d4!=d5 && d5==d6 && d2<d5) || (d1!=d2 && d2==d3 && d4!=d5 && d5==d6 && d2==d5 && d1<d4)) // Opponent High-pair/uncommon win in position1
			{
				System.out.println("Opponent pair, you lose!\n");
				losses+=1;
			}else if((d1!=d2 && d1==d3 && d4!=d5 && d4==d6 && d1>d4) || (d1!=d2 && d1==d3 && d4!=d5 && d4==d6 && d1==d4 && d2>d5)) // User High-pair/uncommon win in position2
			{
				System.out.println("User pair, you win!\n");
				wins+=1;
			}else if((d1!=d2 && d1==d3 && d4!=d5 && d4==d6 && d1<d4) || (d1!=d2 && d1==d3 && d4!=d5 && d4==d6 && d1==d4 && d2<d5)) // Opponent High-pair/uncommon win in position2
			{
				System.out.println("Opponent pair, you lose!\n");
				losses+=1;
			}else if((d1==d2 && d2!=d3 && d4==d5 && d5!=d6 && d1>d4) || (d1==d2 && d2!=d3 && d4==d5 && d5!=d6 && d1==d4 && d3>d6)) // User High-pair/uncommon win in position3
			{
				System.out.println("User pair, you win!\n");
				wins+=1;
			}else if((d1==d2 && d2!=d3 && d4==d5 && d5!=d6 && d1<d4) || (d1==d2 && d2!=d3 && d4==d5 && d5!=d6 && d1==d4 && d3<d6)) // Opponent High-pair/uncommon win in position3
			{
				System.out.println("Opponent pair, you lose!\n");
				losses+=1;
			}else if(d1!=d2 && d2==d3 || d1!=d2 && d1==d3 || d1==d2 && d2!=d3) // user pair win vs junk
			{
				System.out.println("User pair, you win!\n");
				wins+=1;
			}else if(d4!=d5 && d5==d6 || d4!=d5 && d4==d6 || d4==d5 && d5!=d6) // AI pair win vs junk
			{
				System.out.println("Opponent pair, you lose!\n");
				losses+=1;
			}else // junk
			{
				System.out.println("junk, it's a tie!\n");
				ties+=1;
			}
			System.out.print("Would you like to play again? [y,n]: ");
			pa = stdin.next();
			System.out.println("---------------------------------------\n");
			if (pa.equals("n")) {
				done = true;
			}
		}while (!done);
		System.out.println("Done so soon? Here's your cumulative stats:");
		System.out.println("total games played: " + (wins+losses+ties));
		System.out.println("total wins: " + wins);
		System.out.println("total losses: " + losses);
		System.out.println("total ties: " + ties);
		stdin.close();
	}
}