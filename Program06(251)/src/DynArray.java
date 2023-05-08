
public class DynArray 
{
	private double[] array;
	private int size;
	private int nextIndex;
	public DynArray()
	{
		array = new double[1]; 
		size = 1 ;
		nextIndex = 0;
	}
	public int arraySize()
	{
		return this.size;
	}
	public int elements()
	{
		return this.nextIndex;
	}
	public double at(int index) {
		if (index >= 0 && index < nextIndex) 
		{
			return this.array[index];
		}
		return Double.NaN;
	}
	private void grow()
	{
		size = (this.size * 2); 
		double tempArray[] = new double [size];
		for (int i = 0; i < elements() - 1; ++i) 
		{
			tempArray[i] = array[i];
		}
		array = tempArray;
	}
	private void shrink() 
	{
		size = (size / 2); 
		double tempArray[] = new double [size];
		for (int i = 0; i < elements(); ++i) 
		{
			tempArray[i] = array[i];
		}	
		array = tempArray;
	}	
	public void insertAt(int index, double value) 
	{
		
		if (index >= 0 && index <= elements()) 
		{
			nextIndex++;
			if (elements() > arraySize()) 
			{
				this.grow();
			}
			int len = array.length;
			for(int i = nextIndex - 1; i > index; i--) 
			{
				this.array[i] = this.array[i -1];
			}
			array[index] = value; 
		}
	}
	public void insert(double value) 
	{
		insertAt(nextIndex, value);
	}
	public double removeAt(int index) 
	{
		if (index >= 0 && index < elements()) 
		{
			double savedValue = this.at(index);
			for(int i = index; i < elements(); i++) 
			{
				this.array[i] = this.at(i+1);
			}
			nextIndex = elements() - 1;
			if (this.elements() * 2 < this.arraySize())
			{
				this.shrink();
			}
			return savedValue;
		}
		else
			return Double.NaN;
	}
	public double remove() 
	{
		return removeAt(this.elements() - 1);
	}
	public void printArray() 
	{
		for (int i = 0; i < elements(); i++) 
		{
			System.out.println(this.at(i) + ", ");
		}
	}
}