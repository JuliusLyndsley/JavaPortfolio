import java.util.ArrayList;

public class Org 
{
	private String name;
	private Leader leader;
	private ArrayList<Member> members;
	public String getName() {
		return this.name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void addMember(Member member) {
		this.members.add(member);
	}
	public Org() 
	{
		this("","", 0, 0);
	}
	public Org(String orgName, String leaderName, int id, int term) {
		setName(orgName);
		leader = new Leader (leaderName, id, term);
		this.members = new ArrayList<Member>();
	}
	public void orgDetails() {
		System.out.println("Organization name: " + this.getName());
		System.out.println("Leader's name: " + this.leader.toString());
		for (Member member : members)
			System.out.println("\t" + member.toString());
	}
}
