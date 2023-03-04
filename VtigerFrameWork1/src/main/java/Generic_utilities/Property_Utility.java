package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility
{
	/**
	 * this method is used for login to application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Vaishnavi Macharde
	 */
	public String getKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String Value =pro.getProperty(Key);
		return Value;
	}
	

}
