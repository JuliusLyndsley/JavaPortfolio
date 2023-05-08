
public class Driver
{
	public static void main (String[] args) 
	{
		notDriver driver = new notDriver();
		driver.create("1.txt");
		driver.addTo("1.txt", "2.txt", 1234, 50_000, 3);
		driver.display("2.txt");
//		driver.addTo("2.txt", "3.txt", 9999, 78_000, 8);
//		driver.display("3.txt");
//		driver.removeFrom("3.txt", "4.txt", 1234);
//		driver.display("4.txt");
//		driver.addTo("1.txt", "4.txt", 1234, 50_000, 3);
//		driver.addService("4.txt", "5.txt");
//		driver.display("5.txt");
//		driver.raise("5.txt", "6.txt", 3, 1.15);
//		driver.display("6.txt");
//		driver.mergeFiles("5.txt","6.txt", "7.txt");
//		driver.display("7.txt");
	}
}