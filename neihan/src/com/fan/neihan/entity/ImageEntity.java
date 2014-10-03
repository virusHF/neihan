package com.fan.neihan.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity {
	
	private int type;
	private long group_id;
	private String content;
	private ImageURLList largeList;
	private ImageURLList meddleList;
	private int comment_count;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public  void parseImage(JSONObject item) throws JSONException {
		type = item.getInt("type");
		JSONObject group=item.getJSONObject("group");
		setComment_count(group.getInt("comment_count"));
		group_id = group.getLong("group_id");
		content = group.getString("content");
		largeList = new ImageURLList();
		largeList.parseURLList(group.getJSONObject("large_image"));
		
		meddleList = new ImageURLList();
		meddleList.parseURLList(group.getJSONObject("middle_image"));
	}



	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	@Override
	public String toString() {
		return "ImageEntity [type=" + type + ", group_id=" + group_id
				+ ", content=" + content + ", largeList=" + largeList
				+ ", meddleList=" + meddleList + ", comment_count="
				+ comment_count + "]";
	}
	
}
