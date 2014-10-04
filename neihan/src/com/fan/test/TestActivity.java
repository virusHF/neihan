/**
 * 测试内容在这里
 */
package com.fan.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Entity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import cn.sharesdk.framework.authorize.e;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.fan.neihan.R;
import com.fan.neihan.client.ClientAPI;
import com.fan.neihan.entity.AdEntity;
import com.fan.neihan.entity.ImageEntity;
import com.fan.neihan.entity.TextEntity;

public class TestActivity extends Activity implements Response.Listener<String> {
	private final String tag = "TestActivity";
	public static String CATEGROY_LIST_URI = "http://ic.snssdk.com/2/essay/zone/category/data/";
	public int CATEGROY_TEXT = 1;
	public int CATEGROY_IMG = 2;
	private RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		queue = Volley.newRequestQueue(this);
		ClientAPI.getList(queue, CATEGROY_IMG, 30, this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}
	@Override
	public void onResponse(String string) {
		// TODO Auto-generated method stub
		try {
			
			JSONObject json = new JSONObject(string);
			//获取根节点下的data数据对象
			JSONObject object=json.getJSONObject("data");
			//从data中获取名称为data的数组
			JSONArray array=object.getJSONArray("data");
			int len=array.length();
			if(len>0){
				//遍历数组中的图片段子信息
				for (int i = 0; i < len; i++) {
					JSONObject item=array.getJSONObject(i);
					int type=item.getInt("type");
					if(type==5){
						//TODO 处理广告内容
						AdEntity entity=new AdEntity();
						entity.parseJson(item);
						System.out.println("------1------>"+entity.toString());
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
						System.out.println("------2------>"+entity.toString());
					}
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
