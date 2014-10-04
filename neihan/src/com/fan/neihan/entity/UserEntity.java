package com.fan.neihan.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserEntity {
	private String avatarUrl;//头像网址
	private long userId;//用户id
	private String name;//用户昵称
	private boolean userVerified;//认证
	public void parseJson(JSONObject json) throws JSONException{
		if(json!=null){
			avatarUrl=json.getString("avatar_url");
			userId=json.getLong("user_id");
			name=json.getString("name");
			userVerified=json.getBoolean("user_verified");
		}
	}
	@Override
	public String toString() {
		return "UserEntity [avatarUrl=" + avatarUrl + ", userId=" + userId
				+ ", name=" + name + ", userVerified=" + userVerified + "]";
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public boolean isUserVerified() {
		return userVerified;
	}
}
