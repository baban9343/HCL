package reusableFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import drivers.StaticVariables;

public class ConfigFileReader {

	public Properties property;
	private final String propertiesFile=StaticVariables.CurrentHomeDirectory+"//configuration//TestProperties.properties";
	
	
	public ConfigFileReader()
	{
		BufferedReader bufferReader;
		try
		{
			bufferReader=new BufferedReader(new FileReader(propertiesFile));
			property=new Properties();
			try
			{
				property.load(bufferReader);
			}catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				bufferReader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public String getPropertyfromPropertiesFile(String propertyName)
	{
		String derivedPropertyName=property.getProperty(propertyName);
		if(derivedPropertyName!=null)
		{
			return derivedPropertyName;
		}else
		{
			return null;
		}
	}
}
