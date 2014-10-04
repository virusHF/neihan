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
		JSONObject largeImageList=group.optJSONObject("large_image");
		JSONObject meddleImageList=group.optJSONObject("middle_image");
		largeList = new ImageURLList();
		if(largeImageList==null){
			largeList.parseJson(largeImageList);
		}
		meddleList = new ImageURLList();
		if(meddleImageList==null){
			meddleList.parseJson(meddleImageList);
		}
		
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
