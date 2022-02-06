package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	private Properties prop;
	public void loadPropertyFile(InputStream ip) throws IOException
	{
		try {
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception in loading file");
			e.printStackTrace();
		}
	}
	
	public String getValue(String key)
	{
		return prop.getProperty(key);
	}
	

}
