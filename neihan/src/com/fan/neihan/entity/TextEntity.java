package com.fan.neihan.entity;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;

/**
 * 文本段子
 * @author aaa
 * 
 *
 */
public class TextEntity{
	protected int type;
	protected long createTime;
	protected long onlineTime;
	protected int favoriteCount;//赞的个数
	protected int buryCount; //踩的个数
	protected int userBury; //当前用户踩
	protected int userFavorite; //当前用户赞
	protected String shareUrl; //用于第三方分享提交的参数
	// TODO 分析该字段含义
	protected int label;
	protected String content;//文本内容
	protected int commentCount;
	// TODO 分析该字段含义
	protected int status;
	/**
	 * 
	 */
	protected String statusDesc;
	protected int hasComments;
	// TODO 分析字段含义
	protected int goDetailCount;
	// TODO 需要了解含义
	protected int userDigg;
	protected int diggCount;
	protected long groupId;//段子的id
    // TODO 分析含义 两处地方出现
	protected int level;
	protected int repinCount;
	protected int userRepin;//用户是否repin 0代表没有
	protected int hasHotComments;//是否含有热门评论
	protected int categoryId;//1是文本，2是图片
    
	protected long displayTime;
    // TODO 分析comments 这个json内容是啥
	protected UserEntity user;
	
	
    public void parseJson(JSONObject json) throws JSONException{
    	if(json!=null){
    		onlineTime=json.getLong("online_time");
    		displayTime=json.getLong("display_time");
    		JSONObject group=json.getJSONObject("group");
    		createTime=group.getLong("create_time");
    		favoriteCount=group.getInt("favorite_count");
    		userBury=group.getInt("user_bury");
    		userFavorite=group.getInt("user_favorite");
    		buryCount=group.getInt("bury_count");
    		shareUrl=group.getString("share_url");
    		label=group.optInt("label");
    		content=group.getString("content");
    		commentCount=group.getInt("comment_count");
    		status=group.getInt("status");
    		hasComments=group.getInt("has_comments");
    		goDetailCount=group.getInt("go_detail_count");
    		statusDesc=group.getString("status_desc");
    		userDigg=group.getInt("user_digg");
    		level=group.getInt("level");
    		groupId=group.getLong("group_id");
    		repinCount=group.getInt("repin_count");
    		diggCount=group.getInt("digg_count");
    		hasHotComments=group.optInt("has_hot_comments");
    		userRepin=group.getInt("user_repin");
    		categoryId=group.getInt("category_id");
    		type=json.getInt("type");
    		user=new UserEntity();
    		user.parseJson(group.getJSONObject("user"));
    	}
    }


	public int getType() {
		return type;
	}


	public long getCreateTime() {
		return createTime;
	}


	public long getOnlineTime() {
		return onlineTime;
	}


	public int getFavoriteCount() {
		return favoriteCount;
	}


	public int getBuryCount() {
		return buryCount;
	}


	public int getUserBury() {
		return userBury;
	}


	public int getUserFavorite() {
		return userFavorite;
	}


	public String getShareUrl() {
		return shareUrl;
	}


	public int getLabel() {
		return label;
	}


	public String getContent() {
		return content;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public int getStatus() {
		return status;
	}


	public String getStatusDesc() {
		return statusDesc;
	}


	public int getHasComments() {
		return hasComments;
	}


	public int getGoDetailCount() {
		return goDetailCount;
	}


	public int getUserDigg() {
		return userDigg;
	}


	public int getDiggCount() {
		return diggCount;
	}


	public long getGroupId() {
		return groupId;
	}


	public int getLevel() {
		return level;
	}


	public int getRepinCount() {
		return repinCount;
	}


	public int getUserRepin() {
		return userRepin;
	}


	public int getHasHotComments() {
		return hasHotComments;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public long getDisplayTime() {
		return displayTime;
	}


	public UserEntity getUser() {
		return user;
	}


	@Override
	public String toString() {
		return "TextEntity [type=" + type + ", createTime=" + createTime
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
