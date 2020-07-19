package com.api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesreader

{
	Properties prop;

	public Propertiesreader() throws IOException {
		prop = new Properties();
		try {
			File file = new File(System.getProperty("user.dir") + "\\Configirations\\config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String geturi() {
		String uri = prop.getProperty("domainurl") + prop.getProperty("serviceurl");

		return uri;
	}

	public String getposturi() {
		String uri = prop.getProperty("postdomainurl") + prop.getProperty("postserviceurl");

		return uri;
	}

}
