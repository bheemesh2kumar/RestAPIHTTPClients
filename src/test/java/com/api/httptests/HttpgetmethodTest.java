package com.api.httptests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.utilities.Propertiesreader;

public class HttpgetmethodTest extends BaseClass {

	@Test
	public void httpgettest() throws IOException {

		String uri = Propertiesreaderref.geturi();

		CloseableHttpResponse CloseableHttpResponseref = Httpmethodsref.httpgetmethodwithoutheaders(uri);

		System.out.println("****************Statuscode" + CloseableHttpResponseref.getStatusLine().getStatusCode());

		String jsonresponsestr = EntityUtils.toString(CloseableHttpResponseref.getEntity(), "UTF-8");

		JSONObject JSONObjectref = new JSONObject(jsonresponsestr);

		System.out.println("********************Jsonfile\n" + JSONObjectref);

		Header[] headerarry = CloseableHttpResponseref.getAllHeaders();

		HashMap<String, String> HashMapheaders = new HashMap<String, String>();

		for (Header head : headerarry) {
			HashMapheaders.put(head.getName(), head.getValue());
		}

		System.out.println("*********************printing headers info");

		for (String str : HashMapheaders.keySet()) {
			System.out.println(str + " " + HashMapheaders.get(str));
		}

	}

	@Test
	public void validateapiwitheaders() throws ClientProtocolException, IOException {

		String uri = Propertiesreaderref.geturi();

		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		

		CloseableHttpResponse CloseableHttpResponseref = Httpmethodsref.httpgetwithheaders(uri, headermap);

		System.out.println("****************Statuscode" + CloseableHttpResponseref.getStatusLine().getStatusCode());

		String jsonresponsestr = EntityUtils.toString(CloseableHttpResponseref.getEntity(), "UTF-8");

		JSONObject JSONObjectref = new JSONObject(jsonresponsestr);

		System.out.println("********************Jsonfile\n" + JSONObjectref);

		Header[] headerarry = CloseableHttpResponseref.getAllHeaders();

		HashMap<String, String> HashMapheaders = new HashMap<String, String>();

		for (Header head : headerarry) {
			HashMapheaders.put(head.getName(), head.getValue());
		}

		System.out.println("*********************printing headers info");

		for (String str : HashMapheaders.keySet()) {
			System.out.println(str + " " + HashMapheaders.get(str));
		}

	}

}
