package com.Tecksystem.country.Testcases;

import java.io.IOException;
import java.util.Enumeration;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tecksystem.country.Utility.EndUrl;
import com.Tecksystem.country.Utility.Enum_Url;
import com.Tecksystem.country.Webservices.Webservices_Method;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.response.Response;



public class GetCountryTC {

	 String Url;
	 Webservices_Method methodget;
	
	@BeforeMethod
	public void setup() {
		
		Url = EndUrl.FixedUrl+Enum_Url.country.getResourcePath();
		
		
	}
	
	@Test
	public void GetCountry() throws IOException, IOException, JSONException
	{
		
		methodget = new Webservices_Method();
		methodget.Geta(Url);
		
		
	}
	
}

	