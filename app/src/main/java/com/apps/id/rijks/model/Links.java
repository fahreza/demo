package com.apps.id.rijks.model;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("web")
	private String web;

	@SerializedName("self")
	private String self;

	public void setWeb(String web){
		this.web = web;
	}

	public String getWeb(){
		return web;
	}

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"web = '" + web + '\'' + 
			",self = '" + self + '\'' + 
			"}";
		}
}