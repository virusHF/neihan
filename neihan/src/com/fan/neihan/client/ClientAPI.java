/**
 * 所有和服务器对接的方法，全部在这里面
 */

package com.fan.neihan.client;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.fan.neihan.test.TestActivity;

public class ClientAPI {
	
	
	public static String CATEGROY_LIST_URI = "http://ic.snssdk.com/2/essay/zone/category/data/";

	public static String Comment_LIST_URI="http://isub.snssdk.com/2/data/get_essay_comments/";
	/**
	 * 
	 * @param queue
	 *            Volley请求的队列
	 * @param categroy_type要获取的参数类型
	 * @param itemcount服务器传回的条目数
	 * @param listener用户获取段子列表回调接口
	 *            ，任何调用getlist方法时，此参数用于更新段子列表
	 * @param minTime 用于分页加载数据，下拉刷新时用，代表的是上一次服务器返回的信息
	 * @see #CATEGROY_TEXT
	 * @see #CATEGROY_IMG
	 */
	public static void getList(
			RequestQueue queue, 
			int categroy_type,
			int itemcount,
			long minTime,//如果为零，不进行处理
			Response.Listener<String> listener) {
	
		String categroyInfo = "category_id=" + categroy_type;
		String countParam = "count=" + itemcount;
		String deviceType = "device_type=KFTT";
		String udid = "&openudid=b90ca6a3a19a78d6";
		String url = CATEGROY_LIST_URI
	
				+ "?"
				+ categroyInfo
				+ "&"
				+ countParam
				+ "&"
				+ deviceType
				+ "&"
				+ udid
				+ "&level=6&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&os_api=15&os_version=4.0.3";
	
		if(minTime>0){
			url=url+"&min_time="+minTime;
		}
		
		queue.add(new StringRequest(Method.GET, url, listener,
				new Response.ErrorListener() {
	
					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
	
					}
				}));
		queue.start();
	}

	public static void getCommentList(RequestQueue queue,String groupId, int offset,Listener<String> listener) {
		String url=Comment_LIST_URI
				+"?"
				+"group_id="+groupId
				+"&"
				+"offset="+offset
				+"&count=20&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&device_type=KFTT&os_api=15&os_version=4.0.3&openudid=b90ca6a3a19a78d6";
	
		queue.add(new StringRequest(
				Method.GET,
				url,
				listener, new Response.ErrorListener() {
	
					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
	
					}
				}));
		queue.start();
	}
	

}
