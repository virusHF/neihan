package com.fan.neihan.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity extends TextEntity{

	
	private ImageURLList largeList;
	private ImageURLList meddleList;
	

	public ImageURLList getLargeList() {
		return largeList;
	}

	public void setLargeList(ImageURLList largeList) {
		this.largeList = largeList;
	}

	public ImageURLList getMeddleList() {
		return meddleList;
	}

	public void setMeddleList(ImageURLList meddleList) {
		this.meddleList = meddleList;
	}
	

	public void parseJson(JSONObject json) throws JSONException {
		super.parseJson(json);
		JSONObject group = json.getJSONObject("group");
		largeList = new ImageURLList();
		largeList.parseJson(group.getJSONObject("large_image"));
		meddleList = new ImageURLList();
		meddleList.parseJson(group.getJSONObject("middle_image"));
	}

	@Override
	public String toString() {
		return "ImageEntity [largeList=" + largeList + ", meddleList="
				+ meddleList + ", type=" + type + ", createTime=" + createTime
				+ ", onlineTime=" + onlineTime + ", favoriteCount="
				+ favoriteCount + ", buryCount=" + buryCount + ", userBury="
				+ userBury + ", userFavorite=" + userFavorite + ", shareUrl="
				+ shareUrl + ", label=" + label + ", content=" + content
				+ ", commentCount=" + commentCount + ", status=" + status
				+ ", statusDesc=" + statusDesc + ", hasComments=" + hasComments
				+ ", goDetailCount=" + goDetailCount + ", userDigg=" + userDigg
				+ ", diggCount=" + diggCount + ", groupId=" + groupId
				+ ", level=" + level + ", repinCount=" + repinCount
				+ ", userRepin=" + userRepin + ", hasHotComments="
				+ hasHotComments + ", categoryId=" + categoryId
				+ ", displayTime=" + displayTime + ", user=" + user + "]";
	}
	
}
