package com.api.httptests;

import java.io.File;
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

import com.api.pojos.PostUsers;
import com.api.utilities.Propertiesreader;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Test(enabled = false)
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

	@Test
	public void validatepostmethodusingpojostyle() throws JsonGenerationException, JsonMappingException, IOException {

		String uri = Propertiesreaderref.getposturi();

		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Accept", "application/json");

		PostUsers PostUsersref = new PostUsers();
		PostUsersref.setEmail("eve.holt@reqres.in");
		PostUsersref.setPassword("pistol");

		ObjectMapper ObjectMapperref = new ObjectMapper();

		ObjectMapperref.writeValue(new File("./Jsonfiles//postjson.json"), PostUsersref);

		String jsonrequestentity = ObjectMapperref.writeValueAsString(PostUsersref);

		System.out.println("***********" + jsonrequestentity);

		CloseableHttpResponse response = Httpmethodsref.postmethodwithheaders(uri, jsonrequestentity, headermap);

		System.out.println("status code" + response.getStatusLine().getStatusCode());
		System.out.println("reason pharse" + response.getStatusLine().getReasonPhrase());

		Header[] headerarry = response.getAllHeaders();

		HashMap<String, String> mapheaders = new HashMap<String, String>();

		for (Header header : headerarry) {
			mapheaders.put(header.getName(), header.getValue());
		}

		System.out.println("reasponse headers are displayed below");

		for (Map.Entry<String, String> entry : mapheaders.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		String jsonresponseentry = EntityUtils.toString(response.getEntity(), "UTF-8");

		JSONObject JSONObjectref = new JSONObject(jsonresponseentry);

		System.out.println("Responsejosn file" + JSONObjectref);

		PostUsers PostUsersresobj = ObjectMapperref.readValue(jsonresponseentry, PostUsers.class);

		System.out.println(PostUsersresobj.getId());

		System.out.println(PostUsersresobj.getToken());

	}

}
