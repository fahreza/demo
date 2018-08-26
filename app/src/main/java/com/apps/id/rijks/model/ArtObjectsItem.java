package com.apps.id.rijks.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ArtObjectsItem{

	@SerializedName("principalOrFirstMaker")
	private String principalOrFirstMaker;

	@SerializedName("webImage")
	private WebImage webImage;

	@SerializedName("headerImage")
	private HeaderImage headerImage;

	@SerializedName("objectNumber")
	private String objectNumber;

	@SerializedName("links")
	private Links links;

	@SerializedName("hasImage")
	private boolean hasImage;

	@SerializedName("showImage")
	private boolean showImage;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("longTitle")
	private String longTitle;

	@SerializedName("permitDownload")
	private boolean permitDownload;

	public void setPrincipalOrFirstMaker(String principalOrFirstMaker){
		this.principalOrFirstMaker = principalOrFirstMaker;
	}

	public String getPrincipalOrFirstMaker(){
		return principalOrFirstMaker;
	}

	public void setWebImage(WebImage webImage){
		this.webImage = webImage;
	}

	public WebImage getWebImage(){
		return webImage;
	}

	public void setHeaderImage(HeaderImage headerImage){
		this.headerImage = headerImage;
	}

	public HeaderImage getHeaderImage(){
		return headerImage;
	}

	public void setObjectNumber(String objectNumber){
		this.objectNumber = objectNumber;
	}

	public String getObjectNumber(){
		return objectNumber;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setHasImage(boolean hasImage){
		this.hasImage = hasImage;
	}

	public boolean isHasImage(){
		return hasImage;
	}

	public void setShowImage(boolean showImage){
		this.showImage = showImage;
	}

	public boolean isShowImage(){
		return showImage;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setLongTitle(String longTitle){
		this.longTitle = longTitle;
	}

	public String getLongTitle(){
		return longTitle;
	}

	public void setPermitDownload(boolean permitDownload){
		this.permitDownload = permitDownload;
	}

	public boolean isPermitDownload(){
		return permitDownload;
	}

	@Override
 	public String toString(){
		return 
			"ArtObjectsItem{" + 
			"principalOrFirstMaker = '" + principalOrFirstMaker + '\'' + 
			",webImage = '" + webImage + '\'' + 
			",headerImage = '" + headerImage + '\'' + 
			",objectNumber = '" + objectNumber + '\'' +
			",links = '" + links + '\'' + 
			",hasImage = '" + hasImage + '\'' + 
			",showImage = '" + showImage + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",longTitle = '" + longTitle + '\'' + 
			",permitDownload = '" + permitDownload + '\'' + 
			"}";
		}
}