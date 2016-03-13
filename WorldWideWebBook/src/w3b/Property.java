package w3b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Property {

	public static String getProp(String property)
	{
	   	Properties prop = new Properties();

    	

			try {
	    		String filename = "config.properties";
	    	     InputStream input;
				input = Property.class.getResourceAsStream(filename);
	    		prop.load(input);

	    		return prop.getProperty(property);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
    	

    		//load a properties file from class path, inside static method

     
	}
    		
}
