package com.fan.neihan.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class CommentEntity {
	private String uid;
	private String text;
	private long createTime;
	private int userDigg;
	private long id;
	private int userBury;
	private String userProfileUrl;
	private long userId;
	private int burnCount;
	private int diggCount;
	private String description;
	private boolean userVerfied;
	private String platform;
	private String userName;
	private String userProfileImageUrl;

	/**
	 *  "uid": 0,
                "text": "在无数个夜晚，湿了无数次内裤……手掌的茧子不是拿禅杖弄出来的，禅杖只是个幌子……",
                "create_time": 1411959894,
                "user_digg": 0,
                "id": 3566392940,
                "user_bury": 0,
                "user_profile_url": "",
                "user_id": 3016892161,
                "bury_count": 0,
                "description": "原来发段子要坚持……我删了好多第一次没过的！",
                "digg_count": 1,
                "user_verified": false,
                "platform": "feifei",
                "user_name": "此先生O_O姓彭",
                "user_profile_image_url": "http://p2.pstatp.com/thumb/1187/3484608322"
	 */
	
	public void parseJson(JSONObject json) throws JSONException {
		if(json!=null){
			uid = json.getString("uid");
			text = json.getString("text");
			createTime = json.getLong("create_time");
			userDigg = json.getInt("user_digg");
			id = json.getLong("id");
			userBury=json.getInt("user_bury");
			userProfileUrl=json.getString("user_profile_url");
			userId=json.getLong("user_id");
			burnCount=json.getInt("bury_count");
			description=json.optString("description");
			diggCount = json.getInt("digg_count");
			userVerfied = json.getBoolean("user_verified");
			platform = json.getString("platform");
			userName = json.getString("user_name");
			userProfileImageUrl = json.getString("user_profile_image_url");
			
			
		}
		
	}

	public String getUid() {
		return uid;
	}

	public String getText() {
		return text;
	}

	public long getCreateTime() {
		return createTime;
	}

	public int getUserDigg() {
		return userDigg;
	}

	public long getId() {
		return id;
	}

	public int getUserBury() {
		return userBury;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public long getUserId() {
		return userId;
	}

	public int getBurnCount() {
		return burnCount;
	}

	public int getDiggCount() {
		return diggCount;
	}

	public String getDescription() {
		return description;
	}

	public boolean isUserVerfied() {
		return userVerfied;
	}

	public String getPlatform() {
		return platform;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	@Override
	public String toString() {
		return "CommentEntity [uid=" + uid + ", text=" + text + ", createTime="
				+ createTime + ", userDigg=" + userDigg + ", id=" + id
				+ ", userBury=" + userBury + ", userProfileUrl="
				+ userProfileUrl + ", userId=" + userId + ", burnCount="
				+ burnCount + ", diggCount=" + diggCount + ", description="
				+ description + ", userVerfied=" + userVerfied + ", platform="
				+ platform + ", userName=" + userName
				+ ", userProfileImageUrl=" + userProfileImageUrl + "]";
	}
	

}
