package com.fan.neihan.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EntityList {
	
	private boolean hasMore;
	private long minTime;
	private String tip;
	private long maxTime;
	
	private List<TextEntity> entitys;
	public void parseJson(JSONObject json) throws JSONException {
		if (json!=null) {
			hasMore = json.getBoolean("has_more");
			tip = json.getString("tip");
			if(hasMore==true){
					minTime = json.getLong("min_time");
			}
			maxTime = json.optLong("max_time");
			JSONArray array=json.getJSONArray("data");
			int len=array.length();
			if(len>0){
				//遍历数组中的图片段子信息
				entitys=new ArrayList<TextEntity>();
				for (int i = 0; i < len; i++) {
					JSONObject item=array.getJSONObject(i);
					int type=item.getInt("type");
					if(type==5){
						//TODO 处理广告内容
						AdEntity entity=new AdEntity();
						entity.parseJson(item);
						System.out.println("------ad------>"+entity.toString());
					}else if(type==1){
						int cid=item.getJSONObject("group").getInt("category_id");
						TextEntity entity=null;
						if(cid==1){
							//TODO 解析文本段子
							entity=new TextEntity();
						}else {
						   // TODO 解析图片段子
							entity=new ImageEntity();
						}
						entity.parseJson(item);
						entitys.add(entity);
						
					}
				}
			}
		}
	}
	
	public boolean isHasMore() {
		return hasMore;
	}
	public long getMinTime() {
		return minTime;
	}
	public String getTip() {
		return tip;
	}
	public long getMaxTime() {
		return maxTime;
	}
	public List<TextEntity> getEntitys() {
		return entitys;
	}

	@Override
	public String toString() {
		return "EntityList [hasMore=" + hasMore + ", minTime=" + minTime
				+ ", tip=" + tip + ", maxTime=" + maxTime + ", entitys="
				+ entitys + "]";
	}

	
}
