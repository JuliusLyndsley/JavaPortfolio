
public class Stack extends DynArray
{
	public int size() 
	{
		return super.elements();
	}
	public boolean isEmpty() 
	{
		return 0 == (size());
	}
	public double pop() 
	{
		if (this.isEmpty()) 
			return Double.NaN;
		else
			return super.remove();
	}
	public void stackDump()
	{
		for (int i = size() - 1; i >= 0; i--) 
		{
			System.out.println(super.at(i));
		}
		System.out.print("arogiagr");
	}
	public void push(double value) {
		super.insert(value);
	}
}
