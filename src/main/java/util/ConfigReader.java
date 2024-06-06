package util;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;


public class ConfigReader {
	
	public static Properties getPropertyObject() throws IOException
	{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/testData.properties");
		Properties prop = new Properties();
		prop.load(fs);
		return prop;
	}
public static String getBrowser() throws IOException
{
	return getPropertyObject().getProperty("browser");
}
public static String getUrl() throws IOException
{
	return getPropertyObject().getProperty("url");
}
}
