package org.iesteis.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("info")
	private Info info;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setInfo(Info info){
		this.info = info;
	}

	public Info getInfo(){
		return info;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + results + '\'' + 
			",info = '" + info + '\'' + 
			"}";
		}
}