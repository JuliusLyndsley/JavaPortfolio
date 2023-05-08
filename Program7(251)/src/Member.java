
public class Member extends Person 
{
	private int id;
	public Member() 
	{
		super();
		setid(0);

	}
	public int getid() {
		return this.id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public Member(String name, int id) {
		super(name);
		setid(id);
	}
	public String toString() {
		return super.toString() + "; ID Number: " +  this.getid();
	}
}
