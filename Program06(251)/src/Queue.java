
public class Queue extends DynArray
{
	public int size() 
	{
		return super.arraySize();
	}
	public boolean isEmpty() 
	{
		return 0 == (super.elements());
	}
	public void que(double value) 
	{
		super.insert(value);
	}
	public double deQue() {
		if (isEmpty())
		{
			return Double.NaN;
		}
		else
		return super.removeAt(0);
	}
	public void queueDump() {
		super.printArray();
	}
}