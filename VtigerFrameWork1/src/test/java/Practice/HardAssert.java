package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert 
{
	@Test
	public void createConatct()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		//Hard Assert for pass script
		Assert.assertEquals("A", "A");
		System.out.println("Step 1");
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
	}
	
	/*@Test
	public void modifyContact()
	{
		System.out.println("Step 6");
		System.out.println("Step 7");
		System.out.println("Step 8");
	}*/
	
	@Test
	public void create()
	{
		String expname="Vaishnavi";
		String actname="Vaishnavi";
		Assert.assertEquals(expname, actname);
		// This error we will get java.lang.AssertionError: expected [Sweety] but found [Vaishnavi]
	}

}
