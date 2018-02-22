package com.Tecksystem.country.Utility;

public enum Enum_Url {


	country("/USA/all");
	String resourcePath;

	Enum_Url(String resourcePath ) {

		this.resourcePath = resourcePath;

	}
	public String getResourcePath(){
		return this.resourcePath;

	}
	public String getResourcePath(String data){

		return this.resourcePath+data;
	}

}

