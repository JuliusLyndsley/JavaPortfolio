import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
public class notDriver implements Raiseable
{
	public void create(String fileName) 
	{
		try
		{
			PrintWriter	fileOut = new PrintWriter(fileName);
			fileOut.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("create error : " + e.getMessage());
		}
	}
	public void display(String fileName) 
	{
		try 
		{
			Scanner read = new Scanner(new File(fileName));
			while (read.hasNextLine()) 
			{
				String data = read.nextLine();
				System.out.println(data);
			}
		}
		catch (IOException e) 
		{
			System.out.println("display error : " + e.getMessage());
		}
	}
	public boolean addTo(String inFileName, String outFileName, int id, double salary, int yearsOfService) 
	{
		int prevId = 0;
		boolean done = false;
		try(Scanner fileIn = new Scanner(Paths.get(inFileName));
				PrintWriter fileOut = new PrintWriter(outFileName))
		{
			if (!fileIn.hasNextLine()) 
			{
				fileOut.println(id + ":" + salary + ":" + yearsOfService);
				done = true;
			}
			else 
			{
				while (fileIn.hasNextLine()) 
				{
					String data = fileIn.nextLine();
					int num = Integer.parseInt(data.substring(0, data.indexOf(":")));
					if(prevId<= id && num >= id)
					{
						fileOut.println(id + ":" + salary + ":" + yearsOfService);
						done = true;
					}
					else {
						fileOut.println(data);
						prevId = num;
					}
				}
				if (done == false) 
				{
					fileOut.println(id + ":" + salary + ":" + yearsOfService);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("addTo Error : " + e.getMessage());
		}
		return done;
	}
	public boolean removeFrom(String inFileName, String outFileName, int id) 
	{
		boolean done = false;
		try(Scanner fileIn = new Scanner(Paths.get(inFileName));
				PrintWriter fileOut = new PrintWriter(outFileName))
		{
			if (!fileIn.hasNextLine()) 
			{
				System.out.print("File is empty!");
			}
			else 
			{
				while (fileIn.hasNextLine()) 
				{
					String data = fileIn.nextLine();
					int num = Integer.parseInt(data.substring(0, data.indexOf(":")));
					if (id == num) 
					{
						done = true;
					}
					else 
					{
						fileOut.println(data);
					}
				}

			}
		}
		catch (Exception e)
		{
			System.out.println("removeFrom error : " + e.getMessage());
		}
		return done;
	}
	public void addService(String inFileName, String outFileName) 
	{
		try(Scanner fileIn = new Scanner(Paths.get(inFileName));
				PrintWriter fileOut = new PrintWriter(outFileName))
		{
			{
				while (fileIn.hasNextLine()) 
				{
					String data = fileIn.nextLine();
					String num = (data.substring(0,data.lastIndexOf(":")));
					int yos = Integer.parseInt(data.substring(data.lastIndexOf(":") + 1));
					fileOut.println(num + ":" + (yos + 1));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("addService error : " + e.getMessage());
		}
	}
	public int raise(String inFileName, String outFileName, int yearsOfService, double salaryIncPercent) 
	{
		int raises = 0;
		try(Scanner fileIn = new Scanner(Paths.get(inFileName));
				PrintWriter fileOut = new PrintWriter(outFileName))
		{
			{
				while (fileIn.hasNextLine()) 
				{

					String data = fileIn.nextLine();
					String id = (data.substring(0,data.indexOf(":")));
					int yos = Integer.parseInt(data.substring(data.lastIndexOf(":") + 1));
					double salary = Double.parseDouble(data.substring((data.indexOf(":") + 1), data.lastIndexOf(":")));
					if (yos >= yearsOfService) 
					{
						salary = salaryIncPercent * salary;
						raises++;
					}
					fileOut.println(id + ":" + salary + ":" + yos);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("raise error : " + e.getMessage());
		}
		return raises;
	}
	public void mergeFiles(String inFileName1, String inFileName2, String outFileName) 
	{
		int maxid = 0;
		try(Scanner fileIn = new Scanner(Paths.get(inFileName1));
				Scanner fileIn2 = new Scanner(Paths.get(inFileName2));
				PrintWriter fileOut = new PrintWriter(outFileName))
		{
			{
				while (fileIn.hasNextLine()) 
				{
					String data = fileIn.nextLine();
					int id = Integer.parseInt(data.substring(0,data.indexOf(":")));
					double salary = Double.parseDouble(data.substring((data.indexOf(":") + 1), data.lastIndexOf(":")));
					while (fileIn2.hasNextLine()) 
					{
						String data2 = fileIn.nextLine();
						int id2 = Integer.parseInt(data.substring(0,data.indexOf(":")));
						double salary2 = Double.parseDouble(data.substring((data.indexOf(":") + 1), data.lastIndexOf(":")));
						if (id == id2) 
						{
							if(salary > salary2) 
							{
								fileOut.println(data);
								System.out.println(data);
							}
							else
								fileOut.println(data2);
							maxid = id;
						}
						else if (id2 > maxid && id2 < id) 
						{
							fileOut.println(data2);
							maxid = id2;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("mergeFiles error : " + e.getMessage());
		}
	}
}