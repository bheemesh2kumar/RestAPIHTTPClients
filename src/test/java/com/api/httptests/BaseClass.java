package com.api.httptests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.api.httputilities.Httpmethods;
import com.api.utilities.Propertiesreader;

public class BaseClass {

	public Propertiesreader Propertiesreaderref;
	public Httpmethods Httpmethodsref;

	@BeforeMethod
	public void setup() throws IOException {
		Propertiesreaderref = new Propertiesreader();
		Httpmethodsref = new Httpmethods();
	}

}
