package util;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class PropertyReader {
	
	public static String readDataFromPropertyFile(String properyKey,String fileName) {
		
		File file=new File("./data/"+fileName+".properties");
		String propertyValue=null;
		try {
			FileInputStream oFis=new FileInputStream(file);
			Properties properties=new Properties();
			properties.load(oFis);
			propertyValue = properties.getProperty(properyKey);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return propertyValue;
	}
	

}
