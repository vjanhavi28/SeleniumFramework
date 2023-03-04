package TestNgPractice;

import org.testng.annotations.Test;

public class InvocationCount
{
	@Test
	public void cretecontact()
	{
		System.out.println("created");
	}
	
	@Test(invocationCount=2)
	public void modifycontact()
	{
		System.out.println("modified");
	}
	
	@Test(dependsOnMethods="cretecontact")
	public void deletecontact()
	{
		System.out.println("deleted");
	}

}
