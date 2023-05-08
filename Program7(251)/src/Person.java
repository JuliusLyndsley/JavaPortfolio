
public class Person 
{
	private String name;
	public String getName() 
	{
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person() 
	{
		setName("");
	}
	public Person(String name) 
	{
		setName(name);
	}
	public String toString() 
	{
		return getName();
	}
}
