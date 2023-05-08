public class Driver 
{
	public static void main(String[] args) 
	{
		Org STARS = new Org( "Umbrella", "Wesker", 2943, 2);
		Org FOXHOUND = new Org("FOXHOUND", "Big Boss", 1963, 1);
		Member David = new Member("David", 5729);
		Member Meryl = new Member("Meryl", 7777);
		Member Leon = new Member("Leon", 1005);
		Member Jill = new Member("Jill", 8592);
		Member Barry = new Member("Barry", 5010);
		STARS.addMember(Leon);
		STARS.addMember(Jill);
		STARS.addMember(David);
		STARS.addMember(Barry);
		FOXHOUND.addMember(Leon);
		FOXHOUND.addMember(David);
		FOXHOUND.addMember(Meryl);
		FOXHOUND.orgDetails();
		STARS.orgDetails();
	}
}
