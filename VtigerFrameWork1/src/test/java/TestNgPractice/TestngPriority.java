package TestNgPractice;

import org.testng.annotations.Test;

public class TestngPriority 
{
	@Test(priority=1)
	public void create()
	{
		System.out.println("created");
	}
	
	@Test(priority=2)
	public void modify()
	{
		System.out.println("modified");
	}
	
	@Test(priority=3)
	public void delete()
	{
		System.out.println("deleted");
	}



}
