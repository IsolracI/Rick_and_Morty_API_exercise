package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info{

	@JsonProperty("next")
	private String next;

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("prev")
	private Object prev;

	@JsonProperty("count")
	private int count;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setPages(int pages){
		this.pages = pages;
	}

	public int getPages(){
		return pages;
	}

	public void setPrev(Object prev){
		this.prev = prev;
	}

	public Object getPrev(){
		return prev;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Info{" + 
			"next = '" + next + '\'' + 
			",pages = '" + pages + '\'' + 
			",prev = '" + prev + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}