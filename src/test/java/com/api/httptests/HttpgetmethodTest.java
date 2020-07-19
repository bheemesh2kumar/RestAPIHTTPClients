package com.api.httptests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.api.utilities.Propertiesreader;

public class HttpgetmethodTest extends BaseClass {

	@Test(enabled = false)
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

	@Test(enabled = false)
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

	@Test
	public void validatepostuserdetails() throws ClientProtocolException, IOException {
		String uri = Propertiesreaderref.getposturi();

		HashMap<String, String> HashMapref = new HashMap<String, String>();

		HashMapref.put("Content-Type", "application/json");
		HashMapref.put("Authorization", "Bearer PITCLl8GV4bddDpBsQ_waeQAU59OazV5BE1s");
		HashMapref.put("Accept", "application/json");

		String jsonbody = "{\r\n" + "    \"first_name\": \"bhavishni\",\r\n" + "    \"last_name\": \"manukonda\",\r\n"
				+ "    \"gender\": \"female\",\r\n" + "    \"email\": \"bhavishni9@gmail.com\",\r\n"
				+ "    \"status\": \"active\"\r\n" + "}";

		CloseableHttpResponse ClosableHttpResponse = Httpmethodsref.postmethodwithheaders(uri, jsonbody, HashMapref);

		System.out.println("******************printing status code");
		System.out.println(ClosableHttpResponse.getStatusLine().getStatusCode());

		System.out.println("*****************printing jsson reponse");

		String jsonresponseentity = EntityUtils.toString(ClosableHttpResponse.getEntity(), "UTF-8");

		JSONObject JSONObjectref = new JSONObject(jsonresponseentity);
		System.out.println(JSONObjectref);

	}

}
