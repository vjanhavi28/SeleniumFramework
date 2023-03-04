package TestNgPractice;

import org.testng.annotations.Test;

public class TestNGDependsOnMethods 
{
	@Test
	public void cretecontact()
	{
		System.out.println("created");
	}
	
	@Test(dependsOnMethods="cretecontact")
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
