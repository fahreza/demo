package com.apps.id.rijks.model;

import com.google.gson.annotations.SerializedName;

public class HeaderImage{

	@SerializedName("offsetPercentageY")
	private int offsetPercentageY;

	@SerializedName("offsetPercentageX")
	private int offsetPercentageX;

	@SerializedName("width")
	private int width;

	@SerializedName("guid")
	private String guid;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public void setOffsetPercentageY(int offsetPercentageY){
		this.offsetPercentageY = offsetPercentageY;
	}

	public int getOffsetPercentageY(){
		return offsetPercentageY;
	}

	public void setOffsetPercentageX(int offsetPercentageX){
		this.offsetPercentageX = offsetPercentageX;
	}

	public int getOffsetPercentageX(){
		return offsetPercentageX;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setGuid(String guid){
		this.guid = guid;
	}

	public String getGuid(){
		return guid;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"HeaderImage{" + 
			"offsetPercentageY = '" + offsetPercentageY + '\'' + 
			",offsetPercentageX = '" + offsetPercentageX + '\'' + 
			",width = '" + width + '\'' + 
			",guid = '" + guid + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}