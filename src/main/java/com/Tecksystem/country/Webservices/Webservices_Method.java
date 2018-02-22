package com.Tecksystem.country.Webservices;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices_Method {


	public static Response Post(String uRI,String stringJSON){
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON).and();
		Response response = requestSpecification.post(uRI);
		return response;
	}

	public static Response Get(String uRI){
		RequestSpecification RequestSpecification  =  RestAssured.given();
		RequestSpecification.contentType(ContentType.JSON);
		Response response = RequestSpecification.get(uRI);			
		return response;
	}

	public static Response Put(String uRI,String stringJSON){
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(uRI);
		return response;
	}

	public static Response Delete(String uRI){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(uRI);
		return response;
	}

	public void Geta(String Url) throws ClientProtocolException, IOException, JSONException{

		CloseableHttpClient closablehttpobj	=HttpClients.createDefault();

		HttpGet geturl = new HttpGet(Url); // http get request

		CloseableHttpResponse response=closablehttpobj.execute(geturl);

		// Status code 

		int statuscode =response.getStatusLine().getStatusCode();
		System.out.println("Status code --->"+statuscode);

		//String

		String respstring = EntityUtils.toString(response.getEntity(),"UTF-8");

		//String respstring =EntityUtils.toString(response.getEntity(),"UTF-8");

		JSONObject jsonobj = new JSONObject(respstring);

		System.out.println("Json string response --->"+jsonobj);

		org.apache.http.Header[] headerarray= response.getAllHeaders();

		HashMap<String, String> allheader = new HashMap<String, String>();

		for( Entry header : headerarray){
			allheader.put(header.getName(), header.getValue());

		}

		System.out.println("Allheader array"+allheader);


	}



}
