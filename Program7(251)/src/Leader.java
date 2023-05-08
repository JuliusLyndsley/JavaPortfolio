
public class Leader extends Member
{
	private int term;
	public int getTerm() {
		return this.term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public Leader() 
	{
		super();
		setTerm(0);
	}
	public Leader(String name, int id, int term) 
	{
		super(name, id);
		setTerm(term);
	}
	public String toString() {
		return super.toString() + "" + this.getTerm();
	}
}
