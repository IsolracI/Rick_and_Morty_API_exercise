package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}