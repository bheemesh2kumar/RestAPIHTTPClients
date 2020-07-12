package com.api.httputilities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Httpmethods {

	public CloseableHttpResponse httpgetmethodwithoutheaders(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet HttpGetref = new HttpGet(uri);

		CloseableHttpResponse CloseableHttpResponseref = httpclient.execute(HttpGetref);

		return CloseableHttpResponseref;

	}

}
