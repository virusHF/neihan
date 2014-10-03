package com.fan.neihan.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageURLList {
	private String uri;
	
	private String width;
	private String height;
	private List<String> urlList;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public List<String> geturlList() {
		return urlList;
	}

	public void seturlList(List<String> urlList) {
		this.urlList = urlList;
	}

	private List<String> parseImageurlList(JSONObject largeImage)
			throws JSONException {
		JSONArray urlList = largeImage.getJSONArray("url_list");
		int urlListLen = urlList.length();
		List<String> largeImageurlList = new ArrayList<String>();
		if (urlListLen > 0) {
			for (int j = 0; j < urlListLen; j++) {
				JSONObject uObject = urlList.getJSONObject(j);
				largeImageurlList.add(uObject.getString("url"));

			}
		}
		return largeImageurlList;
	}

	public void parseURLList(JSONObject largeImage) throws JSONException {
		urlList = parseImageurlList(largeImage);
		uri = largeImage.getString("uri");
		width = largeImage.getString("width");
		height = largeImage.getString("height");
	}
	@Override
	public String toString() {
		return "ImageurlList [uri=" + uri + ", width=" + width + ", height="
				+ height + ", urlList=" + urlList + "]";
	}
}
