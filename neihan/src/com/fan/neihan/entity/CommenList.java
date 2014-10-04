package com.fan.neihan.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 
 * @author aaa
 *
 */

public class CommenList {
	
	private List<CommentEntity> recentComments;
	private List<CommentEntity> topComments;
	private long groupId;
	private int toatlNumber;
	private boolean hasMore;
	
	
	/**
	 * "has_more": true,
    "message": "success",
    "group_id": 3550036269,
    total_number
	 * @param json
	 * @throws JSONException
	 */
	
	public void parseJson(JSONObject json) throws JSONException {
		if(json!=null){
			
			JSONObject data=json.getJSONObject("data");
			hasMore=json.getBoolean("has_more");//表示评论列表是否还可以继续加载，是否还有新数据
			groupId=json.getLong("group_id");
			toatlNumber=json.getInt("total_number");// 评论的总数
			
			//解析获取到的评论列表，评论列表包含两组数据，一个是热门评论，一个是新鲜评论，都可能为空
			JSONArray rArray=data.getJSONArray("recent_comments");
			JSONArray tArray=data.getJSONArray("top_comments");
			
			if(tArray!=null){
				topComments=new ArrayList<CommentEntity>();
				int len=tArray.length();
				if(len>0){
					for (int i = 0; i < len; i++) {
						JSONObject object=tArray.getJSONObject(i);
						CommentEntity commentEntity=new CommentEntity();
						commentEntity.parseJson(object);
						topComments.add(commentEntity);
					}
				}
				
			}
			
			if(rArray!=null){
				recentComments=new ArrayList<CommentEntity>();
				int len=rArray.length();
				if(len>0){
					for (int i = 0; i < len; i++) {
						JSONObject object=rArray.getJSONObject(i);
						CommentEntity commentEntity=new CommentEntity();
						commentEntity.parseJson(object);
						recentComments.add(commentEntity);
					}
				}
			}
		}
	}


	public List<CommentEntity> getRecentComments() {
		return recentComments;
	}


	public List<CommentEntity> getTopComments() {
		return topComments;
	}


	public long getGroupId() {
		return groupId;
	}


	public int getToatlNumber() {
		return toatlNumber;
	}


	public boolean isHasMore() {
		return hasMore;
	}


	@Override
	public String toString() {
		return "CommenList [recentComments=" + recentComments
				+ ", topComments=" + topComments + ", groupId=" + groupId
				+ ", toatlNumber=" + toatlNumber + ", hasMore=" + hasMore + "]";
	}
}
