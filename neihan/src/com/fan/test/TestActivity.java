/**
 * 测试内容在这里
 */
package com.fan.test;

import java.util.List;

import javax.xml.transform.ErrorListener;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.fan.neihan.R;
import com.fan.neihan.client.ClientAPI;
import com.fan.neihan.entity.CommenList;
import com.fan.neihan.entity.EntityList;
import com.fan.neihan.entity.TextEntity;

public class TestActivity extends Activity implements Response.Listener<String> {
	private final String tag = "TestActivity";
	public int CATEGROY_TEXT = 1;
	public int CATEGROY_IMG = 2;
	private RequestQueue queue;
	private Button button;
	private Long lastTime = 0l;
	int offset = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		queue = Volley.newRequestQueue(this);
		// ClientAPI.getList(queue, CATEGROY_IMG, 30, lastTime, this);
		button = (Button) findViewById(R.id.button1);
		final String groupId = "3550036269";
		button.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				offset = offset + 20;
				ClientAPI.getCommentList(queue, groupId, offset,
						TestActivity.this);
				
				
			}
		});
		ClientAPI.getCommentList(queue, groupId, offset, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	/**
	 * 列表网络接口回调部分
	 * 
	 * @param string
	 */
	// public void onListResponse(String string) {
	// // TODO Auto-generated method stub
	// try {
	//
	// JSONObject json = new JSONObject(string);
	// // 获取根节点下的data数据对象
	// JSONObject object = json.getJSONObject("data");
	// EntityList entitys = new EntityList();
	// entitys.parseJson(object);
	// System.out.println(entitys.isHasMore());
	// if (entitys.isHasMore()) {
	// lastTime = entitys.getMinTime();
	// }
	// String tip = entitys.getTip();
	// System.out.println(entitys.toString());
	//
	// // 此处 将段子集合传给adapter
	//
	// } catch (JSONException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			offset=0;
			JSONObject object = new JSONObject(arg0);
			CommenList commenList = new CommenList();
			commenList.parseJson(object);
			System.out.println(commenList);
			System.out.println(commenList.getToatlNumber());
			
			//TODO 直接把commentlist提交给listview的adapter
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
