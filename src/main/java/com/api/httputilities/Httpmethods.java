package com.api.httputilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

	public CloseableHttpResponse httpgetwithheaders(String uri, HashMap<String, String> headersmap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet HttpGetref = new HttpGet(uri);

		for (Map.Entry<String, String> entry : headersmap.entrySet()) {

			HttpGetref.addHeader(entry.getKey(), entry.getValue());

		}

		CloseableHttpResponse ClosableHttpresponseref = httpclient.execute(HttpGetref);

		return ClosableHttpresponseref;

	}

}
